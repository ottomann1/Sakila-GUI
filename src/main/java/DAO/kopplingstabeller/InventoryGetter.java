package DAO.kopplingstabeller;

import Business.Film;
import Business.Inventory;
import DAO.FilmDAO;
import DAO.InventoryDAO;
import Database.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryGetter {
    public List<Inventory> getInventoryByFilmId(short id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        InventoryDAO inventoryDAO = new InventoryDAO();
        List<Inventory> inventories = new ArrayList<Inventory>();
        List<Object[]> objects = data.getDataListQuery("SELECT * FROM inventory where film_id = "+id);
        for(Object[] o:objects){
            inventories.add((Inventory) inventoryDAO.read((short)o[0]).get());
        }
        return inventories;
    }

    public List<Inventory> getInventoryByStoreId(short id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        InventoryDAO inventoryDAO = new InventoryDAO();
        List<Inventory> inventories = new ArrayList<Inventory>();
        List<Object[]> objects = data.getDataListQuery("SELECT * FROM inventory where store_id = "+id);
        for(Object[] o:objects){
            inventories.add((Inventory) inventoryDAO.read((short)o[0]).get());
        }
        return inventories;
    }

    public List<Film> getFilmsInInventory(Inventory inventory) throws IOException, ClassNotFoundException {
        FilmDAO filmDAO = new FilmDAO();
        List<Film> films = new ArrayList<Film>();
        Data data = new Data();
        List<Object[]> x = data.getDataListQuery("SELECT * FROM inventory WHERE film_id = "+inventory.getFilmId());
        for (int i = 0; i < x.size(); i++) {
            films.add((Film) filmDAO.read(inventory.getFilmId()).get());
        }
        return films;
    }
}