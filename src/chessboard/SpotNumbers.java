package chessboard;

public enum SpotNumbers {
    H ('H', 1),
    G ('G', 2),
    F ('F', 3),
    E ('E', 4),
    D ('D', 5),
    C ('C', 6),
    B ('B', 7),
    A ('A', 8);


    private final char characterVar;
    private final int rowNum;

    SpotNumbers(char characterVar, int rowNum) {
        this.characterVar = characterVar;
        this.rowNum = rowNum;
    }

    public char getCharacterVar() {
        return characterVar;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getRowNumber(char c) {
        for (SpotNumbers sn : SpotNumbers.values()) {
            if (sn.getCharacterVar() == c) {
                return rowNum;
            }
        }
        throw new RuntimeException("Invalid Selection");
    }
}
