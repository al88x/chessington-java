package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;

import java.util.List;

import static training.chessington.model.PlayerColour.BLACK;
import static training.chessington.model.PlayerColour.WHITE;
import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class RookTest {

    @Test
    public void whiteRookCanMoveForwardUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-4, 0)));
    }

    @Test
    public void whiteRookCanMoveRightUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 3)));
    }

    @Test
    public void whiteRookCanMoveLeftUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -4)));
    }

    @Test
    public void whiteRookCanMoveDownUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 0)));
    }

    @Test
    public void whiteRookCanMoveForwardUntilPieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(WHITE);
        Piece rook2 = new Rook(WHITE);
        Coordinates rookCoords = new Coordinates(4, 4);
        Coordinates rook2Coords = new Coordinates(1, 4);
        board.placePiece(rookCoords, rook);
        board.placePiece(rook2Coords, rook2);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(-1, 0)));
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(-2, 0)));
        assertThat(moves).doesNotContain(new Move(rookCoords, rookCoords.plus(-3, 0)));
        assertThat(moves).doesNotContain(new Move(rookCoords, rookCoords.plus(-4, 0)));
    }

    @Test
    public void whiteRookCanMoveBackwardsUntilPieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(WHITE);
        Piece rook2 = new Rook(WHITE);
        Coordinates rookCoords = new Coordinates(4, 4);
        Coordinates rook2Coords = new Coordinates(7, 4);
        board.placePiece(rookCoords, rook);
        board.placePiece(rook2Coords, rook2);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(1, 0)));
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(2, 0)));
        assertThat(moves).doesNotContain(new Move(rookCoords, rookCoords.plus(3, 0)));


    }

    @Test
    public void whiteRookCanMoveRightUntilPieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(WHITE);
        Piece rook2 = new Rook(WHITE);
        Coordinates rookCoords = new Coordinates(4, 4);
        Coordinates rook2Coords = new Coordinates(4, 7);
        board.placePiece(rookCoords, rook);
        board.placePiece(rook2Coords, rook2);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(0, 1)));
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(0, 2)));
        assertThat(moves).doesNotContain(new Move(rookCoords, rookCoords.plus(0, 3)));
    }

    @Test
    public void whiteRookCanMoveLeftUntilPieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(WHITE);
        Piece rook2 = new Rook(WHITE);
        Coordinates rookCoords = new Coordinates(4, 4);
        Coordinates rook2Coords = new Coordinates(4, 1);
        board.placePiece(rookCoords, rook);
        board.placePiece(rook2Coords, rook2);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(0, -1)));
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(0, -2)));
        assertThat(moves).doesNotContain(new Move(rookCoords, rookCoords.plus(0, -3)));
    }

    @Test
    public void whiteRookCanMoveForwardUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(WHITE);
        Piece rook2 = new Rook(BLACK);
        Coordinates rookCoords = new Coordinates(4, 4);
        Coordinates rook2Coords = new Coordinates(1, 4);
        board.placePiece(rookCoords, rook);
        board.placePiece(rook2Coords, rook2);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(-1, 0)));
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(-2, 0)));
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(-3, 0)));
        assertThat(moves).doesNotContain(new Move(rookCoords, rookCoords.plus(-4, 0)));
    }

    @Test
    public void whiteRookCanMoveBackwardsUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(WHITE);
        Piece rook2 = new Rook(BLACK);
        Coordinates rookCoords = new Coordinates(4, 4);
        Coordinates rook2Coords = new Coordinates(6, 4);
        board.placePiece(rookCoords, rook);
        board.placePiece(rook2Coords, rook2);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(1, 0)));
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(2, 0)));
        assertThat(moves).doesNotContain(new Move(rookCoords, rookCoords.plus(3, 0)));
    }

    @Test
    public void whiteRookCanMoveRightUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(WHITE);
        Piece rook2 = new Rook(BLACK);
        Coordinates rookCoords = new Coordinates(4, 4);
        Coordinates rook2Coords = new Coordinates(4, 6);
        board.placePiece(rookCoords, rook);
        board.placePiece(rook2Coords, rook2);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(0, 1)));
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(0, 2)));
        assertThat(moves).doesNotContain(new Move(rookCoords, rookCoords.plus(0, 3)));
    }

    @Test
    public void whiteRookCanMoveLeftUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(WHITE);
        Piece rook2 = new Rook(BLACK);
        Coordinates rookCoords = new Coordinates(4, 4);
        Coordinates rook2Coords = new Coordinates(4, 1);
        board.placePiece(rookCoords, rook);
        board.placePiece(rook2Coords, rook2);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(0, -1)));
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(0, -2)));
        assertThat(moves).contains(new Move(rookCoords, rookCoords.plus(0, -3)));
        assertThat(moves).doesNotContain(new Move(rookCoords, rookCoords.plus(0, -4)));

    }
}
