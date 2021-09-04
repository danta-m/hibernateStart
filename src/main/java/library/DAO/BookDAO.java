package library.DAO;

import library.entity.Book;

import java.util.List;

public interface BookDAO {
    Book save(Book book);

    Book update(Book book);

    Book findById(int id);

    List<Book> getBookList();

    Book delete(int id);

    Book findBookByIdWithHQL(int id);

    List<Book> findBookByAuthorWithHQL(String author);
}
