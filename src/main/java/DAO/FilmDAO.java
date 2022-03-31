package DAO;

import Business.Film;
import Database.Data;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.*;

public class FilmDAO implements DAO {
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Film> film = Optional.ofNullable((Film) data.getData(Film.class, (int) id));
        return film;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> filmObjects = data.getDataListQuery("SELECT * FROM film", Film.class);
        List<Film> films = new ArrayList<Film>();
        for (Object[] o : filmObjects) {
            Film film = new Film((Integer) o[0], o[1].toString(), o[2].toString(), (Date) o[3], (Integer) o[4], (Integer) o[5], (Integer) o[6], (BigDecimal) o[7], (Integer) o[8], (BigDecimal) o[9], (Enum) o[10], (Set) o[11], (Timestamp) o[12]);
            films.add(film);
        }
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
