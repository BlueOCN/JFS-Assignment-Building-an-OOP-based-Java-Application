
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

    public Ebook(String title, String author, int ISBN, boolean availability, int fileSize, String fileFormat) {
        super(title, author, ISBN, availability);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }

}
