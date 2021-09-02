package library;

import library.DAO.BookDAO;
import library.DAO.BookDAOImpl;
import library.entity.Book;

public class Main {
    public static BookDAO bookDAO = new BookDAOImpl.BookDaoImpl();

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setTitle("Flowers for Algernon");
        book1.setAuthor ("Daniel Keyes");
        book1.setGenre ("Science fiction");
        book1.setYear(2010);

        bookDAO.save(book1);
    }
}