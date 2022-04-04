package DAO;

import Business.Actor;
import Database.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class filmActor {
    public List<Actor> get(short id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        ActorDAO actorDAO = new ActorDAO();
        List<Actor> actors = new ArrayList<Actor>();
        List<Object[]> objects = data.getDataListQuery("SELECT * FROM film_actor where film_id = "+id);
        for(Object[] o:objects){
            actors.add((Actor) actorDAO.read((short)o[0]).get());
        }
        return actors;
    }
 }
