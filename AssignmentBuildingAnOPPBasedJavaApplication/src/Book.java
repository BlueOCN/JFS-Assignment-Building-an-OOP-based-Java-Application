public class Book {

    // Attributes: title, author, ISBN and availability
    private String title;
    private String author;
    private int ISBN;
    private boolean availability;

    // Constructors
    public Book() {
        this.title = "NA";
        this.author = "NA";
        this.ISBN = 0;
        this.availability = false;
    }

    public Book(String title, String author, int ISBN, boolean availability) {
        this.title = title;
        this.author = author;
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

    public int getISBN() {
        return this.ISBN;
    }

    public void setISBN(int ISBN) {
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
