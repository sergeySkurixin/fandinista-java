package jbreathe.fandinista.dto;

import java.util.List;

/**
 * Музыкант. Или группа. Есть рейтинг, стена с постами, аудио. видео, etc.
 */
public class Musician {

    private Long id;
    private String name;
    private String password;
    private String passwordConfirmation;
    private Long rating;
    private List<Fan> followers;

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
