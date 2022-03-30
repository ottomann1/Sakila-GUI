package DAO;

import Business.Address;
import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressDAO implements DAO{
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
   Optional<Address> address = Optional.ofNullable((Address) data.getData(Address.class, (int) id));
    return address;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
            Data data = new Data();
   List<Object[]> addressObjects = data.getDataListQuery("SELECT * FROM address", Address.class);
    List<Address> addresss = new ArrayList<Address>();
       for (Object[] o : addressObjects) {
       Address address = new Address((Integer) o[0],o[1].toString(),o[2].toString(),o[3].toString(),(Integer)o[4],o[5].toString(),o[6].toString(),o[7], (Timestamp) o[8]);
      addresss.add(address);
    }
       return addresss;
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
    Address address = (Address) o;
        data.deleteEm(Address.class, address.getAddressId());


    }

    @Override
    public void deleteAll() throws IOException {

    }
}
