package chessboard.pieces;

import chessboard.Spot;
import chessboard.movement.SpotNeighbours;

import java.util.ArrayList;
import java.util.List;

/**
 * Queen can move in vertical, horizontal and diagonal directions
 */
public class Queen extends Piece implements SpotNeighbours {

    public List<Spot> getProbablePositions(Spot currentSpot){
        List<Spot> allowedSpots = new ArrayList<>();
        allowedSpots.addAll(getVerticalNeighbours(currentSpot));
        allowedSpots.addAll(getHorizontalNeighbours(currentSpot));
        allowedSpots.addAll(getDiagonalNeighbours(currentSpot));
        return allowedSpots;
    }
}
