package jbreathe.fandinista.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Jpa entity музыканта/группы.
 */
@Entity
@Table(name = "musicians")
public class MusicianEntity extends UserEntity {

    private Long rating;
    private List<FanEntity> followers;

    public MusicianEntity() {
    }

    public MusicianEntity(String name, String email, String passwordDigest, Long rating) {
        super(name, email, passwordDigest);
        this.rating = rating;
    }

    @Column(name = "rating")
    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    @ManyToMany(mappedBy = "favoriteMusicians")
    public List<FanEntity> getFollowers() {
        return followers;
    }

    public void setFollowers(List<FanEntity> followers) {
        this.followers = followers;
    }
}
