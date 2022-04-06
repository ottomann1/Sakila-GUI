package DAO;

import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class CityDAO implements DAO {
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
   Optional<City> city = Optional.ofNullable((City) data.getData(City.class, (int) id));
    return city;

    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
   List<Object[]> cityObjects = data.getDataListQuery("SELECT * FROM city", City.class);
   List<City> citys = new ArrayList<City>();
        for (Object[] o : cityObjects) {
       City city = new City((Integer) o[0], o[1] String, (Integer) o[2], (Timestamp) o[3]);
        citys.add(city);
    }
       return citys;
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
   City city = (City) o;
        data.deleteEm(City.class, city.getCityId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
