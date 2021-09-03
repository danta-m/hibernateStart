package library.DAO;

import library.entity.Book;

import java.util.List;

public interface BookDAO {
    Book save(Book book);

    Book update(Book book);

    Book getBookById(int id);

    List<Book> getBookList();

    Book delete(Book book);
}
