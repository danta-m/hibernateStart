package library.DAO;

import library.entity.Book;

import java.util.List;

public interface BookDAO {
    Book save(Book book);

    Book update(Book book);

    Book findById(long id);

    List<Book> getBookList();

    Book delete(long id);

    Book findBookByIdWithHQL(long id);

    List<Book> findBookByAuthorWithHQL(String author);
}
