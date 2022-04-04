package DAO;

import Business.Payment;
import Database.Data;

import java.io.IOException;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;


public class PaymentDAO implements DAO {
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Payment> payment = Optional.ofNullable((Payment) data.getData(Payment.class, (int) id));
        return payment;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> paymentObjects = data.getDataListQuery("SELECT * FROM payment");
        List<Payment> payments = new ArrayList<Payment>();
        for (Object[] o : paymentObjects) {
            Payment payment = new Payment((int) o[0], (int) o[1], (int) o[2], (Integer) o[3], (BigDecimal) o[4], (Timestamp) o[5], (Timestamp) o[6]);
            payments.add(payment);
        }
        return payments;
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
        Payment payment = (Payment) o;
        data.deleteEm(Payment.class, payment.getPaymentId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
