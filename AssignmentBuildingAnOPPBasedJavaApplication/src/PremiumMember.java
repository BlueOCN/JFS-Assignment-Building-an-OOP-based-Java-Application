import java.util.ArrayList;

public class PremiumMember extends Member {

    // Additional Benefits:
    // Borrowing more books
    public PremiumMember() {
        super();
        super.setName("NA");
        super.setMemberId(0);
        super.setBorrowedBooks(new ArrayList<>());
        super.setBorrowingLimit(10);
    }
    public PremiumMember(String name, int memberId, Book borrowedBook) {
        super(name, memberId, borrowedBook); // Call Member's constructor
        super.setBorrowingLimit(10); // Override the borrowing limit
    }
    public PremiumMember(String name, int memberId, ArrayList<Book> borrowedBooks) {
        super(name, memberId, borrowedBooks); // Call Member's constructor
        super.setBorrowingLimit(10); // Override the borrowing limit
    }
}
