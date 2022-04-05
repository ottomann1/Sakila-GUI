package Business;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Inventory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "inventory_id")
    private int inventoryId;
    @Basic
    @Column(name = "film_id")
    private int filmId;
    @Basic
    @Column(name = "store_id")
    private int storeId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    //ska nog inte se ut såhär men

    @ManyToOne
    @JoinColumn(name = "store_by_stored_id_store_id")
    private Store storeByStoredId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_by_store_id_store_id")
    private Store storeByStoreId;

    public Store getStoreByStoreId() {
        return storeByStoreId;
    }

    public void setStoreByStoreId(Store storeByStoreId) {
        this.storeByStoreId = storeByStoreId;
    }

    public Store getStoreByStoredId() {
        return storeByStoredId;
    }

    public void setStoreByStoredId(Store storeByStoredId) {
        this.storeByStoredId = storeByStoredId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
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
        Inventory inventory = (Inventory) o;
        return Objects.equals(inventoryId, inventory.inventoryId) && Objects.equals(filmId, inventory.filmId) && Objects.equals(storeId, inventory.storeId) && Objects.equals(lastUpdate, inventory.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, filmId, storeId, lastUpdate);
    }
}
