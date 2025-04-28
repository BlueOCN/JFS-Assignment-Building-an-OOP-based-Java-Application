
public class Ebook extends Book {

    // Attributes: Inherited from Book, fileFormat and fileSize (MB)
    private String fileFormat;
    private int fileSize;

    // Constructors
    public Ebook() {
        super();
        this.fileFormat = "txt";
        this.fileSize = 500;
    }

    public Ebook(String title, String author, String ISBN, boolean availability, int fileSize, String fileFormat) {
        super(title, author, ISBN, availability);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }

    public Ebook(String title, String author, String id, String ISBN, boolean availability, int fileSize, String fileFormat) {
        super(title, author, id, ISBN, availability);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }

    public String getFileFormat() {
        return this.fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"title\": \"" + super.getTitle() + "\",\n" +
                "  \"author\": \"" + super.getAuthor() + "\",\n" +
                "  \"ISBN\": " + super.getISBN() + ",\n" +
                "  \"availability\": " + super.getAvailability() + "\n" +
                "  \"fileFormat\": " + fileFormat + "\n" +
                "  \"fileSize\": " + fileSize + "\n" +
                "}";
    }
}
