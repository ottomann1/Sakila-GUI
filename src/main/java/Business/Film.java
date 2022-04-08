package Business;

import Business.Coupling.FilmActor;
import Business.Coupling.FilmCategory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

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
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "film_actor",
            joinColumns = {@JoinColumn(name = "actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id")}
    )
    private Collection<Actor> actor;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "film_category",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id")})
    private Collection<Category> category;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;



    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "film")
    private Set<Inventory> inventories = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "film")
    private Set<FilmActor> filmActors = new LinkedHashSet<>();



    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @Lob
    @Column(name = "special_features")
    private String specialFeatures;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "film")
    private Set<FilmCategory> filmCategories = new LinkedHashSet<>();

    @Column(name = "release_year")
    private Integer releaseYear;

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }


    public Set<FilmCategory> getFilmCategories() {
        return filmCategories;
    }

    public void setFilmCategories(Set<FilmCategory> filmCategories) {
        this.filmCategories = filmCategories;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Set<FilmActor> getFilmActors() {
        return filmActors;
    }

    public void setFilmActors(Set<FilmActor> filmActors) {
        this.filmActors = filmActors;
    }

    public java.util.Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }


    public String toStringHeavy() {
        return     title + "\n" +
                "Actors: " + actor + "\n" +
//                "Release Year: " + releaseYear + "\n" +
                "Language: " + language + "\n" +
                "Length: " + length + "\n" +
                "Rating: " + rating + "\n" +
                "Category: " + category.toString() +"\n"+
                "Description \n" + description + "\n" + "\n" +
                "Rental Duration: " + rentalDuration + "\n" +
                "Rental Rate: " + rentalRate + "\n" +
                "Replacement Cost: " + replacementCost + "\n" +
                "Special Features: " + specialFeatures + "\n" +
                "Film last updated: " + lastUpdate;
    }

    public Film(short filmId, String title, String description,
                Language language, byte rentalDuration,
                BigDecimal rentalRate, short length, BigDecimal replacementCost,
                String rating, Timestamp lastUpdate,
                Collection<Actor> actor, Collection<Category> category) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.language = language;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
//        this.specialFeatures = specialFeatures;
        this.lastUpdate = lastUpdate;
        this.actor = actor;
        this.category = category;
    }

    public Film(short filmId, String title, String description,
                Language language, byte rentalDuration,
                BigDecimal rentalRate, short length, BigDecimal replacementCost,
                String rating, Timestamp lastUpdate,
                Collection<Actor> actor, Category category) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.language = language;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
//        this.specialFeatures = specialFeatures;
        this.lastUpdate = lastUpdate;
        this.actor = actor;
        this.category.add(category);
    }

    public Film(){

    }

    public Collection<Category> getCategory() {
        return category;
    }

    public void setCategory(Collection<Category> category) {
        this.category = category;
    }
    public void setCategory(Category category) {
        if(this.category==null){
            Collection<Category> emptycategory = new ArrayList<Category>();
            this.category= emptycategory;
        }
        this.category.add(category);
    }

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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
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

    public int getRentalDuration() {
        return rentalDuration;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
