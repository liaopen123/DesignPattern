package cn.com.almostlover.apt_processor.factorypattern;

import com.google.auto.service.AutoService;

import javax.annotation.processing.Processor;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;

import cn.com.almostlover.apt_annotation.Factory;

public class FactoryAnnotatedClass {


    private final TypeElement annotatedClassElement;
    private final String id;
    private String qualifiedSuperClassName;
    private String simpleTypeName;

    public FactoryAnnotatedClass(TypeElement classElement) throws IllegalArgumentException {
        this.annotatedClassElement = classElement;
        Factory annotation = classElement.getAnnotation(Factory.class);
        id = annotation.id();

        if ("".equals(id)) {
            throw new IllegalArgumentException(
                    String.format(
                            "id() in @%s for class %s is null or empty! that's not allowed",
                            Factory.class.getSimpleName(),
                            classElement.getQualifiedName().toString()));
        }

        // Get the full QualifiedTypeName
        try {
            //如果 这个 clazz 已经被编译过了，那么就不会发生exception，如果没有被编译 MirroredTypeException异常，包含一个TypeMirror，它表示我们未被编译类。
            Class<?> clazz = annotation.type();
            qualifiedSuperClassName = clazz.getCanonicalName();
            simpleTypeName = clazz.getSimpleName();
        } catch (MirroredTypeException e) {
            DeclaredType classTypeMirror = (DeclaredType) e.getTypeMirror();
            TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
            qualifiedSuperClassName = classTypeElement.getQualifiedName().toString();
            simpleTypeName = classTypeElement.getSimpleName().toString();
        }

    }




    public String getId() {
        return id;
    }

    public String getQualifiedFactoryGroupName() {
        return qualifiedSuperClassName;
    }

    public String getSimpleFactoryGroupName() {
        return simpleTypeName;
    }

    public TypeElement getTypeElement() {
        return annotatedClassElement;
    }
}