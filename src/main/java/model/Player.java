package model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
