import java.util.ArrayList;

public class Member {

    // Attributes: name, memberId and borrowedBooks.
    private String name;
    private int memberId;
    private ArrayList<Book> borrowedBooks;
    private int borrowingLimit = 3;

    // Constructor
    public Member() {
        this.name = "NA";
        this.memberId = 0;
        this.borrowedBooks = new ArrayList<>();
    }
    public Member(String name, int memberId, Book borrowedBook) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
        this.borrowedBooks.add(borrowedBook);
    }
    public Member(String name, int memberId, ArrayList<Book> borrowedBooks) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = borrowedBooks;
    }

    // Methods: ???

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public int getBorrowingLimit() {
        return borrowingLimit;
    }

    public void setBorrowingLimit(int borrowingLimit) {
        this.borrowingLimit = borrowingLimit;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"memberId\": " + memberId + ",\n" +
                "  \"borrowedBooks\": " + borrowedBooks + "\n" +
                "}";
    }
}
