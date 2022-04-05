package DAO;

import Business.Category;
import Business.Film;
import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CategoryDAO implements DAO {
    @Override
    public Object read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Object category = data.getData(Category.class, (int) id);
        return category;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> categoryObjects = data.getDataListQuery("SELECT * FROM category");
        List<Category> categorys = new ArrayList<Category>();
        for (Object[] o : categoryObjects) {
            Category category = new Category((Integer) o[0], o[1].toString(), (Timestamp) o[2], (Collection<Film>) o[3]);
            categorys.add(category);
        }
        return categorys;
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
        Category category = (Category) o;
        data.deleteEm(Category.class, category.getCategoryId());

    }

    @Override
    public void deleteAll() throws IOException {

    }
}
