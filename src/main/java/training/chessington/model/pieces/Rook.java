package training.chessington.model.pieces;

import training.chessington.model.PlayerColour;
import static training.chessington.model.pieces.Direction.*;

public class Rook extends AbstractPiece {

    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour, false);
        availableDirections.add(NORTH);
        availableDirections.add(SOUTH);
        availableDirections.add(EAST);
        availableDirections.add(WEST);
    }
}
