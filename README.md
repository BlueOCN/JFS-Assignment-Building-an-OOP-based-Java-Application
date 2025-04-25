# JFS-Assignment-Building-an-OOP-based-Java-Application
Design a simple library management system. The system should manage books, members, and borrowing transactions. Your application should demonstrate the use of OOP principles.

## Assignment Objective
To apply your understanding of Object-Oriented Programming (OOP) concepts in Java by designing and implementing a small Java application using classes, objects, inheritance, polymorphism, and encapsulation.

By completing this assignment, you will demonstrate your ability to design and implement a Java application using Object-Oriented Programming principles, preparing you for more advanced topics and real-world applications.

---

## Problem Statement:

Design a simple library management system. The system should manage books, members, and borrowing transactions. Your application should demonstrate the use of OOP principles.

## Requirements:

### Classes and Objects:
- Create a class Book with attributes such as title, author, ISBN, and availability.
- Create a class Member with attributes such as name, memberId, and borrowedBooks.
- Create a class Library that holds a collection of books and members and provides methods to add books, register members, and manage borrowing transactions.

### Inheritance:
- Create a subclass EBook that extends Book with additional attributes like fileFormat and fileSize.
- Create a subclass PremiumMember that extends Member with additional benefits such as borrowing more books than regular members.

### Polymorphism:
- Implement method overriding in EBook and PremiumMember classes.
- Use polymorphism to process borrowing transactions for both Member and PremiumMember.

### Encapsulation:
- Ensure that all attributes are private and provide public getter and setter methods.
- Implement validation in setter methods to ensure data integrity.

## Implementation:

Write a main class LibraryManagementSystem with a main method to demonstrate the functionality of your library management system.

### Implement methods to:
- Add new books to the library.
- Register new members.
- Borrow books for members.
- Display the list of available books.
- Display the list of registered members.

### Sample Output:

The main method should demonstrate the following scenarios:

- Adding books and eBooks to the library.
- Registering regular and premium members.
- Borrowing books for members and displaying the updated list of available books.
- Displaying member details along with borrowed books.
