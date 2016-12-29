package jbreathe.fandinista.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Jpa entity фаната.
 */
@Entity
@Table(name = "FANS")
public class FanEntity {

    private Long id;
    private String name;
    private String passwordDigest;
    private List<MusicianEntity> favoriteMusicians;
    private List<StageEntity> favoriteStages;

    @Id
    @GeneratedValue
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

    @Column(name = "PASSWORD_DIGEST", nullable = false)
    public String getPasswordDigest() {
        return passwordDigest;
    }

    public void setPasswordDigest(String passwordDigest) {
        this.passwordDigest = passwordDigest;
    }

    @ManyToMany
    @JoinTable(name = "FAN_MUSICIANS", joinColumns = @JoinColumn(name = "FAN_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "MUSICIAN_ID", referencedColumnName = "ID"))
    public List<MusicianEntity> getFavoriteMusicians() {
        return favoriteMusicians;
    }

    public void setFavoriteMusicians(List<MusicianEntity> favoriteMusicians) {
        this.favoriteMusicians = favoriteMusicians;
    }

    @ManyToMany
    @JoinTable(name = "FAN_STAGES", joinColumns = @JoinColumn(name = "FAN_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "STAGE_ID", referencedColumnName = "ID"))
    public List<StageEntity> getFavoriteStages() {
        return favoriteStages;
    }

    public void setFavoriteStages(List<StageEntity> favoriteStages) {
        this.favoriteStages = favoriteStages;
    }
}
