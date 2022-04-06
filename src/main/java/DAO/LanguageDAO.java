package DAO;

import Database.Data;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class LanguageDAO implements DAO{

    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
    Optional<Language> language = Optional.ofNullable((Language) data.getData(Language.class, (int) id));
    return language;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> languageObjects = data.getDataListQuery("SELECT * FROM language", Language.class);
        List<Language> languages = new ArrayList<Language>();
        for (Object[] o : languageObjects) {
            Language language = new Language((Integer) o[0], o[1] String, (Timestamp) o[2]);
            languages.add(language);
        }
        return languages;
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
   Language language = (Language) o;
       data.deleteEm(Language.class, language.getLanguageId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
