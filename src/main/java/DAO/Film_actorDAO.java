package DAO;

import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class Film_actorDAO implements DAO{
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
    Optional<Film_actor> film_actor = Optional.ofNullable((Film_actor) data.getData(Film_actor.class, (int) id));
    return film_actor;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
    List<Object[]> film_actorObjects = data.getDataListQuery("SELECT * FROM film_actor", Film_actor.class);
   List<Film_actor> film_actors = new ArrayList<Film_actor>();
       for (Object[] o : film_actorObjects) {
       Film_actor film_actor = new Film_actor((Integer) o[0], (Integer) o[1], (Timestamp) o[2]);
        film_actors.add(film_actor);
    }
                return film_actors;


    @Override
    public void create(Object o) throws IOException, ClassNotFoundException {
    Data data = new Data();
     data.setData(o);
    }

    @Override
    public void update(Object newT, Object oldT) throws IOException {
   Data data = new Data();
       data.updateData(newT);
    }

    @Override
    public void delete(Object o) throws IOException {
    Data data = new Data();
    Film_actor film_actor = (Film_actor) o;
        data.deleteEm(Film_actor.class, film_actor.getFilm_actorId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
