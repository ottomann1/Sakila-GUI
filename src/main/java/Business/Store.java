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
import java.util.Objects;

@Entity
public class Store {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private byte storeId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

//    @OneToMany(mappedBy = "store")
//    private Collection<Inventory> inventoriesByStoreId;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    private Staff staff;

    @Override
    public String toString() {
        return  "Store ID: " + storeId + "\n" +
                "Manager: " + staff + "\n" +
                "Address: " + address + "\n" +
//                "Inventories by upstore ID=" + inventoriesByStoreId + "\n" +
                "Store last updated: " + lastUpdate;
    }

//    public Store(byte storeId, Staff staff, Address address, Timestamp lastUpdate) {
//        this.storeId = storeId;
//        this.staff = staff;
//        this.address = address;
//        this.lastUpdate = lastUpdate;
//    }

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

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

//    public Collection<Inventory> getInventoriesByStoreId() {
//        return inventoriesByStoreId;
//    }
//
//    public void setInventoriesByStoreId(Collection<Inventory> inventoriesByStoreId) {
//        this.inventoriesByStoreId = inventoriesByStoreId;
//    }

    public Store(byte storeId, Staff staff, Address address, Timestamp lastUpdate) {
        this.storeId = storeId;
        this.staff = staff;
        this.address = address;
        this.lastUpdate = lastUpdate;
//        this.inventoriesByStoreId = inventoriesByStoreId;
    }

}
