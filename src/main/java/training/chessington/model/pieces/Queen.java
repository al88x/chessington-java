package training.chessington.model.pieces;

import training.chessington.model.PlayerColour;

public class Queen extends AbstractPiece {
    public Queen(PlayerColour colour) {
        super(PieceType.QUEEN, colour, false);
        availableDirections.add(Direction.NORTH);
        availableDirections.add(Direction.NORTH_WEST);
        availableDirections.add(Direction.WEST);
        availableDirections.add(Direction.SOUTH_WEST);
        availableDirections.add(Direction.SOUTH);
        availableDirections.add(Direction.SOUTH_EAST);
        availableDirections.add(Direction.EAST);
        availableDirections.add(Direction.NORTH_EAST);
    }

}
