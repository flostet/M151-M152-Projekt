package ch.bbzw.m151.crypto.dto;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Random;

public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String password;
    private final String email;

    public UserDto(final String name, final String password, final String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() { return email; }
}
