package Business.Coupling;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FilmCategoryId implements Serializable {
    private static final long serialVersionUID = -1200360320153705355L;
    @Column(name = "film_id")
    private short filmId;
    @Column(name = "category_id")
    private short categoryId;

    public FilmCategoryId(short filmId, short categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }

    public FilmCategoryId() {
    }

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(short categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, categoryId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmCategoryId entity = (FilmCategoryId) o;
        return Objects.equals(this.filmId, entity.filmId) &&
                Objects.equals(this.categoryId, entity.categoryId);
    }
}