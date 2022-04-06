package DAO;

import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class Film_categoryDAO implements DAO{
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
    Optional<Film_category> film_category = Optional.ofNullable((Film_category) data.getData(Film_category.class, (int) id));
   return film_category;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> film_categoryObjects = data.getDataListQuery("SELECT * FROM film_category", Film_category.class);
        List<Film_category> film_categorys = new ArrayList<Film_category>();
        for (Object[] o : film_categoryObjects) {
            Film_category film_category = new Film_category((Integer) o[0], (Integer) o[1], (Timestamp) o[2]);
            film_categorys.add(film_category);
        }
        return film_categorys;
    }

        @Override
        public void create (Object o) throws IOException, ClassNotFoundException {
            Data data = new Data();
            data.setData(o);
        }

        @Override
        public void update (Object newT, Object oldT) throws IOException {
            Data data = new Data();
            data.updateData(newT);
        }

        @Override
        public void delete (Object o) throws IOException {
            Data data = new Data();
            Film_category film_category = (Film_category) o;
            data.deleteEm(Film_category.class, film_category.getFilm_categoryId());

        }
        @Override
        public void deleteAll () throws IOException {

        }
    }
