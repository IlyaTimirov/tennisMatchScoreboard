package model;

import jakarta.persistence.*;

@Entity
@Table(name = "Matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Player1", nullable = false)
    private Player player1;
    @ManyToOne
    @JoinColumn(name = "Player2", nullable = false)
    private Player player2;
    @ManyToOne
    @JoinColumn(name = "Winner", nullable = false)
    private Player winner;

    public Match(Long id, Player player1, Player player2, Player winner) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }

    public Match(Player player1, Player player2, Player winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }

    public Match() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", winner=" + winner +
                '}';
    }
}
