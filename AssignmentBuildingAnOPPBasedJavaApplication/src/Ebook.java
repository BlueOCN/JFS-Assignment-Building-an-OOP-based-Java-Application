import java.util.Set;

/**
 * Represents an electronic book (ebook) in the library system.
 * <p>
 * The Ebook class extends the Book class, inheriting attributes such as title, author, ID, ISBN,
 * and availability. It introduces additional attributes specific to ebooks, including file format
 * and file size, which define the digital characteristics of the ebook.
 * <p>
 * Features:
 * - Validation for file format and file size to ensure data integrity.
 * - Overloaded constructors for flexible initialization of ebook objects.
 * - Methods for retrieving and modifying ebook-specific attributes like file format and file size.
 */
public class Ebook extends Book {

    /**
     * Represents the file format of the ebook.
     * The file format specifies the type of file (e.g., "pdf", "epub", "mobi", "txt").
     */
    private String fileFormat;

    /**
     * Represents the file size of the ebook.
     * The file size is measured in kilobytes (KB) and indicates the storage space required for the file.
     */
    private int fileSize;

    /**
     * Default constructor for the Ebook class.
     * <p>
     * Initializes an Ebook object with default values:
     * - File format: "txt"
     * - File size: 500 KB
     * Inherits default values for title, author, ID, ISBN, and availability from the superclass.
     */
    public Ebook() {
        super();
        this.fileFormat = "txt";
        this.fileSize = 500;
    }

    /**
     * Constructor for the Ebook class that initializes the ebook with specific details.
     * <p>
     * Inherits title, author, ISBN, and availability attributes from the superclass.
     *
     * @param title The title of the ebook.
     * @param author The author of the ebook.
     * @param ISBN The ISBN of the ebook.
     * @param availability The availability status of the ebook. True if available, false otherwise.
     * @param fileSize The size of the ebook file in kilobytes (KB).
     * @param fileFormat The file format of the ebook (e.g., "pdf", "epub", "mobi").
     */
    public Ebook(String title, String author, String ISBN, boolean availability, int fileSize, String fileFormat) {
        super(title, author, ISBN, availability);
        this.setFileFormat(fileFormat);
        this.setFileSize(fileSize);
    }

    /**
     * Constructor for the Ebook class that initializes the ebook with all specified details.
     * <p>
     * Inherits title, author, ID, ISBN, and availability attributes from the superclass.
     *
     * @param title The title of the ebook.
     * @param author The author of the ebook.
     * @param id The unique identifier for the ebook. Must follow the UUID format.
     * @param ISBN The ISBN of the ebook.
     * @param availability The availability status of the ebook. True if available, false otherwise.
     * @param fileSize The size of the ebook file in kilobytes (KB).
     * @param fileFormat The file format of the ebook (e.g., "pdf", "epub", "mobi").
     */
    public Ebook(String title, String author, String id, String ISBN, boolean availability, int fileSize, String fileFormat) {
        super(title, author, id, ISBN, availability);
        this.setFileFormat(fileFormat);
        this.setFileSize(fileSize);
    }

    /**
     * Retrieves the file format of the book.
     * <p>
     * The file format indicates the type or extension of the book file (e.g., "pdf", "epub", "mobi").
     *
     * @return The file format of the book as a string.
     */
    public String getFileFormat() {
        return this.fileFormat;
    }

    /**
     * Sets the file format for the ebook with validation to ensure it adheres to acceptable formats.
     * <p>
     * The file format must be a non-null, non-empty string and match one of the supported formats
     * (e.g., "pdf", "epub", "mobi").
     *
     * @param fileFormat The file format to be assigned. Must be a valid file extension.
     * @throws IllegalArgumentException If the file format is null, empty, or not in the supported formats.
     */
    public void setFileFormat(String fileFormat) {

        String tmpFileFormat = fileFormat.trim();
        String trimmedFileFormat = tmpFileFormat.toLowerCase();
        Set<String> supportedFormats = Set.of("pdf", "epub", "mobi", "txt");

        // Verifies that the input is not empty or null
        if (tmpFileFormat.isEmpty()) {
            throw new IllegalArgumentException("File format cannot be null or empty.");
        }

        // Validates that the file has a supported format
        if (!supportedFormats.contains(trimmedFileFormat)) {
            throw new IllegalArgumentException("Invalid file format. Supported formats are: " + supportedFormats);
        }

        this.fileFormat = trimmedFileFormat;
    }

    /**
     * Retrieves the file size of the book.
     * <p>
     * The file size represents the size of the book file in kilobytes (KB).
     *
     * @return The size of the book file as an integer, measured in kilobytes (KB).
     */
    public int getFileSize() {
        return this.fileSize;
    }

    /**
     * Sets the file size of the book with validation to ensure it is within acceptable limits.
     * <p>
     * The file size must be a non-negative value and should not exceed a defined maximum size
     * (e.g., 10,000 KB). This ensures data integrity and prevents unrealistic file sizes.
     *
     * @param fileSize The size of the file in kilobytes (KB). Must be a positive integer.
     * @throws IllegalArgumentException If the file size is negative or exceeds the maximum allowed size.
     */
    public void setFileSize(int fileSize) {
        final int MAX_FILE_SIZE = 10_000; // Maximum allowed file size in KB

        if (fileSize < 0) {
            throw new IllegalArgumentException("File size cannot be negative.");
        }
        if (fileSize > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("File size cannot exceed " + MAX_FILE_SIZE + " KB.");
        }

        this.fileSize = fileSize;
    }

    /**
     * Returns a string representation of the book object in a JSON-like format.
     * <p>
     * The string includes the book's title, author, ISBN, availability, file format,
     * and file size, making it suitable for logging or debugging purposes.
     *
     * @return A JSON-like string representation of the book with its key attributes.
     */
    @Override
    public String toString() {
        return "{\n" +
                "  \"id\": \"" + super.getId() + "\",\n" +
                "  \"title\": \"" + super.getTitle() + "\",\n" +
                "  \"author\": \"" + super.getAuthor() + "\",\n" +
                "  \"ISBN\": " + super.getISBN() + ",\n" +
                "  \"availability\": " + super.getAvailability() + "\n" +
                "  \"fileFormat\": " + fileFormat + "\n" +
                "  \"fileSize\": " + fileSize + "\n" +
                "}";
    }
}
