package clean.code.chess.requirements;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];

    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (IsLegalBoardPosition(xCoordinate,yCoordinate)==true) {
                pawn.setXCoordinate(xCoordinate);
                pawn.setYCoordinate(yCoordinate);
                pawn.setChessBoard(this);
              this.pieces[xCoordinate][yCoordinate] = pawn;
        }
       // throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        boolean status=true;
        if (xCoordinate>MAX_BOARD_WIDTH || xCoordinate<0 || yCoordinate>MAX_BOARD_HEIGHT || yCoordinate <0) {
            status=false;
           // throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
        }
        return status;
    }
}
