package jay.spring.collectiontype;

import java.util.List;

public class Book {
    private List<String> bookList;
    private String bname;

    public void setBookList(List<String> bookList) {
        this.bookList = bookList;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBname() {
        return bname;
    }

    public void test() {
        System.out.println(bookList);
    }
}
