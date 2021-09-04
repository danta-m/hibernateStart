package library;

import library.DAO.BookDAO;
import library.DAO.BookDAOImpl;
import library.database.Init;
import library.entity.Book;

public class Main {
    public static BookDAO bookDAO = new BookDAOImpl.BookDaoImpl();
    public static Init initDB = new Init();


    public static void main(String[] args) {

        Book book1 = new Book();
        book1.setTitle("Flowers for Algernon");
        book1.setAuthor ("Daniel Keyes");
        book1.setGenre ("Science fiction");
        book1.setYear(2010);
        Book book2 = new Book();
        book2.setTitle("The Great Gatsby");
        book2.setAuthor ("Francis Scott Key Fitzgerald");
        book2.setGenre ("Tragedy");
        book2.setYear(2007);
        Book book3 = new Book();
        book3.setTitle("Little Women");
        book3.setAuthor ("Louisa May Alcott");
        book3.setGenre ("Coming of age");
        book3.setYear(2018);
        Book book4 = new Book();
        book4.setTitle("The Minds of Billy Milligan");
        book4.setAuthor ("Daniel Keyes");
        book4.setGenre ("Biography");
        book4.setYear(2000);

        bookDAO.save(book1);
        bookDAO.save(book2);
        bookDAO.save(book3);
        bookDAO.save(book4);
        book2.setYear(2015);
        bookDAO.update(book2);
//
        bookDAO.findById(1);

        System.out.println("Book find by HQL");
        System.out.println(bookDAO.findBookByIdWithHQL(2));

        System.out.println("Book find by HQL");
        System.out.println(bookDAO.findBookByAuthorWithHQL("Daniel Keyes"));

//        System.out.println(bookDAO.findBookByAuthorWithHQL("Louisa May Alcott"));

        System.out.println("Book find by Criteria");


        System.out.println(bookDAO.getBookList());
//
//        bookDAO.getBookList();
//        bookDAO.delete(1);
    }
}