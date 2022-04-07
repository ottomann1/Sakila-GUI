package DAO;

import Business.Film;
import DAO.kopplingstabeller.FilmActor;
import DAO.kopplingstabeller.FilmCategory;
import Database.Data;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class FilmDAO implements DAO {
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Film> film = Optional.ofNullable((Film) data.getData(Film.class, (short) id));
        return film;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> filmObjects = data.getDataListQuery("SELECT * FROM upfilm");
        List<Film> films = new ArrayList<Film>();
        FilmActor filmActor = new FilmActor();
        FilmCategory filmCategory = new FilmCategory();
        for (Object[] o : filmObjects) {
            Film film = new Film((Short) o[0], o[1].toString(), o[2].toString(), (Date) o[3], (Byte) o[4],
                    (Byte) o[6], (BigDecimal) o[7], (Short) o[8], (BigDecimal) o[9],
                    o[10].toString(), o[11].toString(), (Timestamp) o[12], filmActor.getActorsByFilmId((Short)o[0]),
                    filmCategory.getCategoriesByFilmId((Short) o[0]));
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
