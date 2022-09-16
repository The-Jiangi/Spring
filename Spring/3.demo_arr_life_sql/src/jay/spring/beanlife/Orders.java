package jay.spring.beanlife;

public class Orders {
    public String oname;

    public Orders() {
        System.out.println("第一步 执行无参构造创建bean实例");
    }

    public void setOname(String oname) {
        System.out.println("第二步 调用set方法设置属性设置");
        this.oname = oname;
    }

    public void initMethod() {
        System.out.println("第三步 执行初始化的方法");
    }

    public void destroyMethod() {
        System.out.println("第五步 销毁初始化的方法");
    }
}
