import java.util.ArrayList;

public class PremiumMember extends Member {

    private final int premiumLimit = 10;

    // Additional Benefits:
    // Borrowing more books
    public PremiumMember() {
        super();
        super.setBorrowingLimit(premiumLimit); // Override the borrowing limit
    }
    public PremiumMember(String name, Book borrowedBook) {
        super(name, borrowedBook); // Call Member's constructor
        super.setBorrowingLimit(premiumLimit); // Override the borrowing limit
    }
    public PremiumMember(String name, ArrayList<Book> borrowedBooks) {
        super(name, borrowedBooks); // Call Member's constructor
        super.setBorrowingLimit(premiumLimit); // Override the borrowing limit
    }
    public PremiumMember(String name, String memberId, Book borrowedBook) {
        super(name, memberId, borrowedBook); // Call Member's constructor
        super.setBorrowingLimit(premiumLimit); // Override the borrowing limit
    }
    public PremiumMember(String name, String memberId, ArrayList<Book> borrowedBooks) {
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
