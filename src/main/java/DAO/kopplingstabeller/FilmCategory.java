package DAO.kopplingstabeller;

import Business.Category;
import Business.Film;
import DAO.CategoryDAO;
import DAO.FilmDAO;
import Database.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilmCategory {

    public List<Film> getFilmsByCategoryId(short id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        FilmDAO filmDAO = new FilmDAO();
        List<Film> films = new ArrayList<Film>();
        List<Object[]> objects = data.getDataListQuery("SELECT * FROM film_category WHERE category_id = " + id);
        for (Object[] o : objects) {
            films.add((Film) filmDAO.read((short) o[0]).get());
        }
        return films;
    }

    public void createFilmIdAndCategoryId(short filmId, short categoryId){
        Data data = new Data();
        data.setDataQuery("INSERT INTO film_category VALUES ("+filmId+", "+categoryId+");");
    }

    public List<Category> getCategoriesByFilmId(short id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = new ArrayList<Category>();
        FilmDAO filmDAO = new FilmDAO();
        List<Object[]> objects = data.getDataListQuery("SELECT * FROM film_category WHERE film_id = "+ id);
        for(Object[] o:objects){
            Category category = (Category) categoryDAO.read((byte) o[1]).get();
            categories.add(category);
        }
        return categories;
    }

    public Optional getCategoryByFilmId(short id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Category> category = Optional.ofNullable((Category) data.getData(Category.class, id));
        return category;
    }
}