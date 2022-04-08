package DAO;

import Business.Customer;
import Business.Inventory;
import Business.Rental;
import Business.Staff;
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
        Optional<Rental> rental = Optional.ofNullable((Rental) data.getData(Rental.class, (short) id));
        return rental;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> rentalObjects = data.getDataListQuery("SELECT * FROM rental");
        List<Rental> rentals = new ArrayList<Rental>();
        InventoryDAO inventoryDAO = new InventoryDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        StaffDAO staffDAO = new StaffDAO();
        for (Object[] o : rentalObjects) {
            Rental rental = new Rental((Integer) o[0], (Timestamp) o[1], (Inventory) o[2], (Customer) o[3], (Timestamp) o[4], (Staff) o[5], (Timestamp) o[6]);
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
