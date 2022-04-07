package DAO;

import Business.Address;
import Business.Staff;
import Business.Store;
import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StaffDAO implements DAO {
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Staff> staff = Optional.ofNullable((Staff) data.getData(Staff.class, (byte) id));
        return staff;

    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> staffObjects = data.getDataListQuery("SELECT * FROM staff");
        List<Staff> staffs = new ArrayList<Staff>();
        StoreDAO storeDAO = new StoreDAO();
        for (Object[] o : staffObjects) {
            Staff staff = new Staff((byte) o[0], o[1].toString(), o[2].toString(), (Address) (data.getData(Address.class, (short) o[3])), (byte[]) o[4], o[5].toString(),
                    (Store) storeDAO.read((byte) o[6]).get(), (boolean) o[7], o[8].toString(), (Timestamp) o[10]);
            if(o[9]!=null)
                staff.setPassword(o[9].toString());
            staffs.add(staff);
        }
        return staffs;
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
        Staff staff = (Staff) o;
        data.deleteEm(Staff.class, staff.getStaffId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
