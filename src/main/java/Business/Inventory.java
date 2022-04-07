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

    @ManyToOne
    @Column(name = "film_id")
    private Film film;

    @ManyToOne
    @Column(name = "store_id")
    private Store store;

    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Inventory(int inventoryId, Film filmId, Store storeId, Timestamp lastUpdate) {
        this.inventoryId = inventoryId;
        this.film = filmId;
        this.store = storeId;
        this.lastUpdate = lastUpdate;
    }

    public Inventory() {
    }

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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
