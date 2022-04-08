package Business;

import Business.Coupling.FilmCategory;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Category {

    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

//    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "category")
//    private Set<FilmCategory> filmCategories = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private byte id;


//    public Set<FilmCategory> getFilmCategories() {
//        return filmCategories;
//    }
//
//    public void setFilmCategories(Set<FilmCategory> filmCategories) {
//        this.filmCategories = filmCategories;
//    }

    @Override
    public String toString() {return name;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public Category(byte categoryId, String name, Timestamp lastUpdate) {
        this.id = categoryId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }
    public Category(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
