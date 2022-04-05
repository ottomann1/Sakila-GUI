package DAO;

import Business.Actor;
import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActorDAO implements DAO{
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Actor> actor = Optional.ofNullable((Actor) data.getData(Actor.class, (short) id));
        return actor;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
    Data data = new Data();
    List<Object[]> actorObjects = data.getDataListQuery("SELECT * FROM actor");
    List<Actor> actors = new ArrayList<Actor>();
        for (Object[] o : actorObjects) {
        Actor actor = new Actor((Short) o[0], o[1].toString(), o[2].toString(), (Timestamp) o[3]);
        actors.add(actor);
    }
        return actors;
    }

    @Override
    public void create(Object o) throws IOException, ClassNotFoundException {

    }

    @Override
    public void update(Object newT, Object oldT) throws IOException {

    }

    @Override
    public void delete(Object o) throws IOException {

    }

    @Override
    public void deleteAll() throws IOException {

    }
}
