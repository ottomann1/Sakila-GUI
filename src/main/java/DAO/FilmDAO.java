package DAO;

import Business.Actor;
import Business.Film;
import Database.Data;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class FilmDAO implements DAO {

    private ActorDAO actorDAO = new ActorDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    public Object read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Object film = data.getData(Film.class, (int) id);
        return film;
    }

//    public Collection<Actor> getActors(){
//
//
//    }

//    @Override
//    public List readAll() throws IOException, ClassNotFoundException {
//        Data data = new Data();
//        List<Object[]> filmObjects = data.getDataListQuery("SELECT * FROM film");
//        List<Film> films = new ArrayList<Film>();
//        filmActor filmActor = new filmActor();
//        for (Object[] o : filmObjects) {
//            Film film = new Film((Short) o[0], o[1].toString(), o[2].toString(), (Date) o[3], (Byte) o[4],
//                    (Byte) o[6], (BigDecimal) o[7], (Short) o[8], (BigDecimal) o[9],
//                    o[10].toString(), o[11].toString(), (Timestamp) o[12], filmActor.getActorsByFilmId((Short)o[0]));
//            films.add(film);
//        }
//        return films;
//    }

    /*
    public Film(short filmId, String title, String description, Date releaseYear,
                byte languageId, byte rentalDuration,
                BigDecimal rentalRate, short length, BigDecimal replacementCost,
                String rating, String specialFeatures, Timestamp lastUpdate,
                Collection<Actor> actor)
     */
    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> filmObjects = data.getDataListQuery("SELECT * FROM film");
        List<Film> films = new ArrayList<Film>();

        for(var element : filmObjects) {
            films.add(new Film((Integer) element[0], element[1].toString(), element[2].toString(), (Date) element[3],
                    (Byte) element[4], (Byte) element[5], (BigDecimal) element[6], (Integer) element[7], (BigDecimal) element[8],
                    element[9].toString(), element[10].toString(), (Timestamp) element[11], (Collection<Actor>) element[12]));
        }
//        for (Object[] o : filmObjects) {
//            Film film = new Film((Short) o[0], o[1].toString(), o[2].toString(), (Date) o[3], (Byte) o[4],
//                    (Byte) o[6], (BigDecimal) o[7], (Short) o[8], (BigDecimal) o[9],
//                    o[10].toString(), o[11].toString(), (Timestamp) o[12], filmActor.getActorsByFilmId((Short)o[0]));
//            films.add(film);
//        }
        return films;
    }

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
        Film film = (Film) o;
        data.deleteEm(Film.class, film.getFilmId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
