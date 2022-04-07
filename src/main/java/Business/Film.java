package Business;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Film {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "film_id")
    private short filmId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "release_year")
    private Date releaseYear;
    @Basic
    @Column(name = "language_id")
    private Byte languageId;
    @Basic
    @Column(name = "original_language_id")
    private Byte originalLanguageId;
    @Basic
    @Column(name = "rental_duration")
    private Byte rentalDuration;
    @Basic
    @Column(name = "rental_rate")
    private BigDecimal rentalRate;
    @Basic
    @Column(name = "length")
    private short length;
    @Basic
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;
    @Basic
    @Column(name = "rating")
    private String rating;
    @Basic
    @Column(name = "special_features")
    private String specialFeatures;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_actor",
            joinColumns = {@JoinColumn(name = "actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id")}
    )

    private Collection<Actor> actor = new ArrayList<Actor>();

//    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;


    public String toStringHeavy() {
        return     title + "\n" +
                "Actors: " + actor + "\n" +
                "Release Year: " + releaseYear + "\n" +
                "Language: " + languageId + "\n" +
                "Length: " + length + "\n" +
                "Rating: " + rating + "\n" +
                "Description \n" + description + "\n" + "\n" +
                "Rental Duration: " + rentalDuration + "\n" +
                "Rental Rate: " + rentalRate + "\n" +
                "Replacement Cost: " + replacementCost + "\n" +
                "Special Features: " + specialFeatures + "\n" +
                "Film last updated: " + lastUpdate;
    }

    public Film(short filmId, String title, String description, Date releaseYear,
                byte languageId, byte rentalDuration,
                BigDecimal rentalRate, short length, BigDecimal replacementCost,
                String rating, String specialFeatures, Timestamp lastUpdate,
                Collection<Actor> actor) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.lastUpdate = lastUpdate;
        this.actor = actor;
//        this.category = category;
    }

    public Film(){

    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public Collection<Actor> getActor() {
        return actor;
    }

    public void setActor(Collection<Actor> actor) {
        this.actor = actor;
    }

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Byte languageId) {
        this.languageId = languageId;
    }

    public Byte getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Byte originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public void setRentalDuration(Byte rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmId == film.filmId && languageId == film.languageId && originalLanguageId == film.originalLanguageId && Objects.equals(title, film.title) && Objects.equals(description, film.description) && Objects.equals(releaseYear, film.releaseYear) && Objects.equals(rentalDuration, film.rentalDuration) && Objects.equals(rentalRate, film.rentalRate) && Objects.equals(length, film.length) && Objects.equals(replacementCost, film.replacementCost) && Objects.equals(rating, film.rating) && Objects.equals(specialFeatures, film.specialFeatures) && Objects.equals(lastUpdate, film.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, description, releaseYear, languageId, originalLanguageId, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, lastUpdate);
    }
}
