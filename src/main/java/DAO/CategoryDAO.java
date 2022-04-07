package DAO;

import Business.Category;
import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDAO implements DAO {

    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Category> category = Optional.ofNullable((Category) data.getData(Category.class, (byte) id));
        return category;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> categoryObjects = data.getDataListQuery("SELECT * FROM category");
        List<Category> categorys = new ArrayList<Category>();
        for (Object[] o : categoryObjects) {
            Category category = new Category((byte) o[0], o[1].toString(), (Timestamp) o[2]);
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
