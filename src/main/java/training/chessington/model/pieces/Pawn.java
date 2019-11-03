package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.Board.isWithinBoardLimits;
import static training.chessington.model.PlayerColour.BLACK;
import static training.chessington.model.PlayerColour.WHITE;

public class Pawn extends AbstractPiece {


    private static final int W_START_POS = 6;
    private static final int B_START_POS = 1;
    private Integer[][] possibleWalkingMoves;
    private Integer[][] possibleEnemyTakeOverMoves;


    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour, false);
        possibleWalkingMoves = new Integer[][]{movePawnForward(1), movePawnForward(2)};
        possibleEnemyTakeOverMoves = new Integer[][]{movePawnForwardLeft(), movePawnForwardRight()};
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> availableMoves = new ArrayList<>();
        Coordinates proposedSquareOneStepForward = from.plus(possibleWalkingMoves[0]);
        Coordinates proposedSquareTwoStepsForward = from.plus(possibleWalkingMoves[1]);

        if (isWithinBoardLimits(proposedSquareOneStepForward) && isSquareEmpty(proposedSquareOneStepForward, board)) {
            availableMoves.add(new Move(from, proposedSquareOneStepForward));

            if (isStartPosition(from, board.get(from)) && isSquareEmpty(proposedSquareTwoStepsForward, board)) {
                availableMoves.add(new Move(from, proposedSquareTwoStepsForward));
            }
        }
        for (Integer[] possibleMove : possibleEnemyTakeOverMoves) {

            Coordinates possibleMoveCoords = from.plus(possibleMove);
            if (isWithinBoardLimits(possibleMoveCoords) &&
                    (isSquareOccupiedByEnemy(possibleMoveCoords, board) || isEnPassantMovePossible(from, possibleMoveCoords, board))) {
                availableMoves.add((new Move(from, possibleMoveCoords)));
            }
        }
        return availableMoves;
    }

    private boolean isEnPassantMovePossible(Coordinates from, Coordinates possibleMoveCoords, Board board) {
        Piece neighbourPieceOnSameRow = board.get(new Coordinates(from.getRow(), possibleMoveCoords.getCol()));

        if (neighbourPieceOnSameRow != null &&
                neighbourPieceOnSameRow.getPreviousPosition() != null &&
                neighbourPieceOnSameRow.getType() == PieceType.PAWN &&
                isStartPosition(neighbourPieceOnSameRow.getPreviousPosition(), neighbourPieceOnSameRow)) {
            return true;
        }
        return false;
    }

    private boolean isSquareOccupiedByEnemy(Coordinates squareCoords, Board board) {
        if (board.get(squareCoords) == null) {
            return false;
        }
        return board.get(squareCoords).getColour() != this.colour;
    }

    private boolean isSquareEmpty(Coordinates squareCoords, Board board) {
        return board.get(squareCoords) == null;
    }

    private Integer[] movePawnForwardLeft() {
        if (this.colour == WHITE) {
            return new Integer[]{-1, -1};
        }
        return new Integer[]{1, 1};
    }


    private Integer[] movePawnForwardRight() {
        if (this.colour == WHITE) {
            return new Integer[]{-1, 1};
        }
        return new Integer[]{1, -1};
    }

    private Integer[] movePawnForward(int numberOfSquares) {
        if (this.colour == WHITE) {
            return new Integer[]{-numberOfSquares, 0};
        }
        return new Integer[]{numberOfSquares, 0};
    }

    private boolean isStartPosition(Coordinates from, Piece piece) {
        return from.getRow() == W_START_POS && piece.getColour() == WHITE ||
                from.getRow() == B_START_POS && piece.getColour() == BLACK;
    }
}
