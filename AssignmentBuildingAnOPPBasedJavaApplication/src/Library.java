import java.util.ArrayList;

public class Library {

    // Attributes: booksCollection, membersCollection
    private ArrayList<Book> booksCollection;
    private ArrayList<Member> membersCollection;

    // Constructors
    public Library() {
        booksCollection = new ArrayList<>();
        membersCollection = new ArrayList<>();
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
     * Sets the collection of books.
     *
     * @param booksCollection an arrayList of books representing the books collection
     */
    public void setBooksCollection(ArrayList<Book> booksCollection) {
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
     * Sets the collection of members.
     *
     * @param membersCollection an arrayList of members representing the members collection
     */
    public void setMembersCollection(ArrayList<Member> membersCollection) {
        this.membersCollection = membersCollection;
    }

    // Methods: addBooks, registerMembers, manageBorrowingTransactions?
    public void addBook(Book book) {
        this.booksCollection.add(book);
    }
    public void registerMember(Member member) {
        this.membersCollection.add(member);
    }

    public void displayBooks() {
        System.out.println("\n  \033[1mAll Books\033[0m\n");
        System.out.printf("| %-38s| %-38s| %-38s| %-38s|\n",
                "\033[1m" + "Title" + "\033[0m",
                "\033[1m" + "Author" + "\033[0m",
                "\033[1m" + "ISBN" + "\033[0m",
                "\033[1m" + "Availability" + "\033[0m");

        // Print table rows
        for (Book book : booksCollection) {
            System.out.printf("| %-30s| %-30s| %-30s| %-30s|\n",
                    book.getTitle(),
                    book.getAuthor(),
                    book.getISBN(),
                    book.getAvailability());
        }
    }

    public void displayAvailableBooks() {
        System.out.println("\n  \033[1mAvailable Books\033[0m\n");
        System.out.printf("| %-38s| %-38s| %-38s| %-38s|\n",
                "\033[1m" + "Title" + "\033[0m",
                "\033[1m" + "Author" + "\033[0m",
                "\033[1m" + "ISBN" + "\033[0m",
                "\033[1m" + "Availability" + "\033[0m");

        // Print table rows
        for (Book book : booksCollection) {
            if (!book.getAvailability()){
                continue;
            }
            System.out.printf("| %-30s| %-30s| %-30s| %-30s|\n",
                    book.getTitle(),
                    book.getAuthor(),
                    book.getISBN(),
                    book.getAvailability());
        }
    }

    public void displayUnavailableBooks() {
        System.out.println("\n  \033[1mUnavailable Books\033[0m\n");
        System.out.printf("| %-38s| %-38s| %-38s| %-38s|\n",
                "\033[1m" + "Title" + "\033[0m",
                "\033[1m" + "Author" + "\033[0m",
                "\033[1m" + "ISBN" + "\033[0m",
                "\033[1m" + "Availability" + "\033[0m");

        // Print table rows
        for (Book book : booksCollection) {
            if (book.getAvailability()){
                continue;
            }
            System.out.printf("| %-30s| %-30s| %-30s| %-30s|\n",
                    book.getTitle(),
                    book.getAuthor(),
                    book.getISBN(),
                    book.getAvailability());
        }
    }

    public void displayMembers() {
        System.out.println("\n  \033[1mAll Members\033[0m\n");
        System.out.printf("| %-38s| %-38s| %-38s|\n",
                "\033[1m" + "Name" + "\033[0m",
                "\033[1m" + "ID" + "\033[0m",
                "\033[1m" + "Borrowing Limit" + "\033[0m");

        // Print table rows
        for (Member member : membersCollection) {
            System.out.printf("| %-30s| %-30s| %-30s|\n",
                    member.getName(),
                    member.getMemberId(),
                    member.getBorrowingLimit());
        }
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"booksCollection\": " + booksCollection + ",\n" +
                "  \"membersCollection\": " + membersCollection + "\n" +
                "}";
    }
}
