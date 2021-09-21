package library.DAO;

import library.entity.Author;

public interface AuthorDAO {
    Author save (Author author);

    Author findById (long id);

    Author update (Author author);

    Author remove (long id);
}
