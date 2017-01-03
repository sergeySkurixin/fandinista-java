package jbreathe.fandinista.dto;

import jbreathe.fandinista.validation.annotations.PasswordMatches;
import jbreathe.fandinista.validation.annotations.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Фанат. Фанат может фаловить музыкантов ({@link Musician}) и места проведения концертов ({@link Place}).
 */
@PasswordMatches
public class Fan {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String rememberToken;
    private List<Musician> favoriteMusicians;
    private List<Place> favoritePlaces;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @NotEmpty
    @ValidEmail
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    @NotEmpty
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    @NotEmpty
    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public List<Musician> getFavoriteMusicians() {
        return favoriteMusicians;
    }

    public void setFavoriteMusicians(List<Musician> favoriteMusicians) {
        this.favoriteMusicians = favoriteMusicians;
    }

    public List<Place> getFavoritePlaces() {
        return favoritePlaces;
    }

    public void setFavoritePlaces(List<Place> favoritePlaces) {
        this.favoritePlaces = favoritePlaces;
    }

    @Override
    public String toString() {
        return "Fan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
