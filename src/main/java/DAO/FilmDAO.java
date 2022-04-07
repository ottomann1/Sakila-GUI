package DAO;

import Business.Film;
import Business.Language;
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
        List<Object[]> filmObjects = data.getDataListQuery("SELECT * FROM film");
        List<Film> films = new ArrayList<Film>();
        FilmActor filmActor = new FilmActor();
        LanguageDAO languageDAO = new LanguageDAO();
        FilmCategory filmCategory = new FilmCategory();
        for (Object[] o : filmObjects) {
            Film film = new Film((short) o[0], o[1].toString(), o[2].toString(), (Date) o[3],
                    (Language) languageDAO.read((byte)o[4]).get(),
                    (Byte) o[6], (BigDecimal) o[7], (Short) o[8], (BigDecimal) o[9],
                    o[10].toString(), (Timestamp) o[12], filmActor.getActorsByFilmId((Short)o[0]),
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

    public short createFilm(Film film) throws IOException, ClassNotFoundException {
        Data data = new Data();
        short x = data.setDataFilm(film);
        return x;
    }

    @Override
    public void update(Object newT, Object oldT) throws IOException {
        Data data = new Data();
        Film film = (Film) newT;
        film.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        data.updateData(film);
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
