import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents a library member in the system, including their personal details, borrowed books and benefits.
 */
public class Member {

    /**
     * The name of the member. Used for identifying the member.
     */
    private String name;

    /**
     * The unique identifier for the member.
     * Must be a String and serves as an ID for the member.
     */
    private String memberId;

    /**
     * A list of books borrowed by the member.
     * Initially empty but updated when books are borrowed.
     */
    private ArrayList<Book> borrowedBooks;

    /**
     * The maximum number of books the member can borrow.
     * Default value is set to 3.
     */
    private int borrowingLimit = 3;

    // Constructor
    /**
     * Default constructor for the Member class.
     * Initializes the member with default values:
     * - Name is set to "FirstName LastName".
     * - Member ID is set to 0.
     * - Creates an empty list for borrowed books.
     */
    public Member() {
        this.name = "FirstName LastName";
        this.memberId = UUID.randomUUID().toString();
        this.borrowedBooks = new ArrayList<>();
    }

    /**
     * Constructs a Member object with the specified name and a borrowed book.
     * Initializes the list of borrowed books and adds the provided book to the list.
     *
     * @param name The name of the member.
     * @param borrowedBook The initial book borrowed by the member, added to the list of borrowed books.
     */
    public Member(String name, Book borrowedBook) {
        this.setName(name);
        this.memberId = UUID.randomUUID().toString();
        this.borrowedBooks = new ArrayList<>();
        this.borrowedBooks.add(borrowedBook);
    }

    /**
     * Constructs a Member object with the specified name, member ID, and a list of borrowed books.
     * Initializes the list of borrowed books and adds the provided books to the list.
     *
     * @param name The name of the member.
     * @param borrowedBooks The initial books borrowed by the member, added to the list of borrowed books.
     */
    public Member(String name, ArrayList<Book> borrowedBooks) {
        this.setName(name);
        this.memberId = UUID.randomUUID().toString();
        this.borrowedBooks = borrowedBooks;
    }

    /**
     * Constructs a Member object with the specified name, member ID, and a borrowed book.
     * Initializes the list of borrowed books and adds the provided book to the list.
     *
     * @param name The name of the member.
     * @param memberId The unique identifier for the member.
     * @param borrowedBook The initial book borrowed by the member, added to the list of borrowed books.
     */
    public Member(String name, String memberId, Book borrowedBook) {
        this.setName(name);
        this.setMemberId(memberId);
        this.borrowedBooks = new ArrayList<>();
        this.borrowedBooks.add(borrowedBook);
    }

    /**
     * Constructs a Member object with the specified name, member ID, and a list of borrowed books.
     * Initializes the list of borrowed books and adds the provided books to the list.
     *
     * @param name The name of the member.
     * @param memberId The unique identifier for the member.
     * @param borrowedBooks The initial books borrowed by the member, added to the list of borrowed books.
     */
    public Member(String name, String memberId, ArrayList<Book> borrowedBooks) {
        this.setName(name);
        this.setMemberId(memberId);
        this.borrowedBooks = borrowedBooks;
    }

