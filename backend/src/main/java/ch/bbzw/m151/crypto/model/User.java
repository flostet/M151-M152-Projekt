package ch.bbzw.m151.crypto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cryptoUser")
@NamedQuery(name = "User.checkPassword", query = "SELECT u FROM User u WHERE u.email = :email and user_password = public.crypt(text(:user_password), text(user_password))")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(allocationSize = 1, name = "user_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String prename;

    @Column(nullable = false)
    private String surname;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    @ColumnTransformer(write = "crypt(?, gen_salt('bf', 8))")
    private String userPassword;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGroup userGroup;

    protected User() {
    }

    public User(final String email, final String userPassword, final UserGroup userGroup) {
        this.email = email;
        this.userPassword = userPassword;
        this.userGroup = userGroup;
    }

    public String getEmail() {
        return email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public String getPrename() { return prename; }

    public String getSurname() { return surname; }
}
