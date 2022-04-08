package DAO.kopplingstabeller;

import Business.Actor;
import Business.Category;
import Business.Coupling.FilmActor;
import Business.Coupling.FilmActorId;
import Business.Coupling.FilmCategory;
import Business.Film;
import DAO.ActorDAO;
import DAO.CategoryDAO;
import DAO.FilmDAO;
import Database.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilmActorDAO {
    public List<Actor> getActorsByFilmId(short id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        ActorDAO actorDAO = new ActorDAO();
        List<Actor> actors = new ArrayList<Actor>();
        List<Object[]> objects = data.getDataListQuery("SELECT * FROM film_actor where film_id = "+id);
        for(Object[] o:objects){
            actors.add((Actor) actorDAO.read((short) o[0]).get());
        }
        return actors;
    }

    public void createFilmIdAndActorId(short filmId, short actorId) throws IOException, ClassNotFoundException {
        Data data = new Data();
        FilmDAO filmDAO = new FilmDAO();
        ActorDAO actorDAO = new ActorDAO();
        Film film = (Film) filmDAO.read(filmId).get();
        Actor actor = (Actor) actorDAO.read(actorId).get();
        FilmActor filmActor = new FilmActor();
        filmActor.setActor(actor);
        filmActor.setFilm(film);
        if(data.getDataListQuery("SELECT * FROM film_actor WHERE (actor_id = "+actorId+" and film_id = "+filmId+");").isEmpty())
        data.setData(filmActor);
    }

    public void createFilmActor(Film film, Actor actor){
        FilmActor filmActor = new FilmActor(actor, film);
        Data data = new Data();
        data.setData(filmActor);
    }
    public void createFilmActor(FilmActor filmActor){
        Data data = new Data();
        FilmActorId filmActorId = new FilmActorId();
        filmActorId.setActorId(filmActor.getActor().getId());
        filmActorId.setFilmId(filmActor.getFilm().getFilmId());
        filmActor.setId(filmActorId);
        data.setData(filmActor);
    }

    public List<Film> getFilmByActorId(short id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        FilmDAO filmDAO = new FilmDAO();
        List<Film> films = new ArrayList<Film>();
        List<Object[]> objects = data.getDataListQuery("SELECT * FROM film_actor where actor_id = "+id);
        for(Object[] o:objects){
            films.add((Film) filmDAO.read((short)o[1]).get());
        }
        return films;
    }
 }