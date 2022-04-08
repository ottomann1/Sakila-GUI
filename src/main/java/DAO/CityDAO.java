package DAO;

import Business.City;
import Business.Country;
import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDAO implements DAO {
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<City> city = Optional.ofNullable((City) data.getData(City.class, (short) id));
        return city;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException{
        Data data = new Data();
        List<Object[]> cityObjects = data.getDataListQuery("SELECT * FROM city");
        List<City> citys = new ArrayList<City>();
        CountryDAO countryDAO = new CountryDAO();
        for (Object[] o : cityObjects) {
            City city = new City((short) o[0], o[1].toString(), (Country) countryDAO.read((short) o[2]).get(), (Timestamp) o[3]);
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