package jbreathe.fandinista.dto;

import java.util.List;

/**
 * Музыкант. Или группа. Есть рейтинг, стена с постами, аудио. видео, etc.
 */
public class Musician extends User {

    private Long rating;
    private List<Fan> followers;

    public Musician() {
    }

    public Musician(String name, String email, String password) {
        super(name, email, password);
    }

    public Musician(String name, String email, String password, String passwordConfirmation) {
        super(name, email, password, passwordConfirmation);
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public List<Fan> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Fan> followers) {
        this.followers = followers;
    }
}
