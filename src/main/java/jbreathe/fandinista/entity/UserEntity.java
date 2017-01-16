package jbreathe.fandinista.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Users.findAll",
                query = "select userEntity from UserEntity userEntity"),
        @NamedQuery(name = "Users.findByName",
                query = "select userEntity from UserEntity userEntity where userEntity.name = :name"),
        @NamedQuery(name = "Users.findByEmail",
                query = "select userEntity from UserEntity userEntity where userEntity.email = :email")
})
public class UserEntity {

    private Long id;
    private String name;
    protected String email;
    private String passwordDigest;

    public UserEntity() {
    }

    UserEntity(String name, String email, String passwordDigest) {
        this.name = name;
        this.email = email;
        this.passwordDigest = passwordDigest;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password_digest", nullable = false)
    public String getPasswordDigest() {
        return passwordDigest;
    }

    public void setPasswordDigest(String passwordDigest) {
        this.passwordDigest = passwordDigest;
    }
}
