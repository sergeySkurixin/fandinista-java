package jbreathe.fandinista.dto;

import java.util.List;

/**
 * Фанат. Фанат может фаловить музыкантов ({@link Musician}) и места проведения концертов ({@link Stage}).
 */
public class Fan {

    private Long id;
    private String name;
    private String password;
    private String passwordConfirmation;
    private List<Musician> favoriteMusicians;
    private List<Stage> favoriteStages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public List<Musician> getFavoriteMusicians() {
        return favoriteMusicians;
    }

    public void setFavoriteMusicians(List<Musician> favoriteMusicians) {
        this.favoriteMusicians = favoriteMusicians;
    }

    public List<Stage> getFavoriteStages() {
        return favoriteStages;
    }

    public void setFavoriteStages(List<Stage> favoriteStages) {
        this.favoriteStages = favoriteStages;
    }
}
