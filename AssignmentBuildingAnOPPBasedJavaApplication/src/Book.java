import java.util.UUID;

public class Book {

    // Attributes: title, author, ISBN and availability
    private String title;
    private String author;
    private String id;
    private String ISBN;
    private boolean availability;

    // Constructors
    public Book() {
        this.title = "NA";
        this.author = "NA";
        this.id = UUID.randomUUID().toString();
        this.ISBN = "NA";
        this.availability = false;
    }

    public Book(String title, String author, String ISBN, boolean availability) {
        this.title = title;
        this.author = author;
        this.id = UUID.randomUUID().toString();
        this.ISBN = ISBN;
        this.availability = availability;
    }

    public Book(String title, String author, String id, String ISBN, boolean availability) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.ISBN = ISBN;
        this.availability = availability;
    }

    // Getters & Setters
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean getAvailability() {
        return this.availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    // Methods: ???

    @Override
    public String toString() {
        return "{\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"author\": \"" + author + "\",\n" +
                "  \"ISBN\": " + ISBN + ",\n" +
                "  \"availability\": " + availability + "\n" +
                "}";
    }

}
