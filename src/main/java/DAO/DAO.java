package DAO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Object read(long id) throws IOException, ClassNotFoundException;
//    Data data = new Data();
//    Optional<XXX> xxx = Optional.ofNullable((XXX) data.getData(XXX.class, (int) id));
//    return xxx;


    List<T> readAll() throws IOException, ClassNotFoundException;
//    Data data = new Data();
//    List<Object[]> xxxObjects = data.getDataListQuery("SELECT * FROM xxx", XXX.class);
//    List<XXX> xxxs = new ArrayList<XXX>();
//        for (Object[] o : xxxObjects) {
//        XXX xxx = new XXX();
//        xxxs.add(xxx);
//    }
//        return xxxs;

    void create(T t) throws IOException, ClassNotFoundException;
//     Data data = new Data();
//     data.setData(o);

    void update(T newT, T oldT) throws IOException;
//    Data data = new Data();
//        data.updateData(newT);

    void delete(T t) throws IOException;
//    Data data = new Data();
//    XXX xxx = (XXX) o;
//        data.deleteEm(XXX.class, xxx.getXXXId());

    void deleteAll() throws IOException;
}
