package Business;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

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
    @Column(name = "return_date")
    private Timestamp returnDate;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @OneToMany(mappedBy = "rental")
    private Set<Payment> payments = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Rental(Integer rentalId, Timestamp rentalDate, Inventory inventory, Customer customer, Timestamp returnDate, Staff staff, Timestamp lastUpdate) {
    this.rentalId=rentalId;
    this.rentalDate=rentalDate;
    this.inventory=inventory;
    this.customer=customer;
    this.returnDate=returnDate;
    this.staff=staff;
    this.lastUpdate=lastUpdate;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Rental(int rentalId, Timestamp rentalDate, Inventory inventory, Timestamp returnDate, Staff staff, Timestamp lastUpdate, Customer customer, Set<Payment> payments) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.inventory = inventory;
        this.returnDate = returnDate;
        this.staff = staff;
        this.lastUpdate = lastUpdate;
        this.customer = customer;
        this.payments = payments;
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

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

//    public Customer getCustomerByCustomerId() {
//        return customerByCustomerId;
//    }
//
//    public void setCustomerByCustomerId(Customer customerByCustomerId) {
//        this.customerByCustomerId = customerByCustomerId;
//    }
}
