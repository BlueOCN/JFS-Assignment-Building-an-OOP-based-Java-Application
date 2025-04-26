import java.util.ArrayList;

public class Member {

    // Attributes: name, memberId and borrowedBooks.
    private String name;
    private int memberId;
    private ArrayList<Book> borrowedBooks;
    private int borrowingLimit = 3;

    // Constructor
    public Member() {
        this.name = "NA";
        this.memberId = 0;
        this.borrowedBooks = new ArrayList<>();
    }
    public Member(String name, int memberId, Book borrowedBook) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
        this.borrowedBooks.add(borrowedBook);
    }
    public Member(String name, int memberId, ArrayList<Book> borrowedBooks) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = borrowedBooks;
    }

    // Methods: ???

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public int getBorrowingLimit() {
        return borrowingLimit;
    }

    public void setBorrowingLimit(int borrowingLimit) {
        this.borrowingLimit = borrowingLimit;
    }

    // Methods
    public void borrowBook(Book borrowedBook) {
        if (borrowedBook.getAvailability()) {
            this.borrowedBooks.add(borrowedBook);
        }
    }

    public void borrowBooks(ArrayList<Book> booksList) {
        for (Book book : booksList) {
            if (book.getAvailability()) {
                this.borrowedBooks.add(book);
            }
        }
    }

    public void displayDetails() {
        System.out.printf("\n  \033[1mMember:\033[0m %-56s\033[1mId:\033[0m %-56s\n\n", name, memberId);
        System.out.printf("| %-38s| %-38s| %-38s| %-38s|\n",
                "\033[1m" + "Title" + "\033[0m",
                "\033[1m" + "Author" + "\033[0m",
                "\033[1m" + "ISBN" + "\033[0m",
                "\033[1m" + "Availability" + "\033[0m");

        // Print table rows
        for (Book book : borrowedBooks) {
            System.out.printf("| %-30s| %-30s| %-30s| %-30s|\n",
                    book.getTitle(),
                    book.getAuthor(),
                    book.getISBN(),
                    book.getAvailability());
        }
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"memberId\": " + memberId + ",\n" +
                "  \"borrowedBooks\": " + borrowedBooks + "\n" +
                "}";
    }
}
