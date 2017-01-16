package jbreathe.fandinista.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Jpa entity для места проведения концертов.
 */
@Entity
@Table(name = "PLACES")
public class PlaceEntity extends UserEntity {

    private Long rating;
    private List<FanEntity> followers;

    public PlaceEntity() {
    }

    public PlaceEntity(String name, String email, String passwordDigest, Long rating) {
        super(name, email, passwordDigest);
        this.rating = rating;
    }

    @Column(name = "RATING")
    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    @ManyToMany(mappedBy = "favoritePlaces")
    public List<FanEntity> getFollowers() {
        return followers;
    }

    public void setFollowers(List<FanEntity> followers) {
        this.followers = followers;
    }
}
