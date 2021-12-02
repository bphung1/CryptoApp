package crypto.entity;

import java.util.Objects;

public class User {
    private int userid;
    private String username;
    private String password;
    private String email;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return userid == users.userid && Objects.equals(username, users.username) && Objects.equals(password, users.password)  && Objects.equals(email, users.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username, password, email);
    }
}
