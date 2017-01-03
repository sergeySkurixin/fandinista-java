package jbreathe.fandinista.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Jpa entity фаната.
 */
@Entity
@Table(name = "FANS")
@NamedQueries({
        @NamedQuery(name = "Fans.findAll",
                query = "select fanEntity from FanEntity fanEntity"),
        @NamedQuery(name = "Fans.findByEmail",
                query = "select fanEntity from FanEntity fanEntity where fanEntity.email = :email")
})
public class FanEntity {

    private Long id;
    private String name;
    private String email;
    private String passwordDigest;
    private String rememberToken;
    private List<MusicianEntity> favoriteMusicians;
    private List<PlaceEntity> favoriteStages;

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

    @ManyToMany
    @JoinTable(name = "FAVORITE_MUSICIANS", joinColumns = @JoinColumn(name = "FAN_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "MUSICIAN_ID", referencedColumnName = "ID"))
    public List<MusicianEntity> getFavoriteMusicians() {
        return favoriteMusicians;
    }

    public void setFavoriteMusicians(List<MusicianEntity> favoriteMusicians) {
        this.favoriteMusicians = favoriteMusicians;
    }

    @ManyToMany
    @JoinTable(name = "FAVORITE_PLACES", joinColumns = @JoinColumn(name = "FAN_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PLACE_ID", referencedColumnName = "ID"))
    public List<PlaceEntity> getFavoriteStages() {
        return favoriteStages;
    }

    public void setFavoriteStages(List<PlaceEntity> favoriteStages) {
        this.favoriteStages = favoriteStages;
    }

    @Override
    public String toString() {
        return "FanEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
