package Business;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rental {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rental_id")
    private int rentalId;
    @Basic
    @Column(name = "rental_date")
    private Timestamp rentalDate;
    @Basic
    @Column(name = "inventory_id")
    private int inventoryId;
    @Basic
    @Column(name = "customer_id")
    private int customerId;
    @Basic
    @Column(name = "return_date")
    private Timestamp returnDate;
    @Basic
    @Column(name = "staff_id")
    private int staffId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;
    @OneToMany(mappedBy = "paymentsByRentalId")
    private Collection<Payment> paymentsByRentalId;
//    @ManyToOne
//    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
//    private Customer customerByCustomerId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rentals_by_staff_id_staff_id")
    private Staff rentalsByStaffId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rental_by_staff_id_staff_id")
    private Staff rentalByStaffId;

    public Staff getRentalByStaffId() {
        return rentalByStaffId;
    }

    public void setRentalByStaffId(Staff rentalByStaffId) {
        this.rentalByStaffId = rentalByStaffId;
    }

    public Staff getRentalsByStaffId() {
        return rentalsByStaffId;
    }

    public void setRentalsByStaffId(Staff rentalsByStaffId) {
        this.rentalsByStaffId = rentalsByStaffId;
    }

    public Rental(int rentalId, Timestamp rentalDate, int inventoryId, int customerId, Timestamp returnDate, int staffId, Timestamp lastUpdate) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.inventoryId = inventoryId;
        this.customerId = customerId;
        this.returnDate = returnDate;
        this.staffId = staffId;
        this.lastUpdate = lastUpdate;
       // this.paymentsByRentalId = paymentsByRentalId;
       // this.customerByCustomerId = customerByCustomerId;
    }
    public Rental(){

    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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
        Rental rental = (Rental) o;
        return rentalId == rental.rentalId && inventoryId == rental.inventoryId && customerId == rental.customerId && staffId == rental.staffId && Objects.equals(rentalDate, rental.rentalDate) && Objects.equals(returnDate, rental.returnDate) && Objects.equals(lastUpdate, rental.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, rentalDate, inventoryId, customerId, returnDate, staffId, lastUpdate);
    }

    public Collection<Payment> getPaymentsByRentalId() {
        return paymentsByRentalId;
    }

    public void setPaymentsByRentalId(Collection<Payment> paymentsByRentalId) {
        this.paymentsByRentalId = paymentsByRentalId;
    }

//    public Customer getCustomerByCustomerId() {
//        return customerByCustomerId;
//    }
//
//    public void setCustomerByCustomerId(Customer customerByCustomerId) {
//        this.customerByCustomerId = customerByCustomerId;
//    }
}
