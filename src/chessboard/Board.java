package chessboard;

import chessboard.pieces.Piece;

public class Board {

    public void createChessBoard(){
        Spot[][] chessBoard = new Spot[8][8];
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                Spot spot = new Spot(getInitial(i+1),j+1);
                chessBoard[i][j] = spot;
            }
        }
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                System.out.print(chessBoard[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public char getInitial (int rowNumber) {
        switch (rowNumber) {
            case 1: return 'H';
            case 2: return 'G';
            case 3: return 'F';
            case 4: return 'E';
            case 5: return 'D';
            case 6: return 'C';
            case 7: return 'B';
            case 8: return 'A';
            default: throw new RuntimeException("Invalid entry");
        }
    }
}
