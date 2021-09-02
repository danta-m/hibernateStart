package library.DAO;

import library.database.Init;
import library.entity.Book;
import org.hibernate.Session;

public class BookDAOImpl {
    public static class BookDaoImpl implements BookDAO {

        @Override
        public Book save(Book book1) {

            Init initDB = new Init();
            Session session = initDB.getSession();
            session.beginTransaction();
            session.save(book1);
            session.getTransaction().commit();
            session.close();
            return book1;
        }
    }
}
