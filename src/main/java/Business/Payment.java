package Business;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Payment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "payment_id")
    private short paymentId;
    @Basic
    @Column(name = "customer_id")
    private short customerId;
    @Basic
    @Column(name = "staff_id")
    private short staffId;
    @Basic
    @Column(name = "rental_id")
    private Integer rentalId;
    @Basic
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic
    @Column(name = "payment_date")
    private Timestamp paymentDate;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;
//    @ManyToOne
//    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
//    private Customer customerByCustomerId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "staff_by_staff_id_staff_id")
    private Staff staffByStaffId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "payments_by_staff_id_staff_id")
    private Staff paymentsByStaffId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "payments_by_rental_id_rental_id")
    private Rental paymentsByRentalId;

    public Rental getPaymentsByRentalId() {
        return paymentsByRentalId;
    }

    public void setPaymentsByRentalId(Rental paymentsByRentalId) {
        this.paymentsByRentalId = paymentsByRentalId;
    }

    public Staff getPaymentsByStaffId() {
        return paymentsByStaffId;
    }

    public void setPaymentsByStaffId(Staff paymentsByStaffId) {
        this.paymentsByStaffId = paymentsByStaffId;
    }

    public Staff getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(Staff staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }

    public Payment(short paymentId, short customerId, short staffId, Integer rentalId, BigDecimal amount, Timestamp paymentDate, Timestamp lastUpdate) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.staffId = staffId;
        this.rentalId = rentalId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.lastUpdate = lastUpdate;
       // this.customerByCustomerId = customerByCustomerId;
    }
    public Payment(){

    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(short paymentId) {
        this.paymentId = paymentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(short customerId) {
        this.customerId = customerId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(short staffId) {
        this.staffId = staffId;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return paymentId == payment.paymentId && customerId == payment.customerId && staffId == payment.staffId && Objects.equals(rentalId, payment.rentalId) && Objects.equals(amount, payment.amount) && Objects.equals(paymentDate, payment.paymentDate) && Objects.equals(lastUpdate, payment.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, customerId, staffId, rentalId, amount, paymentDate, lastUpdate);
    }
//
//    public Customer getCustomerByCustomerId() {
//        return customerByCustomerId;
//    }
//
//    public void setCustomerByCustomerId(Customer customerByCustomerId) {
//        this.customerByCustomerId = customerByCustomerId;
//    }
}
