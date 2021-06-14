package chessboard.pieces;

import chessboard.Spot;
import chessboard.movement.SpotNeighbours;

import java.util.List;

/**
 * Pawn can move only 1 step at a time in forward direction vertically.
 * It can also move diagonally to eliminate an opponent.
 */
public class Pawn extends Piece implements SpotNeighbours {

    public List<Spot> getProbablePositions(Spot currentSpot){
        return getImmediateVerticalAndDiagonalNeighbours(currentSpot);
    }
}
