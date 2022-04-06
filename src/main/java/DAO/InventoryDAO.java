package DAO;

import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class InventoryDAO implements DAO{


    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Inventory> inventory = Optional.ofNullable((Inventory) data.getData(Inventory.class, (int) id));
        return inventory;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
    List<Object[]> inventoryObjects = data.getDataListQuery("SELECT * FROM inventory", Inventory.class);
    List<Inventory> inventorys = new ArrayList<Inventory>();
       for (Object[] o : inventoryObjects) {
       Inventory inventory = new Inventory((Integer) o[0], (Integer) o[1],(Integer) o[2], (Timestamp) o[3]);
        inventorys.add(inventory);
    }
        return inventorys;

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
    Inventory inventory = (Inventory) o;
        data.deleteEm(Inventory.class, inventory.getInventoryId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
