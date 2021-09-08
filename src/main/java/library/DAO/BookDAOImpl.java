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
        public Book findById(long id) {
            Session session = initDB.getSession();
            session.beginTransaction();
            Book book= session.load(Book.class, new Long(id));
            session.getTransaction().commit();
            session.close();
            return book;
        }

        @Override
        public Book findBookByIdWithHQL(long id) {
            Session session = initDB.getSession();
            session.beginTransaction();
            Query<Book> query = session.createQuery("select book from Book book where book.id=:id");
            query.setParameter("id", id);
            return query.getSingleResult();
        }

       
//        @Override
//        public Book findBookByAuthorWithHQL(String author) {
//            Session session = initDB.getSession();
//            session.beginTransaction();
//            Query<Book> query = session.createQuery("select book from Book book where book.author=:author");
//            query.setParameter("author", author);
//            return query.getSingleResult();
//        }
//        

        @Override
        public List<Book> findBookByAuthorWithHQL(String author) {
            Session session = initDB.getSession();
            session.beginTransaction();
            Query <Book> query = session.createQuery("select book from Book book where book.author=:author");
            query.setParameter("author", author);
            return query.list();
        }
        
        @Override
        @SuppressWarnings("unchecked")
        public List<Book> getBookList() {
            Session session = initDB.getSession();
            session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(Book.class);
            Root<Book> root = cq.from(Book.class);
            cq.select(root);
            Query query = session.createQuery(cq);
            List<Book> bookList = query.getResultList();
//            List<Book> bookList = session.createQuery("from Book").list();
            session.getTransaction().commit();
            session.close();
            return bookList;
        }

        @Override
        public Book delete(long id) {
            Session session = initDB.getSession();
            session.beginTransaction();
            Book book= session.load(Book.class, new Long(id));
            if (book!= null) {
                session.delete(book);
            }
            session.getTransaction().commit();
            session.close();
            return book;
        }

        
        /*
public Author getAuthorByIdWithCriteria(Integer id) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = builder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);
        criteriaQuery.where(builder.equal(root.get("id"), id));
        TypedQuery<Author> authorTypedQuery = session.createQuery(criteriaQuery);
        return authorTypedQuery.getSingleResult();
    }
 */
    }
}
