package jay.bean;

public class Emp {
    private String ename;
    private String egender;
    // 员工属于一个部门，用对象的形式表示
    private Dept dept;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setEgender(String egender) {
        this.egender = egender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public void add() {
        System.out.println("ename"+"::"+egender+"::"+dept.toString());
    }
}
