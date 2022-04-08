package Business;

import DAO.ActorDAO;
import DAO.StaffDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javax.persistence.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Store {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private byte storeId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_staff_id", nullable = false)
    private Staff managerStaff;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "store")
    private Set<Inventory> inventories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<Staff> staff = new LinkedHashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<Customer> customers = new LinkedHashSet<>();

    public Store(byte b, Staff staff, Address address, Timestamp timestamp) {
        this.storeId=b;
        this.staff.add(staff);
        this.address=address;
        this.lastUpdate=timestamp;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Staff> getStaff() {
        return staff;
    }

    public void setStaff(Set<Staff> staff) {
        this.staff = staff;
    }
    public void setStaff(Staff staff) {
        this.staff.add(staff);
    }
    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Staff getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(Staff managerStaff) {
        this.managerStaff = managerStaff;
    }


    @Override
    public String toString() {
        return "Store{" +
                "address=" + address +
                '}';
    }

    public String toStringHeavy() {
        return  "Store ID: " + storeId + "\n" +
                "Manager: " + staff + "\n" +
                "Address: " + address + "\n" +
//                "Inventories by upstore ID=" + inventoriesByStoreId + "\n" +
                "Store last updated: " + lastUpdate;
    }

    public Store() {
    }



    public byte getStoreId() {
        return storeId;
    }

    public void setStoreId(byte storeId) {
        this.storeId = storeId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
