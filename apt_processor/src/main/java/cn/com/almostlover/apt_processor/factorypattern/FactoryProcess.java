package cn.com.almostlover.apt_processor.factorypattern;

import com.google.auto.service.AutoService;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

import cn.com.almostlover.apt_annotation.Factory;


//@AutoService(Processor.class)
public class FactoryProcess extends AbstractProcessor {


    private Types typeUtils;
    private Elements elementUtils;
    private Filer filer;
    private Messager messager;
    private Map<String, FactoryGroupedClasses> factoryClasses = new LinkedHashMap<String, FactoryGroupedClasses>();

    /**
     * 所有的注解处理器类都必须有一个无参构造函数,所以通过init进行初始化，ProcessingEnvironment 提供了一些实用的工具类
     *
     * @param processingEnv
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        typeUtils = processingEnv.getTypeUtils(); //用来处理 TypeMirror工具类
        elementUtils = processingEnv.getElementUtils();//用来处理Element的工具类  element代表程序中的元素
        filer = processingEnv.getFiler();  //用这个类创建文件
        messager = processingEnv.getMessager();  //为apt报错错误消息，警告信息和其他消息的方式  是用来给那些使用了你的注解处理器的第三方开发者显示信息的。
    }

    /**
     * 类似于java的main方法   //在这里编码实现扫描，处理注解，生成java。
     *
     * @param annotations
     * @param roundEnv    可以查询特定注解标注的元素
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //返回被Factory注解的元素列表   //是元素列表 不是类列表 因为注解可以注解很多类型  属性 方法 都可以
        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(Factory.class)) {
            //如果得到 的注解类型不是class 就报错
            if (annotatedElement.getKind() != ElementKind.CLASS) {
                error(annotatedElement, "only classes can be annoted with @%s", Factory.class.getSimpleName());
                return true; //发现错误  退出解析
            }


            TypeElement typeElement = (TypeElement) annotatedElement;


            try {
                FactoryAnnotatedClass annotatedClass = new FactoryAnnotatedClass(typeElement);
                if (!isValidClass(annotatedClass)) {
                    return true;
                }

                // Everything is fine, so try to add

                FactoryGroupedClasses factoryClass = factoryClasses.get(annotatedClass.getQualifiedFactoryGroupName());
                if (factoryClass != null) {
                    String qualifiedGroupName = annotatedClass.getQualifiedFactoryGroupName();
                    factoryClass = new FactoryGroupedClasses(qualifiedGroupName);
                    factoryClasses.put(qualifiedGroupName, factoryClass);
                }

                factoryClass.add(annotatedClass);

            } catch (IllegalArgumentException e) {
                error(typeElement, e.getMessage());
                return true;
            } catch (IdAlreadyUsedException e) {
                FactoryAnnotatedClass existing = e.getExisting();

                error(annotatedElement,
                        "Conflict: The class %s is annotated with @%s with id ='%s' but %s already uses the same id",
                        typeElement.getQualifiedName().toString(), Factory.class.getSimpleName(),
                        existing.getTypeElement().getQualifiedName().toString());
                return true;
            }

            //为每个工厂生产java文件   核心代码  生成java文件
            try {
                for(FactoryGroupedClasses factoryClass:factoryClasses.values()){
                    factoryClass.generateCode(elementUtils,filer);
                }
                // Clear to fix the problem
//                factoryClasses.clear();

            } catch (IOException e) {
                error(null, e.getMessage());
            }
            return true;
        }


        return false;
    }

    private void error(Element e, String msg, Object... args) {
        messager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args), e);

    }

    /**
     * 指定  哪些注解   应该被注解处理器注册
     *
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        LinkedHashSet<String> annotations = new LinkedHashSet<>();
        annotations.add(Factory.class.getCanonicalName());
        return super.getSupportedAnnotationTypes();
    }

    /**
     * 用来指定你使用的 java 版本。通常应该返回SourceVersion.latestSupported()
     *
     * @return
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }


    private boolean isValidClass(FactoryAnnotatedClass item) {

        // Cast to TypeElement, has more type specific methods
        TypeElement classElement = item.getTypeElement();
        //1.类必须是public的
        if (!classElement.getModifiers().contains(Modifier.PUBLIC)) {
            error(classElement, "The class %s is not public.", classElement
                    .getQualifiedName().toString());
            return false;
        }
        //2.类不能是抽象的
        // Check if it's an abstract class
        if (classElement.getModifiers().contains(Modifier.ABSTRACT)) {
            error(classElement,
                    "The class %s is abstract. You can't annotate abstract classes with @%",
                    classElement.getQualifiedName().toString(),
                    Factory.class.getSimpleName());
            return false;
        }
        //3.类必须是@Factoy.type()指定的类型的子类或者接口的实现
        // Check inheritance: Class must be childclass as specified in
        // @Factory.type();
        TypeElement superClassElement = elementUtils.getTypeElement(item.getQualifiedFactoryGroupName());
        //3.1如果它是一个接口，就判断classElement.getInterfaces().contains(superClassElement.asType())
        if (superClassElement.getKind() == ElementKind.INTERFACE) {
            // Check interface implemented
            if (!classElement.getInterfaces().contains(
                    superClassElement.asType())) {
                error(classElement,
                        "The class %s annotated with @%s must implement the interface %s",
                        classElement.getQualifiedName().toString(),
                        Factory.class.getSimpleName(), item.getQualifiedFactoryGroupName());
                return false;
            }
        } else {
            // Check subclassing
            TypeElement currentClass = classElement;
            //3.2如果是类，我们就必须使用currentClass.getSuperclass()扫描继承树
            while (true) {
                TypeMirror superClassType = currentClass.getSuperclass();
                //类必须有一个public的无参构造函数：我们遍历所有该类直接封装的元素
                if (superClassType.getKind() == TypeKind.NONE) {
                    // Basis class (java.lang.Object) reached, so exit
                    error(classElement,
                            "The class %s annotated with @%s must inherit from %s",
                            classElement.getQualifiedName().toString(),
                            Factory.class.getSimpleName(),
                            item.getQualifiedFactoryGroupName());
                    return false;
                }
                if (superClassType.toString().equals(
                        item.getQualifiedFactoryGroupName())) {
                    // Required super class found
                    break;
                }

                // Moving up in inheritance tree
                currentClass = (TypeElement) typeUtils
                        .asElement(superClassType);
            }
        }
        // Check if an empty public constructor is given
        for (Element enclosed : classElement.getEnclosedElements()) {
            if (enclosed.getKind() == ElementKind.CONSTRUCTOR) {
                ExecutableElement constructorElement = (ExecutableElement) enclosed;
                if (constructorElement.getParameters().size() == 0
                        && constructorElement.getModifiers().contains(
                        Modifier.PUBLIC)) {
                    // Found an empty constructor
                    return true;
                }
            }
        }

        // No empty constructor found
        error(classElement,
                "The class %s must provide an public empty default constructor",
                classElement.getQualifiedName().toString());
        return false;
    }


}
