package DAO;

import Business.Address;
import Business.City;
import Business.Country;
import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements DAO{
    @Override
    public Object read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Object city = data.getData(City.class, (int) id);
        return city;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> cityObjects = data.getDataListQuery("SELECT * FROM city");
        List<City> city = new ArrayList<City>();
        for (Object[] o : cityObjects) {
//            Address address = new Address((Integer) o[0], o[1].toString(), o[2].toString(), o[3].toString(), (Integer) o[4], o[5].toString(), o[6].toString(), o[7].toString(), (Timestamp) o[8]);
            City cityObj = new City((Integer) o[0],o[1].toString(),(Timestamp) o[2], (Country) o[3]);
            city.add(cityObj);
        }
        return city;
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
