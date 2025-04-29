import java.util.ArrayList;

/**
 * Represents a library system that manages collections of books and members.
 * <p>
 * This class includes functionalities to handle:
 * - Books: Adding, assigning, displaying, and validating book collections.
 * - Members: Registering, assigning books, displaying, and validating member collections.
 * <p>
 * Key Features:
 * - Maintains two main collections: {@code booksCollection} and {@code membersCollection}.
 * - Provides methods for robust management of library operations.
 * <p>
 * This class assumes that valid book and member objects are provided for its operations.
 */
public class Library {

    /**
     * Represents the collection of books in the library.
     * <p>
     * Each book in this collection must be a valid instance of the Book class,
     * containing attributes such as title, author, ISBN, and availability.
     */
    private ArrayList<Book> booksCollection;

    /**
     * Represents the collection of members registered in the library system.
     * <p>
     * Each member in this collection must be a valid instance of the Member class,
     * with attributes such as ID, name, and membership details.
     */
    private ArrayList<Member> membersCollection;

    /**
     * Default constructor for the Library class.
     * <p>
     * Initializes a Library object with empty collections for books and members.
     * Both collections are instantiated as new ArrayList objects.
     */
    public Library() {
        booksCollection = new ArrayList<>();
        membersCollection = new ArrayList<>();
    }

    /**
     * Constructor for the Library class that initializes the library with given collections of books and members.
     * <p>
     * Validates and sets the provided books collection and members collection using their respective setter methods.
     *
     * @param booksCollection The collection of books to be assigned to the library. Must be non-null and contain valid book objects.
     * @param membersCollection The collection of members to be assigned to the library. Must be non-null and contain valid member objects.
     * @throws IllegalArgumentException If the books or members collections fail validation.
     */
    public Library(ArrayList<Book> booksCollection, ArrayList<Member> membersCollection) {
        setBooksCollection(booksCollection);
        setMembersCollection(membersCollection);
    }

    /**
     * Retrieves the collection of books.
     *
     * @return an arrayList of integers representing the books collection
     */
    public ArrayList<Book> getBooksCollection() {
        return booksCollection;
    }

