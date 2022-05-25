package clean.code.chess.requirements;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void Move(MovementType movementType, int newX, int newY) {
        if (movementType==MovementType.MOVE){           //Check that movement type is MOVE
            if (this.chessBoard.IsLegalBoardPosition(newX,newY)){  //Check that the coordinates are correct
                if(this.pieceColor==PieceColor.BLACK) {    //Check the color
                    if (newX != this.getXCoordinate()) {  //The Pawn can't move left or right, nothings change
                        this.setYCoordinate(this.getYCoordinate());
                        this.setXCoordinate(this.getXCoordinate());
                    } else {
                        if (this.getXCoordinate()==6 && (newY==this.getYCoordinate()-2 || newY==this.getYCoordinate()-1)) { //If the Pawn is in the initial position, he can advance 2 or 1 squares
                            this.setYCoordinate(newY);
                        }
                        else if (newY==this.getYCoordinate()-1){  //If the Pawn isn't in the initial position, he can move only 1 square
                            this.setYCoordinate(newY);
                        }
                    }
                }
                else if (this.pieceColor==PieceColor.WHITE){
                    if (newX != this.getXCoordinate()) {  //The Pawn can't move left or right, nothings change
                        this.setYCoordinate(this.getYCoordinate());
                        this.setXCoordinate(this.getXCoordinate());
                    } else {
                        if (this.getXCoordinate()==1 && (newY==this.getYCoordinate()+2 || newY==this.getYCoordinate()+1)) { //If the Pawn is in the initial position, he can advance 2 or 1 squares
                            this.setYCoordinate(newY);
                        }
                        else if (newY==this.getYCoordinate()+1){  //If the Pawn isn't in the initial position, he can move only 1 square
                            this.setYCoordinate(newY);
                        }
                    }

                }
        }
        }
     //   throw new UnsupportedOperationException("Need to implement Pawn.Move()");
    }

    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
