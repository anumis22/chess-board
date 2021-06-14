package chessboard.movement;

import chessboard.Spot;
import chessboard.pieces.Piece;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface SpotNeighbours {

    default List<Spot> getVerticalNeighbours(Spot currentSpot) {
        List<Spot> allowedSpots = new ArrayList<>();
        char rowInitial;
        for(int i=1; i<=8; i++) {
            rowInitial = Piece.getRowInitial(i);
            allowedSpots.add(new Spot(rowInitial, currentSpot.getColumn()));
        }
        allowedSpots.remove(currentSpot);
        return allowedSpots;
    }

    default List<Spot> getHorizontalNeighbours(Spot currentSpot) {
        List<Spot> allowedSpots = new ArrayList<>();

        for(int j=1; j<=8; j++) {
            allowedSpots.add(new Spot(currentSpot.getRowInitial(), j));
        }
        allowedSpots.remove(currentSpot);
        return allowedSpots;
    }

    default List<Spot> getImmediateNeighbours(Spot currentSpot) {
        int currentCol = currentSpot.getColumn();
        int currentRow = Piece.getRowNumber(currentSpot.getRowInitial());
        List<Spot> allowedSpots = new ArrayList<>();
        char rowInitial;

        for(int i=currentRow-1; i<=currentRow+1; i++) {
            if(i<1 || i>8)
                continue;
            for(int j=currentCol-1; j<=currentCol+1; j++) {
                if(j<1 || j>8)
                    continue;
                rowInitial = Piece.getRowInitial(i);
                allowedSpots.add(new Spot(rowInitial, j));
            }
        }
        allowedSpots.remove(currentSpot);
        return allowedSpots;
    }

    default List<Spot> getDiagonalNeighbours(Spot currentSpot) {
        int currentCol = currentSpot.getColumn();
        int currentRow = Piece.getRowNumber(currentSpot.getRowInitial());
        Set<Spot> allowedSpots = new HashSet<>();
        char rowInitial;

        for(int i=1; i<=8; i++) {
            if(i<1 || i>8)
                continue;
            for(int j=1; j<=8; j++) {
                if(j<1 || j>8)
                    continue;
                rowInitial = Piece.getRowInitial(i);

                // Principal Diagonal
                if(currentCol==currentRow){
                    if(i==j)
                        allowedSpots.add(new Spot(rowInitial, j));
                }

                //Secondary Diagonal
                if(currentCol+currentRow==9){
                    if(i+j==9)
                        allowedSpots.add(new Spot(rowInitial, j));
                }
            }
        }

        // Other diagonals
        char tempRow;
        for(int k=1;k<currentRow;k++) {
            if(currentRow-k > 0) {
                tempRow =  Piece.getRowInitial(currentRow-k);
                if(currentCol-k > 0)
                    allowedSpots.add(new Spot(tempRow, currentCol-k));
                if(currentCol+k <= 8)
                    allowedSpots.add(new Spot(tempRow, currentCol+k));
            }
        }
        for(int k=1;k<=8;k++) {
            if(currentRow+k <= 8) {
                tempRow =  Piece.getRowInitial(currentRow+k);
                if(currentCol-k > 0)
                    allowedSpots.add(new Spot(tempRow, currentCol-k));
                if(currentCol+k <= 8)
                    allowedSpots.add(new Spot(tempRow, currentCol+k));
            }
        }

        return new ArrayList<>(allowedSpots);
    }

    default List<Spot> getImmediateVerticalAndDiagonalNeighbours(Spot currentSpot) {
        int currentCol = currentSpot.getColumn();
        List<Spot> allowedSpots = new ArrayList<>();
        allowedSpots.addAll(getImmediateNeighbours(currentSpot));
        allowedSpots.remove(new Spot(currentSpot.getRowInitial(),currentCol-1));
        allowedSpots.remove(new Spot(currentSpot.getRowInitial(),currentCol+1));
        return allowedSpots;
    }

    default List<Spot> get2AndAHalfVerticalNeighbours(Spot currentSpot) {
        int currentCol = currentSpot.getColumn();
        int currentRow = Piece.getRowNumber(currentSpot.getRowInitial());
        List<Spot> allowedSpots = new ArrayList<>();
        char rowInitial;

        for(int i=currentRow-2; i<=currentRow+2; i=i+2) {
            if(i<1 || i>8)
                continue;
            for(int j=currentCol-1; j<=currentCol+1; j++) {
                if(j<1 || j>8)
                    continue;
                rowInitial = Piece.getRowInitial(i);
                if(rowInitial!=currentSpot.getRowInitial()) {
                    if (j < currentCol)
                        allowedSpots.add(new Spot(rowInitial, currentCol - 1));
                    if (j > currentCol)
                        allowedSpots.add(new Spot(rowInitial, currentCol + 1));
                }
            }
        }
        allowedSpots.remove(currentSpot);
        return allowedSpots;
    }

    default List<Spot> get2AndAHalfHorizontalNeighbours(Spot currentSpot) {
        int currentCol = currentSpot.getColumn();
        int currentRow = Piece.getRowNumber(currentSpot.getRowInitial());
        List<Spot> allowedSpots = new ArrayList<>();
        char rowInitial;

        for(int j=currentCol-2; j<=currentCol+2; j=j+2) {
            // Matrix range is from 1 to 8 only
            if(j<1 || j>8)
                continue;
            for(int i=currentRow-1; i<=currentRow+1; i++) {
                // Matrix range is from 1 to 8 only
                if(i<1 || i>8)
                    continue;
                rowInitial = Piece.getRowInitial(i);
                if(rowInitial!=currentSpot.getRowInitial()) {
                    if (j < currentCol)
                        allowedSpots.add(new Spot(rowInitial, j));
                    if (j > currentCol)
                        allowedSpots.add(new Spot(rowInitial, j));
                }
            }
        }
        allowedSpots.remove(currentSpot);
        return allowedSpots;
    }
}
