package DAO;

import Business.Address;
import Business.Inventory;
import Business.Staff;
import Business.Store;
import DAO.kopplingstabeller.InventoryGetter;
import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class StoreDAO implements DAO{
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
  Optional<Store> store = Optional.ofNullable((Store) data.getData(Store.class, (byte) id));
   return store;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
   List<Object[]> storeObjects = data.getDataListQuery("SELECT * FROM store");
    List<Store> stores = new ArrayList<Store>();
    StaffDAO staffDAO = new StaffDAO();
    AddressDAO addressDAO = new AddressDAO();
        for (Object[] o : storeObjects) {
        Store store = new Store((byte) o[0], (Staff) staffDAO.read((byte) o[1]).get(), (Address) addressDAO.read((short) o[2]).get(),
                (Timestamp) o[3]);
        stores.add(store);
    }
        return stores;
    }

    @Override
    public void create(Object o) throws IOException, ClassNotFoundException {
     Data data = new Data();
     data.setData(o);
    }

    @Override
    public void update(Object newT, Object oldT) throws IOException {
    Data data = new Data();
        data.updateData(newT);
    }

    @Override
    public void delete(Object o) throws IOException {
    Data data = new Data();
    Store store = (Store) o;
        data.deleteEm(Store.class, store.getStoreId());

    }

    @Override
    public void deleteAll() throws IOException {

    }
}
