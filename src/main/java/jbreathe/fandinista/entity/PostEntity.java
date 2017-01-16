package jbreathe.fandinista.entity;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class PostEntity {

    private Long id;
    private String title;
    private String body; // основной текст поста
    private UserEntity user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "body", nullable = false)
    public String getBody() {
        return body;
    }

    public void setBody(String text) {
        this.body = text;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + body + '\'' +
                '}';
    }
}
