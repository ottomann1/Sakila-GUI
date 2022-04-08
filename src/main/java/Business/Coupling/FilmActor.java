package Business.Coupling;

import Business.Actor;
import Business.Film;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "film_actor", indexes = {
        @Index(name = "idx_fk_film_id", columnList = "film_id")
})
public class FilmActor {
    @EmbeddedId
    private FilmActorId id;

    @MapsId("actorId")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @MapsId("filmId")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    public FilmActor(Actor actor, Film film) {
        this.actor = actor;
        this.film = film;
    }

    public FilmActor(FilmActorId id, Actor actor, Film film, Instant lastUpdate) {
        this.id = id;
        this.actor = actor;
        this.film = film;
        this.lastUpdate = lastUpdate;
    }

    public FilmActor() {
    }


    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public FilmActorId getId() {
        return id;
    }

    public void setId(FilmActorId id) {
        this.id = id;
    }
}