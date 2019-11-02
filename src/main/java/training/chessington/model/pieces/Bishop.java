package training.chessington.model.pieces;

import training.chessington.model.PlayerColour;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour, false);
        availableDirections.add(Direction.NORTH_WEST);
        availableDirections.add(Direction.SOUTH_WEST);
        availableDirections.add(Direction.SOUTH_EAST);
        availableDirections.add(Direction.NORTH_EAST);
    }
}
