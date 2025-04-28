import java.util.ArrayList;

/**
 * Represents a premium member of the library system.
 * Premium members have a higher borrowing limit compared to regular members.
 */
public class PremiumMember extends Member {

    /**
     * The maximum number of books that a premium member can borrow at any given time.
     * This limit is specific to premium members.
     */
    private final int premiumLimit = 10;

    /**
     * Default constructor for PremiumMember.
     * Initializes the member and sets the borrowing limit to the premium limit.
     */
    public PremiumMember() {
        super();
        super.setBorrowingLimit(premiumLimit); // Override the borrowing limit
    }


    /**
     * Constructor for PremiumMember that initializes the member with a name and a borrowed book.
     * Sets the borrowing limit to the premium limit.
     *
     * @param name The name of the member.
     * @param borrowedBook The book borrowed by the member.
     */
    public PremiumMember(String name, Book borrowedBook) {
        super(name, borrowedBook); // Call Member's constructor
        super.setBorrowingLimit(premiumLimit); // Override the borrowing limit
    }

    /**
     * Constructor for PremiumMember that initializes the member with a name and a list of borrowed books.
     * Sets the borrowing limit to the premium limit.
     *
     * @param name The name of the member.
     * @param borrowedBooks The list of books borrowed by the member.
     */
    public PremiumMember(String name, ArrayList<Book> borrowedBooks) {
        super(name, borrowedBooks); // Call Member's constructor
        super.setBorrowingLimit(premiumLimit); // Override the borrowing limit
    }

    /**
     * Constructor for PremiumMember that initializes the member with a name, a member ID, and a borrowed book.
     * Sets the borrowing limit to the premium limit.
     *
     * @param name The name of the member.
     * @param memberId The unique ID of the member.
     * @param borrowedBook The book borrowed by the member.
     */
    public PremiumMember(String name, String memberId, Book borrowedBook) {
        super(name, memberId, borrowedBook); // Call Member's constructor
        super.setBorrowingLimit(premiumLimit); // Override the borrowing limit
    }

    /**
     * Constructor for PremiumMember that initializes the member with a name, a member ID, and a list of borrowed books.
     * Sets the borrowing limit to the premium limit.
     *
     * @param name The name of the member.
     * @param memberId The unique ID of the member.
     * @param borrowedBooks The list of books borrowed by the member.
     */
    public PremiumMember(String name, String memberId, ArrayList<Book> borrowedBooks) {
        super(name, memberId, borrowedBooks); // Call Member's constructor
        super.setBorrowingLimit(premiumLimit); // Override the borrowing limit
    }

    /**
     * Retrieves the borrowing limit for the member.
     *
     * @return The maximum number of books the member is allowed to borrow, as an integer.
     */
    @Override
    public int getBorrowingLimit() {
        return super.getBorrowingLimit();
    }

    /**
     * Sets the borrowing limit for the member with validation to ensure data integrity.
     *
     * The borrowing limit cannot be negative, below the premium limit, or less than the
     * current number of borrowed books. Ensures that the borrowing limit is logical
     * and consistent with the member's borrowing status.
     *
     * @param borrowingLimit The new borrowing limit to be assigned to the member.
     *                       Must be non-negative and greater than or equal to both
     *                       the premium limit and the number of currently borrowed books.
     * @throws IllegalArgumentException If the borrowing limit is negative.
     * @throws IllegalArgumentException If the borrowing limit is below the premium limit.
     * @throws IllegalArgumentException If the borrowing limit is less than the number of
     *                                  currently borrowed books.
     */
    @Override
    public void setBorrowingLimit(int borrowingLimit) {

        // Validate that the borrowing limit is not negative
        if (borrowingLimit < 0) {
            throw new IllegalArgumentException("Borrowing limit cannot be negative.");
        }

        // Ensure the borrowing limit respects the premium limit
        if (borrowingLimit < premiumLimit) {
            throw new IllegalArgumentException("New borrowing limit cannot be bellow premium limit.");
        }

        // Check that the borrowing limit accommodates the currently borrowed books
        int currentBorrowedBooks = super.getBorrowedBooks().size();
        if (borrowingLimit < currentBorrowedBooks) {
            throw new IllegalArgumentException("Borrowing limit cannot be less than the number of currently borrowed books (" + currentBorrowedBooks + ").");
        }
        super.setBorrowingLimit(borrowingLimit);
    }

    /**
     * Allows the premium member to borrow a single book while enforcing borrowing limits.
     *
     * @param borrowedBook The book to be added to the borrowed books list.
     * @throws IllegalArgumentException If the book is null or borrowing it exceeds the premium borrowing limit.
     */
    @Override
    public void borrowBook(Book borrowedBook) {

        // Ensures the provided borrowedBook is not null
        if (borrowedBook == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }

        // Validate that the borrowing limit won't be exceeded
        if (super.getBorrowedBooks().size() + 1 > super.getBorrowingLimit()) {
            throw new IllegalArgumentException("Borrowing limit exceeded: You need to return "
                    + (super.getBorrowingLimit() - super.getBorrowedBooks().size()) + " book(s) before borrowing more books");
        }
        super.getBorrowedBooks().add(borrowedBook);
    }


    /**
     * Allows the premium member to borrow multiple books at once while checking borrowing limits.
     *
     * @param booksList The list of books to be added to the list of borrowed books.
     *                  Must not be null or contain null entries.
     * @throws IllegalArgumentException If the books list is null.
     * @throws IllegalArgumentException If the books list contains null entries.
     * @throws IllegalArgumentException If borrowing these books exceeds the premium borrowing limit.
     */
    @Override
    public void borrowBooks(ArrayList<Book> booksList) {

        // Ensures the provided borrowedBooks list is not null
        if (booksList == null) {
            throw new IllegalArgumentException("Borrowed books list cannot be null.");
        }

        // Check for null books in the list
        for (Book book : booksList) {
            if (book == null) {
                throw new IllegalArgumentException("Borrowed books list cannot contain null entries.");
            }
        }

        // Validate that the borrowing limit won't be exceeded
        if (super.getBorrowedBooks().size() + booksList.size() > super.getBorrowingLimit()) {
            throw new IllegalArgumentException("Borrowing limit exceeded: You need to return "
                    + (super.getBorrowingLimit() - super.getBorrowedBooks().size()) + " book(s) before borrowing more books");
        }
        super.getBorrowedBooks().addAll(booksList);
    }
}
