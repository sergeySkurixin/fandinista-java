package jbreathe.fandinista.dto;

import java.util.List;

/**
 * Место для проведения тусовок. Есть рейтинг, стена с постами... что-то еще?
 */
public class Place extends User {

    private Long rating;
    private List<Fan> followers;

    public Place() {
    }

    public Place(String name, String email, String password) {
        super(name, email, password);
    }

    public Place(String name, String email, String password, String passwordConfirmation) {
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
