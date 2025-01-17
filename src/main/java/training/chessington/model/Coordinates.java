package training.chessington.model;

import java.util.Objects;

public final class Coordinates {
    private final int row;
    private final int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Coordinates(Integer[] coords){
        this.row = coords[0];
        this.col = coords[1];
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return row == that.row &&
                col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return String.format("row %d, column %d", row, col);
    }

    public Coordinates plus(int rowDiff, int colDiff) {
        return new Coordinates(row + rowDiff, col + colDiff);
    }

    public Coordinates plus(Integer[] diff) {
        return new Coordinates(row + diff[0], col + diff[1]);
    }

    public boolean isOutOfBounds() {
        return false;
    }
}
