package service.match.entity;

import model.Player;

import java.util.Objects;

public class CurrentMatch {
    private Player player1;
    private Player player2;
    private ScoreBoard scorePlayer1;
    private ScoreBoard scorePlayer2;
    private int winner;

    public CurrentMatch(Player player1, Player player2, ScoreBoard scorePlayer1, ScoreBoard scorePlayer2, int winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
        this.winner = winner;
    }

    public CurrentMatch() {
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

    public ScoreBoard getScorePlayer1() {
        return scorePlayer1;
    }

    public void setScorePlayer1(ScoreBoard scorePlayer1) {
        this.scorePlayer1 = scorePlayer1;
    }

    public ScoreBoard getScorePlayer2() {
        return scorePlayer2;
    }

    public void setScorePlayer2(ScoreBoard scorePlayer2) {
        this.scorePlayer2 = scorePlayer2;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentMatch currentMatch = (CurrentMatch) o;
        return winner == currentMatch.winner && player1.equals(currentMatch.player1) && player2.equals(currentMatch.player2) && scorePlayer1.equals(currentMatch.scorePlayer1) && scorePlayer2.equals(currentMatch.scorePlayer2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player1, player2, scorePlayer1, scorePlayer2, winner);
    }

    @Override
    public String toString() {
        return "MatchDTO{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                ", scorePlayer1=" + scorePlayer1 +
                ", scorePlayer2=" + scorePlayer2 +
                ", winner=" + winner +
                '}';
    }
}
