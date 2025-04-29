import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents a book in the library system.
 * <p>
 * Each book has a title, author, a unique identifier (ID), ISBN, and an availability status.
 * The class provides constructors for creating book objects with different levels of detail
 * and methods for setting and retrieving the book's attributes, including data validation.
 * <p>
 * Key Features:
 * - Generates a unique ID for each book using UUID.
 * - Supports validation for attributes like title, author, and ISBN to ensure data integrity.
 * - Tracks the availability status to indicate whether the book can be borrowed.
 */
public class Book {

    /**
     * Represents the title of the book.
     * The title is a descriptive name assigned to the book by its author or publisher.
     */
    private String title;

    /**
     * Represents the author of the book.
     * The author is the individual or entity credited with creating the book.
     */
    private String author;

    /**
     * Represents the unique identifier for the book.
     * This ID is expected to follow the UUID format for global uniqueness.
     */
    private String id;

    /**
     * Represents the International Standard Book Number (ISBN) of the book.
     * The ISBN is a unique identifier for books and must adhere to the ISBN format.
     */
    private String ISBN;

    /**
     * Represents the availability status of the book.
     * True indicates the book is available for borrowing; false indicates it is not.
     */
    private boolean availability;

    /**
     * Default constructor for the Book class.
     * <p>
     * Initializes a Book object with default values:
     * - Title: "NA"
     * - Author: "NA"
     * - ID: A randomly generated UUID
     * - ISBN: "NA"
     * - Availability: false (not available for borrowing)
     */
    public Book() {
        this.title = "NA";
        this.author = "NA";
        this.id = UUID.randomUUID().toString();
        this.ISBN = "NA";
        this.availability = false;
    }

    /**
     * Constructor for the Book class that initializes the book with specific details.
     * <p>
     * This constructor generates a unique ID for the book using UUID.
     *
     * @param title The title of the book.
     * @param author The name of the author of the book.
     * @param ISBN The ISBN of the book. Must follow ISBN format.
     * @param availability The availability status of the book. True if available, false otherwise.
     */
    public Book(String title, String author, String ISBN, boolean availability) {
        this.setTitle(title);
        this.setAuthor(author);
        this.id = UUID.randomUUID().toString();
        this.setISBN(ISBN);
        this.availability = availability;
    }

