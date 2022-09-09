package jay.factory_demo;

public class Book {
    private String bname;
    private String bauthor;
    private String address;

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void testDemo() {
        System.out.println(bname+"::"+bauthor+"::"+address);
    }

//    public static void main(String[] args) {
//        Book book = new Book();
//        book.setBname("西游记");
//        book.setBauthor("jay");
//    }
}
