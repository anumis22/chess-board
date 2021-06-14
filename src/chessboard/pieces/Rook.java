package chessboard.pieces;

import chessboard.Spot;
import chessboard.movement.SpotNeighbours;

import java.util.ArrayList;
import java.util.List;

/**
 * Rook can move in vertical and horizontal directions only.
 */
public class Rook extends Piece implements SpotNeighbours {

    public List<Spot> getProbablePositions(Spot currentSpot){
        List<Spot> allowedSpots = new ArrayList<>();
        allowedSpots.addAll(getVerticalNeighbours(currentSpot));
        allowedSpots.addAll(getHorizontalNeighbours(currentSpot));
        return allowedSpots;
    }
}
