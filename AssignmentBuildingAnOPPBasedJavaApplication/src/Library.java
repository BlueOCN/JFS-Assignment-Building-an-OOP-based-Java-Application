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

    public void displayBooks() {
        System.out.println("-".repeat(165));
        System.out.println(String.format("|  \033[1mAll Books\033[0m%-152s|", ""));
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
        System.out.println(String.format("|  \033[1mAvailable Books\033[0m%-146s|", ""));
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

    public void displayUnavailableBooks() {
        System.out.println("-".repeat(165));
        System.out.println(String.format("|  \033[1mUnavailable Books\033[0m%-144s|", ""));
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

    public void displayMembers() {
        System.out.println("-".repeat(110));
        System.out.println(String.format("|  \033[1mAll Members\033[0m%-95s|", ""));
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

    @Override
    public String toString() {
        return "{\n" +
                "  \"booksCollection\": " + booksCollection + ",\n" +
                "  \"membersCollection\": " + membersCollection + "\n" +
                "}";
    }
}
