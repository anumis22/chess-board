package chessboard;

import java.util.Objects;

public class Spot {
    private char rowInitial;
    private int column;

    public Spot(char rowInitial, int column) {
        this.rowInitial = rowInitial;
        this.column = column;
    }

    public char getRowInitial() {
        return rowInitial;
    }

    public int getColumn() {
        return column;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Spot spot = (Spot) o;
        return rowInitial == spot.rowInitial && column == spot.column;
    }

    @Override public int hashCode() {
        return Objects.hash(rowInitial, column);
    }

    @Override public String toString() {
        return new String("")+rowInitial + column;
    }
}
