package cn.com.almostlover.multithread.multi_thread_mode1.finalmode;


public final class Product { //final修饰 确保没有子类
    private final String no;  //私有属性 不能被其他获取 final 不会被赋值2次
    private final String name;
    private final String price;

    //赋值的唯一入口 一旦创建 不可改变
    public Product(String no, String name, String price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }
    public String getNo() {
        return no;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
}
