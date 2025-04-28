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
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public int getBorrowingLimit() {
        return this.borrowingLimit;
    }

    public void setBorrowingLimit(int borrowingLimit) {
        this.borrowingLimit = borrowingLimit;
    }

    // Methods
    public void borrowBook(Book borrowedBook) {
        if (this.borrowedBooks.size() + 1 > borrowingLimit) {
            throw new IllegalArgumentException("Borrowing limit exceeded: You will need to leave "
                    + (borrowingLimit - this.borrowedBooks.size()) + " or more books");
        }
        this.borrowedBooks.add(borrowedBook);
    }

    public void borrowBooks(ArrayList<Book> booksList) {
        if (this.borrowedBooks.size() + booksList.size() > borrowingLimit) {
            throw new IllegalArgumentException("Borrowing limit exceeded: You will need to leave "
                    + (borrowingLimit - this.borrowedBooks.size()) + " or more books");
        }
        for (Book book : booksList) {
            this.borrowedBooks.add(book);
        }
    }

    public void displayDetails() {
        System.out.printf("\n  \033[1mMember:\033[0m %-56s\033[1mId:\033[0m %-56s\n", name, memberId);
        System.out.println("  \033[1mBorrowed Books:\033[0m\n");
        System.out.printf("| %-60s| %-46s| %-25s| %-25s| %-25s|\n",
                "\033[1m" + "Title" + "\033[0m",
                "\033[1m" + "Author" + "\033[0m",
                "\033[1m" + "Id" + "\033[0m",
                "\033[1m" + "ISBN" + "\033[0m",
                "\033[1m" + "Availability" + "\033[0m");

        // Print table rows
        for (Book book : borrowedBooks) {
            System.out.printf("| %-52s| %-38s| %-17s| %-17s| %-17s|\n",
                    book.getTitle(),
                    book.getAuthor(),
                    book.getId(),
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
