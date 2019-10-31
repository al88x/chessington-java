package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import javax.accessibility.AccessibleValue;
import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.PlayerColour.BLACK;
import static training.chessington.model.PlayerColour.WHITE;

public class Pawn extends AbstractPiece {

    private static final int W_MOVE_FWD = -1;
    private static final int B_MOVE_FWD = 1;
    private static final int W_MOVE_FWD_2 = -2;
    private static final int B_MOVE_FWD_2 = 2;

    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> availableMoves = new ArrayList<>();
        if (this.colour == WHITE) {
            if (from.getRow() == 6) {
                availableMoves.add(new Move(from, from.plus(W_MOVE_FWD_2, 0)));
            }
            availableMoves.add(new Move(from, from.plus(W_MOVE_FWD, 0)));
        }
        if (this.colour == BLACK) {
            if (from.getRow() == 1) {
                availableMoves.add(new Move(from, from.plus(B_MOVE_FWD_2, 0)));
            }
            availableMoves.add(new Move(from, from.plus(B_MOVE_FWD, 0)));
        }
        return availableMoves;
    }
}
