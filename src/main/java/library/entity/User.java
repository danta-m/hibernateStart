package library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String userName;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books;

    public User() {
    }
}
