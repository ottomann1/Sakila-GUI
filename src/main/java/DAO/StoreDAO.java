package DAO;

import Database.Data;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class StoreDAO implements DAO{
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
  Optional<Store> store = Optional.ofNullable((Store) data.getData(Store.class, (int) id));
   return store;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
   List<Object[]> storeObjects = data.getDataListQuery("SELECT * FROM store", Store.class);
    List<Store> stores = new ArrayList<Store>();
        for (Object[] o : storeObjects) {
        Store store = new Store();
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
