package chessboard.pieces;

import chessboard.Spot;
import chessboard.movement.SpotNeighbours;

import java.util.List;

/**
 * King can move only 1 step at a time in all 8 directions(vertical, horizontal and diagonal)
 */
public class King extends Piece implements SpotNeighbours {

    public List<Spot> getProbablePositions(Spot currentSpot) {
        return getImmediateNeighbours(currentSpot);
    }
}
