package chessboard.pieces;

import chessboard.Board;
import chessboard.Spot;
import chessboard.SpotNumbers;

import java.util.List;

public abstract class Piece {

    public abstract List<Spot> getProbablePositions(Spot currentSpot);

    public static Piece getPieceType(String type){
        switch (type) {
            case "King": return new King();
            case "Queen": return new Queen();
            case "Bishop": return new Bishop();
            case "Horse": return new Horse();
            case "Rook": return new Rook();
            case "Pawn": return new Pawn();
            default: throw new RuntimeException("Invalid type selection. Please select a valid type.");
        }
    }

    public static int getRowNumber(char c) {
        for (SpotNumbers sn : SpotNumbers.values()) {
            if (sn.name().equals(Character.toString(c))) {
                return sn.getRowNumber(c);
            }
        }
        throw new RuntimeException("Invalid row initial. Please select a cell from above matrix.");
    }

    public static char getRowInitial(int rowNum) {
        for (SpotNumbers sn : SpotNumbers.values()) {
            if(sn.getRowNum() == rowNum)
                return sn.getCharacterVar();
        }
        throw new RuntimeException("Selected row doesn't exist.");
    }

    public static void checkCellValidity(Spot spot) {
        if(spot.getColumn() >8 || spot.getColumn()< 1 || spot.getRowInitial() > 'H' || spot.getRowInitial() < 'A')
            throw new RuntimeException("Invalid cell selected. Re-try with a cell from above matrix.");
    }
}
