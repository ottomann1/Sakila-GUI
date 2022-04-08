package Business;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "city_id")
    private short cityId;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "address")
    private Collection<Address> addressesByCityId;

    @OneToMany(mappedBy = "city")
    private Set<Address> addresses = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return city;
    }

    public City(short cityId, String city, Country country, Timestamp lastUpdate) {
        this.cityId = cityId;
        this.city = city;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public City() {
    }

    public City(short cityId, String city, Country country, Timestamp lastUpdate, Collection<Address> addressesByCityId) {
        this.cityId = cityId;
        this.city = city;
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.addressesByCityId = addressesByCityId;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Collection<Address> getAddressesByCityId() {
        return addressesByCityId;
    }

    public void setAddressesByCityId(Collection<Address> addressesByCityId) {
        this.addressesByCityId = addressesByCityId;
    }

    public short getCityId() {
        return cityId;
    }

    public void setCityId(short cityId) {
        this.cityId = cityId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
