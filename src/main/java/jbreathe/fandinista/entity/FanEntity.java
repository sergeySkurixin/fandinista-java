package jbreathe.fandinista.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Jpa entity фаната.
 */
@Entity
@Table(name = "fans")
@NamedQueries({
        @NamedQuery(name = "Fans.findAll",
                query = "select fanEntity from FanEntity fanEntity"),
        @NamedQuery(name = "Fans.findByEmail",
                query = "select fanEntity from FanEntity fanEntity where fanEntity.email = :email")
})
public class FanEntity extends UserEntity {

    private List<MusicianEntity> favoriteMusicians;
    private List<PlaceEntity> favoritePlaces;

    public FanEntity() {
    }

    public FanEntity(String name, String email, String passwordDigest) {
        super(name, email, passwordDigest);
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "favorite_musicians",
            joinColumns = @JoinColumn(name = "fan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "musician_id", referencedColumnName = "id"))
    public List<MusicianEntity> getFavoriteMusicians() {
        return favoriteMusicians;
    }

    public void setFavoriteMusicians(List<MusicianEntity> favoriteMusicians) {
        this.favoriteMusicians = favoriteMusicians;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "favorite_places",
            joinColumns = @JoinColumn(name = "fan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "place_id", referencedColumnName = "id"))
    public List<PlaceEntity> getFavoritePlaces() {
        return favoritePlaces;
    }

    public void setFavoritePlaces(List<PlaceEntity> favoriteStages) {
        this.favoritePlaces = favoriteStages;
    }
}
