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

        bookDAO.save(book1);
        bookDAO.save(book2);
        book2.setYear(2015);
        bookDAO.update(book2);

        bookDAO.getBookById(2);

        bookDAO.getBookList();
        bookDAO.delete(book1);
    }
}