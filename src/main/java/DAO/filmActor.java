package DAO;

import Business.Actor;
import Business.Film;
import Database.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class filmActor {
    public List<Actor> getActorsByFilmId(short id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        ActorDAO actorDAO = new ActorDAO();
        List<Actor> actors = new ArrayList<Actor>();
        List<Object[]> objects = data.getDataListQuery("SELECT * FROM film_actor where film_id = "+id);
        for(Object[] o:objects){
            actors.add((Actor) actorDAO.read((short)o[0]).get());
        }
        return actors;
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