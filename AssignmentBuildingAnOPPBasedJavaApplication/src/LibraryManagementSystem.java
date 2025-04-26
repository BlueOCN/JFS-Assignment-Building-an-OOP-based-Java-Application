import java.util.ArrayList;

public class LibraryManagementSystem {
    public static void main(String[] args) {

        // Adding books and eBooks to the library.
        Library library = new Library();
        Book book1 = new Book();
        Book book2 = new Book("Java Programming", "Alice Johnson", 111111, true);
        Book book3 = new Book("Data Structures", "Bob Smith", 222222, false);
        Book book4 = new Book("Design Patterns", "Catherine Lee", 333333, true);
        Book book5 = new Book("Algorithms Unlocked", "David Brown", 444444, false);
        Ebook ebook1 = new Ebook();
        Ebook ebook2 = new Ebook("Learning Java", "John Doe", 123456, true, 2048, "PDF");
        Ebook ebook3 = new Ebook("Advanced Programming", "Jane Smith", 789012, false, 5120, "EPUB");
        Ebook ebook4 = new Ebook("The Art of Coding", "Robert Brown", 345678, true, 1024, "MOBI");
        Ebook ebook5 = new Ebook("Mastering Algorithms", "Emily Davis", 901234, false, 8192, "AZW");

        ArrayList<Book> bookList1 = new ArrayList<>();
        bookList1.add(book1);
        bookList1.add(ebook1);

        ArrayList<Book> bookList2 = new ArrayList<>();
        bookList2.add(book2);
        bookList2.add(ebook2);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(ebook1);
        library.addBook(ebook2);
        library.addBook(ebook3);
        library.addBook(ebook4);
        library.addBook(ebook5);

        // Registering regular and premium members.
        Member member1 = new Member();
        Member member2 = new Member("John Doe", 101, book1);
        Member member3 = new Member("Jane Smith", 102, book2);
        Member member4 = new Member("Robert Brown", 103, bookList1);
        Member member5 = new Member("Emily Davis", 104, bookList2);
        PremiumMember premiumMember1 = new PremiumMember();
        PremiumMember premiumMember2 = new PremiumMember("John Doe", 105, book1);
        PremiumMember premiumMember3 = new PremiumMember("Jane Smith", 106, book2);
        PremiumMember premiumMember4 = new PremiumMember("Robert Brown", 107, bookList1);
        PremiumMember premiumMember5 = new PremiumMember("Emily Davis", 108, bookList2);

        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);
        library.registerMember(member4);
        library.registerMember(member5);
        library.registerMember(premiumMember1);
        library.registerMember(premiumMember2);
        library.registerMember(premiumMember3);
        library.registerMember(premiumMember4);
        library.registerMember(premiumMember5);


        // Borrowing books for members and displaying the updated
        // list of available books.
        System.out.println(library);

        // Displaying member details along with borrowed books.

    }
}