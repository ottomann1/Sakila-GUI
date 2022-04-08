package Business.Coupling;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FilmActorId implements Serializable {
    private static final long serialVersionUID = 889720117931037281L;
    @Column(name = "actor_id")
    public short actorId;
    @Column(name = "film_id")
    public short filmId;

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public short getActorId() {
        return actorId;
    }

    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    public FilmActorId() {
    }

    public FilmActorId(short actorId, short filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmActorId entity = (FilmActorId) o;
        return Objects.equals(this.actorId, entity.actorId) &&
                Objects.equals(this.filmId, entity.filmId);
    }
}