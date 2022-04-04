package DAO;

import Business.Rental;
import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentalDAO implements DAO {
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Rental> rental = Optional.ofNullable((Rental) data.getData(Rental.class, (int) id));
        return rental;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> rentalObjects = data.getDataListQuery("SELECT * FROM rental");
        List<Rental> rentals = new ArrayList<Rental>();
        for (Object[] o : rentalObjects) {
            Rental rental = new Rental((Integer) o[0], (Timestamp) o[1], (int) o[2], (int) o[3], (Timestamp) o[4], (int) o[5], (Timestamp) o[6]);
            rentals.add(rental);
        }
        return rentals;
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
        Rental rental = (Rental) o;
        data.deleteEm(Rental.class, rental.getRentalId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
