package xyz.sadiulhakim.visitor;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false, unique = true)
    private String sub;

    @Column(length = 70, nullable = false, unique = true)
    private String email;

    @Column(length = 200)
    private String picture;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastVisited;

    public Visitor() {
    }

    public Visitor(long id, String name, String email, String picture, String sub, LocalDateTime lastVisited) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sub = sub;
        this.picture = picture;
        this.lastVisited = lastVisited;
    }

    public LocalDateTime getLastVisited() {
        return lastVisited;
    }

    public void setLastVisited(LocalDateTime lastVisited) {
        this.lastVisited = lastVisited;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sub='" + sub + '\'' +
                ", email='" + email + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
