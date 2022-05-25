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
            if (this.pieces[xCoordinate][yCoordinate]==null){    //if the position is not occupied
                pawn.setXCoordinate(xCoordinate);
                pawn.setYCoordinate(yCoordinate);
                pawn.setChessBoard(this);
              this.pieces[xCoordinate][yCoordinate] = pawn;
            }
            else{   //if the position is occupied
                pawn.setXCoordinate(-1);
                pawn.setYCoordinate(-1);
            }
        }
        else{
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        boolean status=true;
        if (xCoordinate>=MAX_BOARD_WIDTH || xCoordinate<0 || yCoordinate>=MAX_BOARD_HEIGHT || yCoordinate <0) {
            status=false;
        }
        return status;
    }
}
