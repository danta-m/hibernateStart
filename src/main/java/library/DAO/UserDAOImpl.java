package library.DAO;

import library.entity.User;
import org.hibernate.Session;

import static library.Main.initDB;

public class UserDAOImpl implements UserDAO {

    @Override
    public User save(User user) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User getById(long id) {
        Session session = initDB.getSession();
        session.beginTransaction();
        User user = session.load(User.class, new Long(id));
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User update(User user) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User delete(long id) {
        Session session = initDB.getSession();
        session.beginTransaction();
        User user = session.load(User.class, new Long(id));
        if (user!= null) {
            session.delete(user);
        }
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