    /**
     * Retrieves the name of the member.
     *
     * @return The name of the member as a String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Updates the name of the member with validation to ensure data integrity.
     *
     * @param name The new name to be assigned. Must be non-null, at least 2 characters long,
     *             no longer than 50 characters, contain only letters and spaces, and
     *             include at least a first and last name.
     * @throws IllegalArgumentException If the name is null, empty, too short, too long,
     *                                  contains invalid characters, or lacks a first and last name.
     */
    public void setName(String name) {

        try {
            isValidName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.name = name.trim();
    }

    /**
     * Retrieves the id of the member.
     *
     * @return The id of the member as an Integer.
     */
    public String getMemberId() {
        return this.memberId;
    }

    /**
     * Updates the id of the member.
     *
     * @param memberId The new id to be assigned to the member.
     */
    public void setMemberId(String memberId) {

        try {
            isValidMemberId(memberId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.memberId = memberId;
    }

    /**
     * Retrieves the list of borrowed books associated to the member.
     *
     * @return The list of borrowed books associated to the member as an Array List of Books.
     */
    public ArrayList<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    /**
     * Updates the list of borrowed books for the member with validation.
     *
     * @param borrowedBooks The new list of books to be assigned to the member.
     *                      Must not be null, contain null entries, or exceed the borrowing limit.
     * @throws IllegalArgumentException If the provided list is null.
     * @throws IllegalArgumentException If the list contains null book entries.
     * @throws IllegalArgumentException If the size of the list exceeds the borrowing limit.
     */
    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {

        try {
            areValidBorrowedBooks(borrowedBooks);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.borrowedBooks = borrowedBooks;
    }

    /**
     * Retrieves the borrowing limit for the member.
     *
     * @return The maximum number of books the member is allowed to borrow, as an integer.
     */
    public int getBorrowingLimit() {
        return this.borrowingLimit;
    }

    /**
     * Updates the borrowing limit for the member with validation.
     *
     * @param borrowingLimit The new maximum number of books the member can borrow.
     * @throws IllegalArgumentException If the borrowing limit is negative or set below the
     *                                  current number of borrowed books.
     */
    public void setBorrowingLimit(int borrowingLimit) {

        try {
            isValidBorrowingLimit(borrowingLimit);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.borrowingLimit = borrowingLimit;
    }

    /**
     * Allows the member to borrow a single book while enforcing borrowing limits.
     *
     * @param borrowedBook The book to be added to the borrowed books list.
     * @throws IllegalArgumentException If the book is null or borrowing it exceeds the borrowing limit.
     */
    public void borrowBook(Book borrowedBook) {
        if (borrowedBook == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (this.borrowedBooks.size() + 1 > borrowingLimit) {
            throw new IllegalArgumentException("Borrowing limit exceeded: You need to return "
                    + (borrowingLimit - this.borrowedBooks.size()) + " book(s) before borrowing more books");
        }
        this.borrowedBooks.add(borrowedBook);
    }

    /**
     * Allows the member to borrow multiple books at once while checking borrowing limits.
     *
     * @param booksList The list of books to be added to the list of borrowed books.
     *                  Must not be null or contain null entries.
     * @throws IllegalArgumentException If the books list is null.
     * @throws IllegalArgumentException If the books list contains null entries.
     * @throws IllegalArgumentException If borrowing these books exceeds the borrowing limit.
     */
    public void borrowBooks(ArrayList<Book> booksList) {

        // Ensures the provided borrowedBooks list is not null
        if (borrowedBooks == null) {
            throw new IllegalArgumentException("Borrowed books list cannot be null.");
        }

        // Check for null books in the list
        for (Book book : borrowedBooks) {
            if (book == null) {
                throw new IllegalArgumentException("Borrowed books list cannot contain null entries.");
            }
        }

        // Validate that the borrowing limit won't be exceeded
        if (this.borrowedBooks.size() + booksList.size() > borrowingLimit) {
            throw new IllegalArgumentException("Borrowing limit exceeded: You need to return "
                    + (this.borrowedBooks.size() + borrowedBooks.size() - borrowingLimit) + " book(s) before borrowing more books");
        }
        this.borrowedBooks.addAll(booksList);
    }

    /**
     * Displays the details of the member and the list of borrowed books in a formatted table.
     * <p>
     * Prints the member's name and ID, followed by a table of borrowed books including:
     * - Title
     * - Author
     * - ID
     * - ISBN
     * - Availability status
     * <p>
     * Formats the table for improved readability using ANSI escape codes for text styling.
     */
    public void displayDetails() {
        System.out.println("-".repeat(165));
        System.out.printf("|  \033[1mMember:\033[0m %-56s\033[1mId:\033[0m %-56s", name, memberId);
        System.out.print(" ".repeat(37));
        System.out.println("|");
        System.out.print("|  \033[1mBorrowed Books:\033[0m");
        System.out.print(" ".repeat(146));
        System.out.println("|");
        System.out.println("-".repeat(165));
        System.out.printf("| %-45s| %-60s| %-46s| %-22s| %-21s|\n",
                "\033[1m" + "Id" + "\033[0m",
                "\033[1m" + "Title" + "\033[0m",
                "\033[1m" + "Author" + "\033[0m",
                "\033[1m" + "ISBN" + "\033[0m",
                "\033[1m" + "Availability" + "\033[0m");

        // Print table rows
        for (Book book : borrowedBooks) {
            System.out.printf("| %-37s| %-52s| %-38s| %-14s| %-13s|\n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getISBN(),
                    book.getAvailability());
        }
        System.out.println("-".repeat(165));
    }

    public static void isValidName(String name) {

        String tmpName = name.trim();

        if (tmpName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (tmpName.length() < 2) {
            throw new IllegalArgumentException("Name must be at least 2 characters long.");
        }
        if (tmpName.length() > 50) {
            throw new IllegalArgumentException("Name cannot be longer than 50 characters.");
        }
        if (!tmpName.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Name can only contain letters and spaces.");
        }
        if (!tmpName.contains(" ")) {
            throw new IllegalArgumentException("Name must include at least a first and last name.");
        }
    }

    public static void isValidMemberId(String memberId) {
        try {
            // Validate the member ID by attempting to parse it as a UUID.
            UUID.fromString(memberId);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Member ID. It must follow the UUID format.");
        }
    }

    public void areValidBorrowedBooks(ArrayList<Book> borrowedBooks) {

        // Ensures the provided borrowedBooks list is not null
        if (borrowedBooks == null) {
            throw new IllegalArgumentException("Borrowed books list cannot be null.");
        }

        // Check for null books in the list
        for (Book book : borrowedBooks) {
            if (book == null) {
                throw new IllegalArgumentException("Borrowed books on the borrowed list cannot contain null entries.");
            }
            if (book.getAvailability()){
                throw new IllegalArgumentException("Borrowed book on the borrowed list cannot be available.");
            }
        }

        // Ensure the size of the list does not exceed the borrowing limit
        if (borrowedBooks.size() > (borrowingLimit - this.borrowedBooks.size())) {
            throw new IllegalArgumentException("Borrowed books list exceeds the borrowing limit of " + borrowingLimit + " books.");
        }
    }

    public void isValidBorrowingLimit(int borrowingLimit) {
        if (borrowingLimit < 0) {
            throw new IllegalArgumentException("Borrowing limit cannot be negative.");
        }
        if (borrowingLimit < this.borrowedBooks.size()) {
            throw new IllegalArgumentException("Borrowing limit cannot be less than the number of currently borrowed books (" + this.borrowedBooks.size() + ").");
        }
    }

    /**
     * Generates a JSON-like string representation of the Member object.
     * <p>
     * The string includes the following details:
     * - Member's name
     * - Member's ID
     * - Member's borrowing limit
     * - List of borrowed books
     *
     * @return A formatted string representation of the Member object.
     */
    @Override
    public String toString() {
        return "{\n" +
                "  \"memberId\": " + memberId + ",\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"borrowingLimit\": " + borrowingLimit + ",\n" +
                "  \"borrowedBooks\": " + borrowedBooks + "\n" +
                "}";
    }
}
