package service.match.entity;

public enum Point {
    LOVE("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    AD("AD"),
    EMPTY(" ");
    private String point;
    Point(String point) {
        this.point = point;
    }
    public String getPoint() {
        return point;
    }
}
