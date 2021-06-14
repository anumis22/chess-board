package chessboard.pieces;

import chessboard.Spot;
import chessboard.movement.SpotNeighbours;

import java.util.List;

/**
 * Horse can move in 2.5 steps only(2 vertical and 1 horizontal)
 */
public class Horse extends Piece implements SpotNeighbours {

    public List<Spot> getProbablePositions(Spot currentSpot){
        List<Spot> allowedRows = get2AndAHalfHorizontalNeighbours(currentSpot);
        allowedRows.addAll(get2AndAHalfVerticalNeighbours(currentSpot));
        return allowedRows;
    }
}

