package library;

import library.DAO.BookDAO;
import library.DAO.BookDAOImpl;
import library.DAO.UserDAO;
import library.DAO.UserDAOImpl;
import library.database.Init;
import library.entity.Book;
import library.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static BookDAO bookDAO = new BookDAOImpl.BookDaoImpl();
    public static UserDAO userDAO = new UserDAOImpl();


    public static Init initDB = new Init();

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setTitle("Flowers for Algernon");
        book1.setAuthor ("Daniel Keyes");
        book1.setGenre ("Science fiction");
        book1.setYear(2010);

        Book book2 = new Book();
        book2.setTitle("Dune");
        book2.setAuthor ("Frank Herbert");
        book2.setGenre ("Science fiction");
        book2.setYear(2010);

        Book book3 = new Book();
        book3.setTitle("The Great Gatsby");
        book3.setAuthor ("Francis Scott Key Fitzgerald");
        book3.setGenre ("Tragedy");
        book3.setYear(2007);

        Book book4 = new Book();
        book4.setTitle("Little Women");
        book4.setAuthor ("Louisa May Alcott");
        book4.setGenre ("Coming of age");
        book4.setYear(2018);

        Book book5 = new Book();
        book5.setTitle("The Minds of Billy Milligan");
        book5.setAuthor ("Daniel Keyes");
        book5.setGenre ("Biography");
        book5.setYear(2000);

        User user1 = new User();
        user1.setUserName("Ilona K.");

        List<Book> bookUser1 = new ArrayList<>();
        bookUser1.add(book1);
        bookUser1.add(book2);
        bookUser1.add(book3);
        user1.setBook(bookUser1);
        userDAO.save(user1);
        System.out.println(bookDAO.getBookList());

        User user2 = new User();
        user2.setUserName("Artem S.");

        List<Book> bookUser2 = new ArrayList<>();
        bookUser1.add(book4);
        bookUser1.add(book5);
        user2.setBook(bookUser2);
        userDAO.save(user2);
        System.out.println(bookDAO.getBookList());

//        bookDAO.save(book1);
//        bookDAO.save(book2);
//        bookDAO.save(book3);
//        bookDAO.save(book4);
//        book2.setYear(2015);
//        bookDAO.update(book2);
////
//        bookDAO.findById(1);
//
//        System.out.println("Book find by HQL");
//        System.out.println(bookDAO.findBookByIdWithHQL(2));
//
//        System.out.println("Book find by HQL");
//        System.out.println(bookDAO.findBookByAuthorWithHQL("Daniel Keyes"));
//
////        System.out.println(bookDAO.findBookByAuthorWithHQL("Louisa May Alcott"));
//
//        System.out.println("Book find by Criteria");
//
//
//        System.out.println(bookDAO.getBookList());
//
//        bookDAO.getBookList();
//        bookDAO.delete(1);
    }
}