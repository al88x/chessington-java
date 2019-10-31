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
    private static final int W_START_POS = 6;
    private static final int B_START_POS = 1;

    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> availableMoves = new ArrayList<>();
        if (hasSpaceToMove(from, board) && noPieceInFront(from, board)) {
            if (this.colour == WHITE) {
                if (from.getRow() == W_START_POS) {
                    availableMoves.add(new Move(from, from.plus(W_MOVE_FWD_2, 0)));
                }
                availableMoves.add(new Move(from, from.plus(W_MOVE_FWD, 0)));
            }
            if (this.colour == BLACK) {
                if (from.getRow() == B_START_POS) {
                    availableMoves.add(new Move(from, from.plus(B_MOVE_FWD_2, 0)));
                }
                availableMoves.add(new Move(from, from.plus(B_MOVE_FWD, 0)));
            }
        }
        return availableMoves;
    }

    private boolean hasSpaceToMove(Coordinates from, Board board) {
        if (this.colour == WHITE) {
            return from.getRow() > 0;
        }
        return from.getRow() < 7;
    }

    private boolean noPieceInFront(Coordinates from, Board board) {
        if (this.colour == WHITE) {
            return board.get(from.plus(W_MOVE_FWD, 0)) == null;
        }
        return board.get(from.plus(B_MOVE_FWD, 0)) == null;

    }
}
