import java.util.ArrayList;

public class PremiumMember extends Member {

    private final int premiumLimit = 10;

    // Additional Benefits:
    // Borrowing more books
    public PremiumMember() {
        super();
        super.setName("NA");
        super.setMemberId(0);
        super.setBorrowedBooks(new ArrayList<>());
        super.setBorrowingLimit(premiumLimit); // Override the borrowing limit
    }
    public PremiumMember(String name, int memberId, Book borrowedBook) {
        super(name, memberId, borrowedBook); // Call Member's constructor
        super.setBorrowingLimit(premiumLimit); // Override the borrowing limit
    }
    public PremiumMember(String name, int memberId, ArrayList<Book> borrowedBooks) {
        super(name, memberId, borrowedBooks); // Call Member's constructor
        super.setBorrowingLimit(premiumLimit); // Override the borrowing limit
    }

    @Override
    public void borrowBook(Book borrowedBook) {
        if (super.getBorrowedBooks().size() + 1 > premiumLimit) {
            throw new IllegalArgumentException("Borrowing limit exceeded: You will need to leave "
                    + (premiumLimit - super.getBorrowedBooks().size()) + " or more books");
        }
        super.getBorrowedBooks().add(borrowedBook);
    }

    @Override
    public void borrowBooks(ArrayList<Book> booksList) {
        if (super.getBorrowedBooks().size() + booksList.size() > premiumLimit) {
            throw new IllegalArgumentException("Borrowing limit exceeded: You will need to leave "
                    + (premiumLimit - super.getBorrowedBooks().size()) + " or more books");
        }
        for (Book book : booksList) {
            super.getBorrowedBooks().add(book);
        }
    }
}
