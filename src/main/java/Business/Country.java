package Business;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id")
    private short countryId;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Country(short countryId, String country, Timestamp lastUpdate) {
        this.countryId = countryId;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public Country() {
    }

    public short getCountryId() {
        return countryId;
    }

    public void setCountryId(short countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        Country country1 = (Country) o;
        return countryId == country1.countryId && Objects.equals(country, country1.country) && Objects.equals(lastUpdate, country1.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, country, lastUpdate);
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", country='" + country + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
