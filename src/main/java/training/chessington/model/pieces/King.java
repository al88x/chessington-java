package training.chessington.model.pieces;

import training.chessington.model.PlayerColour;


public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour, true);
        availableDirections.add(Direction.NORTH_WEST);
        availableDirections.add(Direction.NORTH);
        availableDirections.add(Direction.WEST);
        availableDirections.add(Direction.SOUTH_WEST);
        availableDirections.add(Direction.SOUTH);
        availableDirections.add(Direction.SOUTH_EAST);
        availableDirections.add(Direction.EAST);
        availableDirections.add(Direction.NORTH_EAST);
    }
}
