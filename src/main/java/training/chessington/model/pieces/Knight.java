package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.Coordinates.isOutOfBounds;

public class Knight extends AbstractPiece {


    public Integer[][] possibleMoves;

    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
        possibleMoves = new Integer[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    }


    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();
        for (Integer[] square : this.possibleMoves) {
            if (isOutOfBounds(from, square) || hasPieceOfSameColour(board, from, square)) {
                continue;
            }
                allowedMoves.add(new Move(from, from.plus(square[0], square[1])));
        }
        return allowedMoves;
    }

    private boolean hasPieceOfSameColour(Board board, Coordinates from, Integer[] square) {
        if(board.get(from.plus(square[0],square[1])) == null){
            return false;
        }
        return this.colour == board.get(from.plus(square[0],square[1])).getColour();
    }
}
