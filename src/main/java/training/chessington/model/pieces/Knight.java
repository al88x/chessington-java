package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static training.chessington.model.Board.isOutOfBounds;

public class Knight extends AbstractPiece {


    private Integer[][] possibleMoves;

    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour, true);
        possibleMoves = new Integer[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    }


    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        return Arrays.stream(possibleMoves)
                .filter(square -> !isOutOfBounds(from.plus(square)) && !hasPieceOfSameColour(board, from, square))
                .map(square -> new Move(from, from.plus(square)))
                .collect(Collectors.toList());
    }

    private boolean hasPieceOfSameColour(Board board, Coordinates from, Integer[] square) {
        if (board.get(from.plus(square)) == null) {
            return false;
        }
        return this.colour == board.get(from.plus(square)).getColour();
    }
}
