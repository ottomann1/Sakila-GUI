package DAO;

import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class CountryDAO implements DAO{

    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
   Optional<Country> country = Optional.ofNullable((Country) data.getData(Country.class, (int) id));
    return country;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
  List<Object[]> countryObjects = data.getDataListQuery("SELECT * FROM country", Country.class);
    List<Country> countrys = new ArrayList<Country>();
       for (Object[] o : countryObjects) {
       Country country = new Country((Integer) o[0], o[1] String, (Timestamp) o [2]);
        countrys.add(country);
   }
        return countrys;

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
   Country country = (Country) o;
        data.deleteEm(Country.class, country.getCountryId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
