package xyz.sadiulhakim.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import xyz.sadiulhakim.role.Role;
import xyz.sadiulhakim.team.Team;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "application_user")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Size(min = 2, max = 60)
    @Column(length = 60, nullable = false)
    private String name;

    @NotBlank
    @Email
    @Size(min = 2, max = 60)
    @Column(length = 60, nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$", message = "Password must be at least 8 characters long and include: \" +\r\n"
            + "              \"1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character (@$!%*?&).")
    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100)
    private String picture;

    @NotNull
    @ManyToOne
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @JsonIgnore
    @ManyToMany(mappedBy = "members")
    Set<Team> teams;

    public User() {
    }

    public User(long id, String fullName, String email, String password, String photo, Role role,
                LocalDateTime createdAt) {
        this.id = id;
        this.name = fullName;
        this.email = email;
        this.password = password;
        this.picture = photo;
        this.role = role;
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String fullName) {
        this.name = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String photo) {
        this.picture = photo;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) && Objects.equals(picture, user.picture) &&
                Objects.equals(role, user.role) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, picture, role, createdAt);
    }
}
