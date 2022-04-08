package Business;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Staff {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "staff_id")
    private byte staffId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Basic
    @Column(name = "picture")
    private byte[] picture;
    @Basic
    @Column(name = "email")
    private String email;
    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @Basic
    @Column(name = "active")
    private boolean active;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;
//    @OneToMany(mappedBy = "paymentsByStaffId")
//    private Collection<Payment> paymentsByStaffId;
//    @OneToMany(mappedBy = "rentalsByStaffId")
//    private Collection<Rental> rentalsByStaffId;

    public String toStringHeavy() {
        return
                "Staff Member: " + firstName + lastName + "\n" +
                        "Address: " + address + "\n" +
                        "Email: " + email + "\n" +
                        "Store: " + store + "\n" +
                        "Staff member last updated: " + lastUpdate;
    }

    public Staff(byte staffId, String firstName, String lastName, Address address, byte[] picture, String email, Store store, boolean active, String username, String password, Timestamp lastUpdate) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.picture = picture;
        this.email = email;
        this.store = store;
        this.active = active;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
    }
    public Staff(byte staffId, String firstName, String lastName, Address address, byte[] picture, String email, Store store, boolean active, String username, Timestamp lastUpdate) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.picture = picture;
        this.email = email;
        this.store = store;
        this.active = active;
        this.username = username;
        this.lastUpdate = lastUpdate;
    }

    public Staff() {
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public byte getStaffId() {
        return staffId;
    }

    public void setStaffId(byte staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