    /**
     * Constructor for the Book class that initializes the book with all specified details.
     * <p>
     * This constructor allows for manual setting of the unique ID. Use with caution
     * to avoid ID duplication.
     *
     * @param title The title of the book.
     * @param author The name of the author of the book.
     * @param id The unique identifier for the book. Must follow the UUID format.
     * @param ISBN The ISBN of the book. Must follow ISBN format.
     * @param availability The availability status of the book. True if available, false otherwise.
     */
    public Book(String title, String author, String id, String ISBN, boolean availability) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setId(id);
        this.setISBN(ISBN);
        this.availability = availability;
    }

    /**
     * Retrieves the title of the book.
     * <p>
     * The title represents the name or designation of the book as assigned by its author or publisher.
     *
     * @return The title of the book as a string.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the book with validation to ensure data integrity.
     *
     * @param title The title to be assigned. Must be non-null, non-empty, and within an acceptable length range.
     * @throws IllegalArgumentException If the title is null, empty, or exceeds the defined character limit.
     */
    public void setTitle(String title) {

        String tmpTitle = title.trim();
        if (tmpTitle.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (tmpTitle.length() > 100) { // Example character limit for a title
            throw new IllegalArgumentException("Title cannot exceed 100 characters.");
        }
        if (!tmpTitle.matches("[a-zA-Z0-9\\s.,'-]+")) { // Allows letters, numbers, spaces, and some punctuation
            throw new IllegalArgumentException("Title contains invalid characters. Only letters, numbers, spaces, and common punctuation are allowed.");
        }

        this.title = tmpTitle;
    }

    /**
     * Retrieves the name of the author of the book.
     * <p>
     * The author's name represents the individual or entity credited for creating the book.
     *
     * @return The name of the book's author as a string.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Sets the author's name with validation to ensure data integrity.
     *
     * @param author The name of the author to be assigned. Must be non-null, non-empty, include
     *               at least a first name and a last name, and cannot exceed the maximum length.
     * @throws IllegalArgumentException If the author name is null, empty, too long, or contains invalid characters.
     */
    public void setAuthor(String author) {

        final int MAX_LENGTH = 50;
        String tmpAuthor = author.trim();

        if (tmpAuthor.isEmpty()) {
            throw new IllegalArgumentException("Author name cannot be null or empty.");
        }
        if (tmpAuthor.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Author name cannot exceed " + MAX_LENGTH + " characters.");
        }
        if (!tmpAuthor.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Author name can only contain letters and spaces.");
        }
        if (!tmpAuthor.contains(" ")) {
            throw new IllegalArgumentException("Name must include at least a first name and a last name.");
        }

        this.author = tmpAuthor;
    }

    /**
     * Retrieves the unique identifier (ID) of the book.
     * <p>
     * The ID uniquely identifies the book and is expected to follow the UUID format.
     *
     * @return The unique ID of the book as a string.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier (ID) for the book with validation to ensure data integrity.
     * <p>
     * The ID must follow the UUID format to uniquely identify books in the system.
     * Validation is performed by attempting to parse the input string as a UUID.
     *
     * @param id The ID to be assigned to the book. Must be a valid UUID string.
     * @throws IllegalArgumentException If the provided ID does not conform to the UUID format.
     */
    public void setId(String id) {
        try {
            // Validate the book ID by attempting to parse it as a UUID.
            UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            // Throw an exception with a clear error message if validation fails
            throw new IllegalArgumentException("Invalid Book ID. It must follow the UUID format.");
        }
        this.id = id;
    }

    /**
     * Retrieves the International Standard Book Number (ISBN) of the book.
     * <p>
     * The ISBN uniquely identifies the book and adheres to the ISBN format.
     *
     * @return The ISBN of the book as a string.
     */
    public String getISBN() {
        return this.ISBN;
    }

    /**
     * Sets the International Standard Book Number (ISBN) for the book with validation.
     * <p>
     * The ISBN must be either 10 or 13 digits long and follow the valid ISBN format. This method
     * ensures that only properly formatted ISBNs are accepted.
     *
     * @param ISBN The ISBN to be assigned to the book. Must be a valid 10- or 13-digit string.
     * @throws IllegalArgumentException If the ISBN is null, empty, or does not adhere to the valid ISBN format.
     */
    public void setISBN(String ISBN) {

        String tmpISBN = ISBN.trim();

        // Validate that ISBN is not null or empty
        if (tmpISBN.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty.");
        }

        // Validate the length and format of the ISBN (10 or 13 digits)
        if (!tmpISBN.matches("\\d{10}|\\d{13}")) {
            throw new IllegalArgumentException("Invalid ISBN. It must be either 10 or 13 digits long.");
        }

        this.ISBN = tmpISBN; // Assign the validated ISBN
    }

    /**
     * Retrieves the availability status of the book.
     * <p>
     * The availability indicates whether the book is currently available for borrowing.
     *
     * @return True if the book is available for borrowing, false otherwise.
     */
    public boolean getAvailability() {
        return this.availability;
    }

    /**
     * Sets the availability status of the book.
     * <p>
     * The availability indicates whether the book is available for borrowing.
     *
     * @param availability The availability status to be assigned to the book.
     *                     True if the book is available, false otherwise.
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     * Validates the given books collection to ensure data integrity.
     * <p>
     * This method checks that the provided collection of books is not null or empty, and that
     * each book in the collection meets the following criteria:
     * - The book itself must not be null.
     * - The book must have a non-null, non-empty title.
     * - The book must have a valid ISBN, which is either a 10-digit or 13-digit numeric string.
     * <p>
     * If any of these conditions are not met, the method throws an {@code IllegalArgumentException}
     * with a descriptive error message.
     *
     * @param booksCollection The collection of books to validate. Must be non-null, non-empty,
     *                        and contain valid book objects.
     * @throws IllegalArgumentException If the books collection is null, empty, or contains invalid books.
     */
    public static void areValidBooksCollection(ArrayList<Book> booksCollection) {

        // Validate if new book collection is not null and not empty
        if (booksCollection == null || booksCollection.isEmpty()) {
            throw new IllegalArgumentException("Books collection cannot be null or empty.");
        }

        // Verify that the new books collection does not contain null books
        for (Book book : booksCollection) {
            if (book == null) {
                throw new IllegalArgumentException("Books collection cannot contain null book entries.");
            }
            if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
                throw new IllegalArgumentException("Each book must have a non-null, non-empty title.");
            }
            if (book.getISBN() == null || (!book.getISBN().matches("\\d{10}") && !book.getISBN().matches("\\d{13}"))) {
                throw new IllegalArgumentException("Each book must have a valid ISBN.");
            }
        }
    }

    /**
     * Returns a string representation of the book object in a JSON-like format.
     * <p>
     * The string includes the title, author, ISBN, and availability status of the book,
     * formatted for readability.
     *
     * @return A string representation of the book with its key attributes.
     */
    @Override
    public String toString() {
        return "{\n" +
                "  \"id\": \"" + id + "\",\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"author\": \"" + author + "\",\n" +
                "  \"ISBN\": " + ISBN + ",\n" +
                "  \"availability\": " + availability + "\n" +
                "}";
    }

}
