package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour, false);
        availableDirections.add(Direction.NORTH_WEST);
        availableDirections.add(Direction.SOUTH_WEST);
        availableDirections.add(Direction.SOUTH_EAST);
        availableDirections.add(Direction.NORTH_EAST);
    }
}