    /**
     * Sets the books collection for the library with validation to ensure data integrity.
     * <p>
     * This method uses the static method {@code Book.areValidBooksCollection()} to validate the provided
     * collection of books. If the validation fails, an exception is thrown. The validated collection
     * is then assigned to the {@code booksCollection} field.
     *
     * @param booksCollection The collection of books to be assigned to the library.
     *                        Must be non-null and meet all validation requirements.
     * @throws RuntimeException If the books collection fails validation.
     */
    public void setBooksCollection(ArrayList<Book> booksCollection) {

        try {
            Book.areValidBooksCollection(booksCollection);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        this.booksCollection = booksCollection;
    }

    /**
     * Retrieves the collection of members.
     *
     * @return an arrayList of members representing the members collection
     */
    public ArrayList<Member> getMembersCollection() {
        return membersCollection;
    }

    /**
     * Sets the members collection for the library with validation to ensure data integrity.
     * <p>
     * This method validates that the provided collection is not null or empty. Additionally,
     * it checks that each member in the collection meets specific criteria:
     * - The member's name must be valid (non-null and non-empty).
     * - The member's ID must be valid (non-null and follow expected formatting).
     * - The borrowed books collection must be valid.
     * - The member's borrowing limit must be within acceptable ranges.
     * <p>
     * Any validation failures will throw an exception with a descriptive message.
     *
     * @param membersCollection The collection of members to be assigned to the library.
     *                          Must be non-null, non-empty, and contain valid member objects.
     * @throws IllegalArgumentException If the collection is null or empty.
     * @throws RuntimeException If any member in the collection fails validation checks.
     */
    public void setMembersCollection(ArrayList<Member> membersCollection) {

        // Validate if new members collection is not null and not empty
        if (membersCollection == null || membersCollection.isEmpty()) {
            throw new IllegalArgumentException("Member collection cannot be null or empty.");
        }

        // Verify that the new members collection does not contain invalid members
        for (Member member : membersCollection) {

            try {
                Member.isValidName(member.getName());
                Member.isValidMemberId(member.getName());
                member.areValidBorrowedBooks(member.getBorrowedBooks());
                member.isValidBorrowingLimit(member.getBorrowingLimit());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        this.membersCollection = membersCollection;
    }

    /**
     * Adds a book to the library's collection.
     * <p>
     * This method appends the provided book to the {@code booksCollection}. It assumes the book has
     * already been validated prior to invocation to ensure data integrity.
     *
     * @param book The book to be added to the library's collection. Must be a valid instance of the Book class.
     */
    public void addBook(Book book) {
        this.booksCollection.add(book);
    }

    /**
     * Registers a new member in the library's members collection.
     * <p>
     * This method adds the provided member to the {@code membersCollection}. It assumes that the
     * member has been validated prior to invocation to ensure data integrity.
     *
     * @param member The member to be registered in the library. Must be a valid instance of the Member class.
     */
    public void registerMember(Member member) {
        this.membersCollection.add(member);
    }

    /**
     * Assigns a book to a member in the library system.
     * <p>
     * This method takes the ID of a book and the ID of a member and performs the following actions:
     * - Finds the book in the {@code booksCollection} and updates its availability status to false.
     * - Finds the member in the {@code membersCollection} and adds the book to their borrowed books list.
     * <p>
     * If either the book or the member cannot be found, an exception is thrown with a descriptive message.
     *
     * @param memberId The ID of the member to whom the book is being assigned. Must be non-null and valid.
     * @param bookId The ID of the book to be assigned. Must be non-null and valid.
     * @throws IllegalArgumentException If the book or member cannot be found.
     */
    public void assignBookToMember(String memberId, String bookId) {

        // Find the book
        Book borrowedBook = null;
        for (Book book : booksCollection) {
            if (book.getId().equals(bookId)) {
                book.setAvailability(false);
                borrowedBook = book;
                break;
            }
        }

        if (borrowedBook == null) {
            throw new IllegalArgumentException("Book not found");
        }

        // Find the member
        Member user = null;
        for (Member member : membersCollection) {
            if (member.getMemberId().equals(memberId)) {
                member.borrowBook(borrowedBook);
                user = member;
                break; // Exit loop once the member is found
            }
        }

        if (user == null) {
            throw new IllegalArgumentException("Member not found");
        }

    }

    /**
     * Assigns multiple books to a member in the library system.
     * <p>
     * This method takes an array of book IDs and a member ID to perform the following actions:
     * - Finds each book in the {@code booksCollection} that matches the provided IDs and is available.
     * - Sets the availability of each assigned book to false.
     * - Adds the books to the borrowing list of the specified member.
     * <p>
     * If any book cannot be found or is unavailable, or if the member cannot be located, an exception is thrown.
     *
     * @param memberId The ID of the member to whom the books are being assigned. Must be non-null and valid.
     * @param bookId An array of book IDs to be assigned. All IDs must correspond to valid, available books.
     * @throws IllegalArgumentException If no books are found, or if the member cannot be located.
     */
    public void assignBooksToMember(String memberId, String[] bookId) {

        // Find the book
        ArrayList<Book> borrowedBooks = new ArrayList<>();
        for (Book book : booksCollection) {
            for (String id : bookId) {
                if (book.getId().equals(id) && book.getAvailability()) {
                    book.setAvailability(false);
                    borrowedBooks.add(book);
                }
            }
        }

        if (borrowedBooks.isEmpty()) {
            throw new IllegalArgumentException("Books not found");
        }

        // Find the member
        Member user = null;
        for (Member member : membersCollection) {
            if (member.getMemberId().equals(memberId)) {
                member.borrowBooks(borrowedBooks);
                user = member;
                break; // Exit loop once the member is found
            }
        }

        if (user == null) {
            throw new IllegalArgumentException("Member not found");
        }

    }

    /**
     * Displays the list of all books in the library's collection in a tabular format.
     * <p>
     * This method prints a visually formatted table with columns for book attributes such as ID, Title, Author,
     * ISBN, and Availability. It uses ANSI escape codes to apply bold formatting to column headers for better
     * readability. The table is bordered with horizontal lines for enhanced presentation.
     * <p>
     * Key Features:
     * - Uses `System.out.printf()` to ensure alignment of columns.
     * - Iterates through the {@code booksCollection} to print details of each book.
     * - Includes a header row with bold formatting using ANSI escape codes.
     * <p>
     * This method assumes that the {@code booksCollection} is initialized and populated with valid book objects.
     */
    public void displayBooks() {
        System.out.println("-".repeat(165));
        System.out.printf("|  \u001B[1mAll Books\u001B[0m%-152s|%n", "");
        System.out.println("-".repeat(165));
        System.out.printf("| %-45s| %-60s| %-46s| %-22s| %-21s|\n",
                "\033[1m" + "Id" + "\033[0m",
                "\033[1m" + "Title" + "\033[0m",
                "\033[1m" + "Author" + "\033[0m",
                "\033[1m" + "ISBN" + "\033[0m",
                "\033[1m" + "Availability" + "\033[0m");

        // Print table rows
        for (Book book : booksCollection) {
            System.out.printf("| %-37s| %-52s| %-38s| %-14s| %-13s|\n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getISBN(),
                    book.getAvailability());
        }
        System.out.println("-".repeat(165));
    }

    public void displayAvailableBooks() {
        System.out.println("-".repeat(165));
        System.out.printf("|  \u001B[1mAvailable Books\u001B[0m%-146s|%n", "");
        System.out.println("-".repeat(165));
        System.out.printf("| %-45s| %-60s| %-46s| %-22s| %-21s|\n",
                "\033[1m" + "Id" + "\033[0m",
                "\033[1m" + "Title" + "\033[0m",
                "\033[1m" + "Author" + "\033[0m",
                "\033[1m" + "ISBN" + "\033[0m",
                "\033[1m" + "Availability" + "\033[0m");

        // Print table rows
        for (Book book : booksCollection) {
            if (!book.getAvailability()){
                continue;
            }
            System.out.printf("| %-37s| %-52s| %-38s| %-14s| %-13s|\n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getISBN(),
                    book.getAvailability());
        }
        System.out.println("-".repeat(165));
    }

    /**
     * Displays the list of available books in the library's collection in a tabular format.
     * <p>
     * This method iterates through the {@code booksCollection} and filters books that are marked
     * as available. It then prints a formatted table with columns for book attributes such as ID,
     * Title, Author, ISBN, and Availability. Bold formatting is applied to the headers using ANSI
     * escape codes for better readability. The table is bordered with horizontal lines to enhance
     * its presentation.
     * <p>
     * Key Features:
     * - Filters and displays only books with availability set to true.
     * - Uses `System.out.printf()` for proper alignment and formatting of table columns.
     * - Includes bold headers for better visual hierarchy and organization.
     * <p>
     * This method assumes that the {@code booksCollection} is initialized and populated with valid
     * book objects, and that each book's availability status is properly set.
     */
    public void displayUnavailableBooks() {
        System.out.println("-".repeat(165));
        System.out.printf("|  \u001B[1mUnavailable Books\u001B[0m%-144s|%n", "");
        System.out.println("-".repeat(165));
        System.out.printf("| %-45s| %-60s| %-46s| %-22s| %-21s|\n",
                "\033[1m" + "Id" + "\033[0m",
                "\033[1m" + "Title" + "\033[0m",
                "\033[1m" + "Author" + "\033[0m",
                "\033[1m" + "ISBN" + "\033[0m",
                "\033[1m" + "Availability" + "\033[0m");

        // Print table rows
        for (Book book : booksCollection) {
            if (book.getAvailability()){
                continue;
            }
            System.out.printf("| %-37s| %-52s| %-38s| %-14s| %-13s|\n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getISBN(),
                    book.getAvailability());
        }
        System.out.println("-".repeat(165));
    }

    /**
     * Displays the list of all members in the library's collection in a tabular format.
     * <p>
     * This method prints a formatted table with columns for member attributes, including ID, Name,
     * and Borrowing Limit. Bold headers are applied using ANSI escape codes for enhanced readability.
     * Horizontal lines are used to frame the table for a professional presentation.
     * <p>
     * Key Features:
     * - Iterates through the {@code membersCollection} to display details of each member.
     * - Uses `System.out.printf()` for proper alignment and formatting of table columns.
     * - Assumes the {@code membersCollection} is initialized and populated with valid member objects.
     * <p>
     * This method provides a quick overview of all registered members and their borrowing capacities.
     */
    public void displayMembers() {
        System.out.println("-".repeat(110));
        System.out.printf("|  \u001B[1mAll Members\u001B[0m%-95s|%n", "");
        System.out.println("-".repeat(110));
        System.out.printf("| %-45s| %-58s| %-24s|\n",
                "\033[1m" + "ID" + "\033[0m",
                "\033[1m" + "Name" + "\033[0m",
                "\033[1m" + "Borrowing Limit" + "\033[0m");

        // Print table rows
        for (Member member : membersCollection) {
            System.out.printf("| %-37s| %-50s| %-16s|\n",
                    member.getMemberId(),
                    member.getName(),
                    member.getBorrowingLimit());
        }
        System.out.println("-".repeat(110));
    }

    /**
     * Provides a string representation of the Library object in a JSON-like format.
     * <p>
     * This method overrides the {@code toString()} method to return a structured view of the
     * library's collections, including:
     * - {@code booksCollection}: The list of books in the library.
     * - {@code membersCollection}: The list of members registered in the library.
     * <p>
     * The resulting string uses a JSON-like structure for readability and ease of debugging.
     *
     * @return A JSON-like string representation of the library object, showing the books
     *         and members collections.
     */
    @Override
    public String toString() {
        return "{\n" +
                "  \"booksCollection\": " + booksCollection + ",\n" +
                "  \"membersCollection\": " + membersCollection + "\n" +
                "}";
    }
}
