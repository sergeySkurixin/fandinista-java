package jbreathe.fandinista.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "performances")
public class PerformanceEntity {

    private Long id;
    private String name;
    private PlaceEntity location;
    private List<MusicianEntity> performers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name = "place_id")
    public PlaceEntity getLocation() {
        return location;
    }

    public void setLocation(PlaceEntity place) {
        this.location = place;
    }

    @OneToMany
    @JoinTable(name = "performance_musicians",
            joinColumns = @JoinColumn(name = "performance_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "musician_id", referencedColumnName = "id"))
    public List<MusicianEntity> getPerformers() {
        return performers;
    }

    public void setPerformers(List<MusicianEntity> performers) {
        this.performers = performers;
    }
}
