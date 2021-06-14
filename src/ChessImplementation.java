import chessboard.Board;
import chessboard.Spot;
import chessboard.pieces.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class ChessImplementation {
    public static void main(String[] args) {
        Board board = new Board();
        board.createChessBoard();

        Scanner sc = new Scanner(System.in);

        Piece piece;
        Spot spot;

        boolean inputOk = false;
        while (!inputOk) {
            System.out.println("Input: ");
            String input = sc.nextLine();
            try {
                String type = input.split(" ")[0];
                String cell = input.split(" ")[1];
                piece = Piece.getPieceType(type);
                spot = new Spot(cell.charAt(0), Character.getNumericValue(cell.charAt(1)));
                Piece.checkCellValidity(spot);
                inputOk = true;
                System.out.println("Output: "+piece.getProbablePositions(spot));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
