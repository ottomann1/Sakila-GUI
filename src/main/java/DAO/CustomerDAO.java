package DAO;

import Business.Customer;
import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CustomerDAO implements DAO {
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Customer> customer = Optional.ofNullable((Customer) data.getData(Customer.class, (int) id));
        return customer;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> customerObjects = data.getDataListQuery("SELECT * FROM customer", Customer.class);
        List<Customer> customers = new ArrayList<Customer>();
        for (Object[] o : customerObjects) {
            Customer customer = new Customer((Integer) o[0], (Integer) o[1], o[2].toString(), o[3].toString(), o[4].toString(), (Integer) o[5], (byte) o[6], (Timestamp) o[7], (Timestamp) o[8]);
            customers.add(customer);
        }
        return customers;
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
        Customer customer = (Customer) o;
        data.deleteEm(Customer.class, customer.getCustomerId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
