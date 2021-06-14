package chessboard.pieces;

import chessboard.Spot;
import chessboard.movement.SpotNeighbours;

import java.util.List;

/**
 * Bishop can move in only diagonal direction.
 */
public class Bishop extends Piece implements SpotNeighbours {

    public List<Spot> getProbablePositions(Spot currentSpot){
        return getDiagonalNeighbours(currentSpot);
    }
}
