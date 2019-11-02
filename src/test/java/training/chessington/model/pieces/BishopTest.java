package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;

import java.util.List;

import static training.chessington.model.PlayerColour.BLACK;
import static training.chessington.model.PlayerColour.WHITE;
import static org.assertj.core.api.Assertions.*;

public class BishopTest {

    @Test
    public void whiteBishopCanMoveNorthWestUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-4, -4)));
    }

    @Test
    public void whiteBishopCanMoveNorthEastUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 3)));
    }

    @Test
    public void whiteBishopCanMoveSouthWestUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, -3)));
    }

    @Test
    public void whiteBishopCanMoveSouthEastUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 3)));
    }


    @Test
    public void whiteBishopCanMoveNorthWestUntilPieceOfSameColor() {

        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(2,2);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-4, -4)));
    }

    @Test
    public void whiteBishopCanMoveNorthEastUntilPieceOfSameColor() {

        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(2,6);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, 3)));
    }

    @Test
    public void whiteBishopCanMoveSouthWestUntilPieceOfSameColor() {

        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(6,2);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, -3)));
    }

    @Test
    public void whiteBishopCanMoveSouthEastUntilPieceOfSameColor() {

        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(6,6);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 3)));
    }


    @Test
    public void whiteBishopCanMoveNorthWestUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(2,2);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-4, -4)));
    }

    @Test
    public void whiteBishopCanMoveNorthEastUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(2,6);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, 3)));
    }

    @Test
    public void whiteBishopCanMoveSouthWestUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(6,2);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, -3)));
    }

    @Test
    public void whiteBishopCanMoveSouthEastUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(6,6);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 3)));
    }

}
