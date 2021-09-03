package library.DAO;

import library.entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static library.Main.initDB;

public class BookDAOImpl {
    public static class BookDaoImpl implements BookDAO {
        @Override
        public Book save(Book book) {
            Session session = initDB.getSession();
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
            session.close();
            return book;
        }

        @Override
        public Book update(Book book) {
            Session session = initDB.getSession();
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
            session.close();
            return book;
        }

        @Override
        public Book getBookById(int id) {
            Session session = initDB.getSession();
            session.beginTransaction();
            Book idFilter = session.get(Book.class, id);
            session.getTransaction().commit();
            session.close();
            return idFilter;
        }

        @Override
        public List<Book> getBookList() {
            Session session = initDB.getSession();
            session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(Book.class);
            Root<Book> root = cq.from(Book.class);
            cq.select(root);
            Query query = session.createQuery(cq);
            List<Book> bookList = query.getResultList();
            session.getTransaction().commit();
            session.close();
            return bookList;
        }

        @Override
        public Book delete(Book book) {
            Session session = initDB.getSession();
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
            session.close();
            return book;
        }

    }
}
