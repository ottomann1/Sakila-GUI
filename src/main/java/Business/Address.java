package Business;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "address_id")
    private short addressId;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "address2")
    private String address2;
    @Basic
    @Column(name = "district")
    private String district;
    @Basic
    @Column(name = "postal_code")
    private String postalCode;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "location")
    private byte[] location;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "address")
    private Set<Staff> staff = new LinkedHashSet<>();

    @OneToMany(mappedBy = "address")
    private Set<Store> stores = new LinkedHashSet<>();

    @OneToMany(mappedBy = "address")
    private Set<Customer> customers = new LinkedHashSet<>();

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }


    public Set<Staff> getStaff() {
        return staff;
    }

    public void setStaff(Set<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return address;
    }

    public String toStringHeavy() {
        return "Address: " + address + "\n" +
                "District: " + district + "\n" +
                "PostalCode: " + postalCode + "\n" +
                "Phone: " + phone + "\n" +
                "City: " + city + "\n" +
                "Address last updated: " + lastUpdate;
    }

    public Address(short addressId, String address, String district, City city, String postalCode, String phone, byte[] location, Timestamp lastUpdate) {
        this.addressId = addressId;
        this.address = address;
        this.district = district;
        this.city = city;
        this.postalCode = postalCode;
        this.phone = phone;
        this.location = location;
        this.lastUpdate = lastUpdate;
    }

    public Address() {
    }

    public short getAddressId() {
        return addressId;
    }

    public void setAddressId(short addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

//    public int getCityId() {
//        return cityId;
//    }
//
//    public void setCityId(int cityId) {
//        this.cityId = cityId;
//    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getLocation() {
        return location;
    }

    public void setLocation(byte[] location) {
        this.location = location;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
