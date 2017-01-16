package jbreathe.fandinista.dto;

import java.util.List;

/**
 * Фанат. Фанат может фаловить музыкантов ({@link Musician}) и места проведения концертов ({@link Place}).
 */
public class Fan extends User {

    private List<Musician> favoriteMusicians;
    private List<Place> favoritePlaces;

    public Fan() {
    }

    public Fan(String name, String email, String password) {
        super(name, email, password);
    }

    public Fan(String name, String email, String password, String passwordConfirmation) {
        super(name, email, password, passwordConfirmation);
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
}
