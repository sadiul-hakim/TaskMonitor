package xyz.sadiulhakim.project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import xyz.sadiulhakim.team.Team;

import java.util.Objects;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    private Team team;

    public Project() {
    }

    public Project(Integer id, String name, Team team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(name, project.name) && Objects.equals(team, project.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, team);
    }
}