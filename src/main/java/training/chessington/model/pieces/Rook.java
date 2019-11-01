package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.Board.isOutOfBounds;
import static training.chessington.model.pieces.Direction.*;

public class Rook extends AbstractPiece {



    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour, false);
        availableDirections.add(NORTH);
        availableDirections.add(SOUTH);
        availableDirections.add(EAST);
        availableDirections.add(WEST);
    }

//    @Override
//    public List<Move> getAllowedMoves(Coordinates from, Board board) {
//        List<Move> allowedMoves = new ArrayList<>();
//        boolean moveOneSquare = false;
//        for (Direction direction : availableDirections) {
//            Coordinates proposedCoordinate = from;
//            while (!isOutOfBounds((proposedCoordinate) = proposedCoordinate.plus(direction.getDifference())) && !moveOneSquare) {
//                if (board.get(proposedCoordinate) != null && this.colour == board.get(proposedCoordinate).getColour()) {
//                    break;
//                }
//                if (board.get(proposedCoordinate) != null && this.colour != board.get(proposedCoordinate).getColour()) {
//                    allowedMoves.add(new Move(from, proposedCoordinate));
//                    break;
//                }
//                allowedMoves.add(new Move(from, proposedCoordinate));
//                moveOneSquare = this.limitedToOneSquareMove;
//            }
//        }
//        return allowedMoves;
//    }
}
