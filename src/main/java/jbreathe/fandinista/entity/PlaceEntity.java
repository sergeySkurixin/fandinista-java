package jbreathe.fandinista.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Jpa entity для места проведения концертов.
 */
@Entity
@Table(name = "PLACES")
public class PlaceEntity {

    private Long id;
    private String name;
    private String email;
    private String passwordDigest;
    private String rememberToken;
    private Long rating;
    private List<FanEntity> followers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "EMAIL", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PASSWORD_DIGEST", nullable = false)
    public String getPasswordDigest() {
        return passwordDigest;
    }

    public void setPasswordDigest(String passwordDigest) {
        this.passwordDigest = passwordDigest;
    }

    @Column(name = "REMEMBER_TOKEN", nullable = false)
    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    @Column(name = "RATING")
    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    @ManyToMany(mappedBy = "favoriteStages")
    public List<FanEntity> getFollowers() {
        return followers;
    }

    public void setFollowers(List<FanEntity> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "PlaceEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
