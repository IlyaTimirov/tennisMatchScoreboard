package service.match.entity;

import java.util.Objects;

public class ScoreBoard {
    private int seth;
    private int game;
    private String point;

    public ScoreBoard(int seth, int game, String point) {
        this.seth = seth;
        this.game = game;
        this.point = point;
    }

    public ScoreBoard() {
    }

    public int getSeth() {
        return seth;
    }

    public void setSeth(int seth) {
        this.seth = seth;
    }

    public int getGame() {
        return game;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreBoard that = (ScoreBoard) o;
        return seth == that.seth && game == that.game && Objects.equals(point, that.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seth, game, point);
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "seth=" + seth +
                ", game=" + game +
                ", point='" + point + '\'' +
                '}';
    }
}
