package Business;

import Business.Coupling.FilmActor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Actor {

    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private short id;

//    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "actor")
//    private Set<FilmActor> filmActors = new LinkedHashSet<>();

//    public Set<FilmActor> getFilmActors() {
//        return filmActors;
//    }

//    public void setFilmActors(Set<FilmActor> filmActors) {
//        this.filmActors = filmActors;
//    }
//    public void setFilmActors(FilmActor filmActor) {
//        if(this.filmActors.isEmpty()){
//            Set<FilmActor> ffff = new LinkedHashSet<>();
//            ffff.add(filmActor);
//            filmActors = ffff;
//            }
//        else filmActors.add(filmActor);
//    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return firstName +" " +lastName;
    }

    public String toStringHeavy() {
        return id +
                firstName + " " + lastName + "\n" +
                "Actor profile last updated: " + lastUpdate;
    }

    public Actor(short actorId, String firstName, String lastName, Timestamp lastUpdate) {
        this.id = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public Actor() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
