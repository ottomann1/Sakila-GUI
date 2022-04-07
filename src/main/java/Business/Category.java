package Business;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @Override
    public String toString() {return name;
    }


    public Category(byte categoryId, String name, Timestamp lastUpdate) {
        this.categoryId = categoryId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }
    public Category(){

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Category category = (Category) o;
        return categoryId == category.categoryId && Objects.equals(name, category.name) && Objects.equals(lastUpdate, category.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, lastUpdate);
    }
}
