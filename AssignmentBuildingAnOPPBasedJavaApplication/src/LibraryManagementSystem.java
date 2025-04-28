import java.util.ArrayList;

public class LibraryManagementSystem {
    public static void main(String[] args) {

        // Creating books and eBooks.
        Library library = new Library();
        Book book1 = new Book();
        Book book2 = new Book("The Silent Voyager", "Emma Harper", "9781234567891", true);
        Book book3 = new Book("Whispering Shadows", "Liam Thornton", "9782345678902", true);
        Book book4 = new Book("A Journey Beyond Dreams", "Sophia Bennett", "9783456789013", true);
        Book book5 = new Book("The Eternal Horizon", "Noah Carter", "9784567890124", false);
        Ebook ebook1 = new Ebook();
        Ebook ebook2 = new Ebook("Shadows of the Unknown", "Ava Ramirez","9785678901235", true, 2048, "PDF");
        Ebook ebook3 = new Ebook("Tales from the Abyss", "Oliver Martinez", "9786789012346", false, 5120, "EPUB");
        Ebook ebook4 = new Ebook("Rise of the Fallen", "Mia Collins", "9787890123457", true, 1024, "MOBI");
        Ebook ebook5 = new Ebook("Into the Starlit Night", "Ethan Foster", "9788901234568", true, 8192, "TXT");

        ArrayList<Book> bookList1 = new ArrayList<>();
        bookList1.add(book1);
        bookList1.add(ebook1);

        ArrayList<Book> bookList2 = new ArrayList<>();
        bookList2.add(book2);
        bookList2.add(ebook2);
        bookList2.add(ebook3);

        // Add books and eBooks to the library.
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

        // Display Libraries Inventory
        library.displayBooks();
        library.displayAvailableBooks();
        library.displayUnavailableBooks();

        // Create regular and premium members.
        Member member1 = new Member();
        Member member2 = new Member("Emma Rodriguez", book1);
        Member member3 = new Member("Liam Foster", book2);
        Member member4 = new Member("Sophia Morales", bookList1);
        Member member5 = new Member("Noah Turner", bookList2);
        PremiumMember premiumMember1 = new PremiumMember();
        PremiumMember premiumMember2 = new PremiumMember("Ava Carter", book1);
        PremiumMember premiumMember3 = new PremiumMember("Oliver Ramirez", book2);
        PremiumMember premiumMember4 = new PremiumMember("Mia Bennett", bookList1);
        PremiumMember premiumMember5 = new PremiumMember("Ethan Collins", bookList2);

        // Register regular and premium members.
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

        // Display regular and premium members.
        library.displayMembers();

        // Borrow a book for a member from library.
        member2.displayDetails();
        premiumMember2.displayDetails();

        library.assignBookToMember(member2.getMemberId(), book2.getId());

        String[] bookIDs = {book4.getId(), book2.getId(), ebook5.getId(), book3.getId(), book1.getId()};
        library.assignBooksToMember(premiumMember2.getMemberId(), bookIDs);

        library.displayAvailableBooks(); // Books are no longer available

        // Displaying member details along with borrowed books.
        member2.displayDetails();
        premiumMember2.displayDetails();

    }
}