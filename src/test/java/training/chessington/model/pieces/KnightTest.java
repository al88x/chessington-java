package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static training.chessington.model.PlayerColour.BLACK;
import static training.chessington.model.PlayerColour.WHITE;

public class KnightTest {

    @Test
    public void whiteKnightCanMoveTwoUpOneRight() {

        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 1)));
    }

    @Test
    public void whiteKnightCanMoveOneUpTwoRight() {

        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 2)));
    }

    @Test
    public void whiteKnightCanMoveTwoUpOneLeft() {

        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -1)));
    }

    @Test
    public void whiteKnightCanMoveOneUpTwoLeft() {

        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -2)));
    }

    @Test
    public void whiteKnightCanMoveOneDownTwoRight() {

        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 2)));
    }

    @Test
    public void whiteKnightCanMoveOneDownTwoLeft() {

        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -2)));
    }

    @Test
    public void whiteKnightCanMoveTwoDownOneRight() {

        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(2, 1)));
    }

    @Test
    public void whiteKnightCanMoveTwoDownOneLeft() {

        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(2, -1)));
    }

    @Test
    public void whiteKnightNotMovingOutOfTheBoard() {

        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(WHITE);
        Coordinates coords = new Coordinates(7, 1);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves.size()).isEqualTo(3);
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 2)));
    }

    @Test
    public void whiteKnightCannotMoveOnePieceWithSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(WHITE);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(5,0);
        Coordinates coords = new Coordinates(7, 1);
        board.placePiece(coords, knight);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves.size()).isEqualTo(2);
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 2)));
    }

    @Test
    public void whiteKnightCanMoveOnTopOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(WHITE);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(5,0);
        Coordinates coords = new Coordinates(7, 1);
        board.placePiece(coords, knight);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves.size()).isEqualTo(3);
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 2)));
    }

}
