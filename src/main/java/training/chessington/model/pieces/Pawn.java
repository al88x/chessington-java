package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.PlayerColour.BLACK;
import static training.chessington.model.PlayerColour.WHITE;

public class Pawn extends AbstractPiece {


    private static final int W_START_POS = 6;
    private static final int B_START_POS = 1;
    private static final int SAME_COL = 0;



    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour, false);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> availableMoves = new ArrayList<>();

        if (hasSpaceToMove(1, from, board)) {
            if (isPresentEnemyPawnDiagonallyToRight(from, board)) {
                availableMoves.add(new Move(from, from.plus(movePawnForward(1), movePawnRight(1))));
            }
            if (isPresentEnemyPawnDiagonallyToLeft(from, board)) {
                availableMoves.add(new Move(from, from.plus(movePawnForward(1), movePawnLeft(1))));
            }
            if (noPieceInFront(from, board)) {
                availableMoves.add(new Move(from, from.plus(movePawnForward(1), SAME_COL)));
            }
            if (isStartPosition(from, board) && hasSpaceToMove(2, from, board)) {
                availableMoves.add(new Move(from, from.plus(movePawnForward(2), SAME_COL)));
            }
        }
        return availableMoves;
    }

    private int movePawnLeft(int squares) {
        if (this.colour == WHITE) {
            return -squares;
        }
        return squares;
    }

    private int movePawnRight(int squares) {
        if (this.colour == WHITE) {
            return squares;
        }
        return -squares;
    }


    private boolean isStartPosition(Coordinates from, Board board) {
        return from.getRow() == W_START_POS && this.colour == WHITE ||
                from.getRow() == B_START_POS && this.colour == BLACK;
    }

    private int movePawnForward(int i) {
        if (this.colour == WHITE) {
            return -i;
        }
        return i;
    }

    private boolean isPresentEnemyPawnDiagonallyToLeft(Coordinates from, Board board) {
        if (from.getCol() == 0 && this.colour == WHITE || from.getCol() == 7 && this.colour == BLACK) {
            return false;
        }
        Piece piece = board.get(from.plus(movePawnForward(1), movePawnLeft(1)));
        return piece != null && piece.getColour() != this.colour;
    }

    private boolean isPresentEnemyPawnDiagonallyToRight(Coordinates from, Board board) {
        if (from.getCol() == 7 && this.colour == WHITE || from.getCol() == 0 && this.colour == BLACK) {
            return false;
        }
        Piece piece = board.get(from.plus(movePawnForward(1), movePawnRight(1)));
        return piece != null && piece.getColour() != this.colour;
    }


    private boolean hasSpaceToMove(int squares, Coordinates from, Board board) {
        return from.getRow() > 0 && from.getRow() < 7 && board.get(from.plus(movePawnForward(1), SAME_COL)) == null;
    }

    private boolean noPieceInFront(Coordinates from, Board board) {
        return board.get(from.plus(movePawnForward(1), SAME_COL)) == null;
    }
}
