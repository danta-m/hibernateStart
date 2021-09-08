package library.DAO;

import library.entity.User;

public interface UserDAO {
    User save(User user);

    User getById(long id);

    User update(User user);

    User delete(long id);

}
