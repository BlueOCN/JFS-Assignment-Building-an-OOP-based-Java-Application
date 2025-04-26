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

    @Override
    public String toString() {
        return "{\n" +
                "  \"booksCollection\": " + booksCollection + ",\n" +
                "  \"membersCollection\": " + membersCollection + "\n" +
                "}";
    }
}
