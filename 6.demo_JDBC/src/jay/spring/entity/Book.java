package jay.spring.entity;

public class Book {
    private String bookId;
    private String bookName;
    private String bStatus;

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getbStatus() {
        return bStatus;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setbStatus(String bStatus) {
        this.bStatus = bStatus;
    }
}
