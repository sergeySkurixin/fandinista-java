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
    private String avatar;

    public UserEntity() {
    }

    UserEntity(String name, String email, String passwordDigest) {
        this.name = name;
        this.email = email;
        this.passwordDigest = passwordDigest;
    }

    public UserEntity(String name, String email, String passwordDigest, String avatar) {
        this.name = name;
        this.email = email;
        this.passwordDigest = passwordDigest;
        this.avatar = avatar;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (passwordDigest != null ? !passwordDigest.equals(that.passwordDigest) : that.passwordDigest != null)
            return false;
        return avatar != null ? avatar.equals(that.avatar) : that.avatar == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (passwordDigest != null ? passwordDigest.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
