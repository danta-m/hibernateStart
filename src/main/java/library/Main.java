package library;

import library.DAO.*;
import library.database.Init;
import library.entity.Author;
import library.entity.Book;
import library.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static BookDAO bookDAO = new BookDAOImpl();
    public static UserDAO userDAO = new UserDAOImpl();
    public static AuthorDAO authorDAO = new AuthorDAOImpl();

    public static Init initDB = new Init();

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setTitle("Flowers for Algernon");
        book1.setGenre("Science fiction");
        book1.setYear(2010);

        Book book2 = new Book();
        book2.setTitle("The Minds of Billy Milligan");
        book2.setGenre("Biography");
        book2.setYear(2000);

        User user1 = new User();
        user1.setUserName("Ilona K.");

        List<Book> bookUser1 = new ArrayList<>();
        bookUser1.add(book1);
        bookUser1.add(book2);
        user1.setBooks(bookUser1);
        userDAO.save(user1);
        System.out.println(bookDAO.getBookList());

        Author author1 = new Author();
        author1.setAuthor("Daniel Keyes");

        List<Book> bookAuthor1 = new ArrayList<>();
        bookAuthor1.add(book1);
        bookAuthor1.add(book2);
        author1.setBooks(bookAuthor1);
        authorDAO.save(author1);
        System.out.println(bookDAO.getBookList());

    }
}