package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.Board.isWithinBoardLimits;


public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;
    protected List<Direction> availableDirections;
    protected final boolean limitedToOneSquareMove;

    protected AbstractPiece(Piece.PieceType type, PlayerColour colour, boolean limitedToOneSquareMove) {
        this.type = type;
        this.colour = colour;
        availableDirections = new ArrayList<>();
        this.limitedToOneSquareMove = limitedToOneSquareMove;
    }

    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();
        boolean moveOneSquare;
        for (Direction direction : availableDirections) {
            Coordinates proposedCoordinate = from;
            moveOneSquare = false;
            while (isWithinBoardLimits((proposedCoordinate) = proposedCoordinate.plus(direction.getDifference())) && !moveOneSquare) {
                if (board.get(proposedCoordinate) != null && this.colour == board.get(proposedCoordinate).getColour()) {
                    break;
                }
                if (board.get(proposedCoordinate) != null && this.colour != board.get(proposedCoordinate).getColour()) {
                    allowedMoves.add(new Move(from, proposedCoordinate));
                    break;
                }
                allowedMoves.add(new Move(from, proposedCoordinate));
                moveOneSquare = this.limitedToOneSquareMove;
            }
        }
        return allowedMoves;
    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }
}
