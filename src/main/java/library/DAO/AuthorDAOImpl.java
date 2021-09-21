package library.DAO;

import library.database.Init;
import library.entity.Author;
import org.hibernate.Query;
import org.hibernate.Session;

public class AuthorDAOImpl implements AuthorDAO {
    @Override
    public Author save(Author author) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
        return author;
    }

    @Override
    public Author findById(long id) {
        Session session = Init.getSession();
        session.beginTransaction();
        Query<Author> query = session.createQuery("select author from Author author where author.id=:id");
        query.setParameter ("id", id);
        return query.getSingleResult();
    }

    @Override
    public Author update(Author author) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.update(author);
        session.getTransaction().commit();
        session.close();
        return author;
    }

    @Override
    public Author remove(long id) {
        Session session = Init.getSession();
        session.beginTransaction();
        Author author= session.load(Author.class, id);
        if (author!= null) {
            session.delete(author);
        }
        session.getTransaction().commit();
        session.close();
        return author;
    }
}
