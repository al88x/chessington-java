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

public class QueenTest {

    @Test
    public void whiteQueenCanMoveForwardUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-4, 0)));
    }

    @Test
    public void whiteQueenCanMoveRightUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 3)));
    }

    @Test
    public void whiteQueenCanMoveLeftUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -4)));
    }

    @Test
    public void whiteQueenCanMoveDownUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 0)));
    }

    @Test
    public void whiteQueenCanMoveForwardUntilPieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Piece rook = new Rook(WHITE);
        Coordinates queenCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(1, 4);
        board.placePiece(queenCoords, queen);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(-1, 0)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(-2, 0)));
        assertThat(moves).doesNotContain(new Move(queenCoords, queenCoords.plus(-3, 0)));
        assertThat(moves).doesNotContain(new Move(queenCoords, queenCoords.plus(-4, 0)));
    }

    @Test
    public void whiteQueenCanMoveBackwardsUntilPieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Piece rook = new Rook(WHITE);
        Coordinates queenCoords = new Coordinates(4, 4);
        Coordinates queen2Coords = new Coordinates(7, 4);
        board.placePiece(queenCoords, queen);
        board.placePiece(queen2Coords, rook);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(1, 0)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(2, 0)));
        assertThat(moves).doesNotContain(new Move(queenCoords, queenCoords.plus(3, 0)));


    }

    @Test
    public void whiteQueenCanMoveRightUntilPieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Piece rook = new Rook(WHITE);
        Coordinates queenCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(4, 7);
        board.placePiece(queenCoords, queen);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(0, 1)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(0, 2)));
        assertThat(moves).doesNotContain(new Move(queenCoords, queenCoords.plus(0, 3)));
    }

    @Test
    public void whiteQueenCanMoveLeftUntilPieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Piece rook = new Rook(WHITE);
        Coordinates queenCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(4, 1);
        board.placePiece(queenCoords, queen);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(0, -1)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(0, -2)));
        assertThat(moves).doesNotContain(new Move(queenCoords, queenCoords.plus(0, -3)));
    }

    @Test
    public void whiteQueenCanMoveForwardUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Piece rook = new Rook(BLACK);
        Coordinates queenCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(1, 4);
        board.placePiece(queenCoords, queen);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(-1, 0)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(-2, 0)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(-3, 0)));
        assertThat(moves).doesNotContain(new Move(queenCoords, queenCoords.plus(-4, 0)));
    }

    @Test
    public void whiteQueenCanMoveBackwardsUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Piece rook = new Rook(BLACK);
        Coordinates queenCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(6, 4);
        board.placePiece(queenCoords, queen);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(1, 0)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(2, 0)));
        assertThat(moves).doesNotContain(new Move(queenCoords, queenCoords.plus(3, 0)));
    }

    @Test
    public void whiteQueenCanMoveRightUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Piece rook = new Rook(BLACK);
        Coordinates QueenCoords = new Coordinates(4, 4);
        Coordinates Queen2Coords = new Coordinates(4, 6);
        board.placePiece(QueenCoords, queen);
        board.placePiece(Queen2Coords, rook);

        // Act
        List<Move> moves = queen.getAllowedMoves(QueenCoords, board);

        // Assert
        assertThat(moves).contains(new Move(QueenCoords, QueenCoords.plus(0, 1)));
        assertThat(moves).contains(new Move(QueenCoords, QueenCoords.plus(0, 2)));
        assertThat(moves).doesNotContain(new Move(QueenCoords, QueenCoords.plus(0, 3)));
    }

    @Test
    public void whiteQueenCanMoveLeftUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Piece rook = new Rook(BLACK);
        Coordinates queenCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(4, 1);
        board.placePiece(queenCoords, queen);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(0, -1)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(0, -2)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(0, -3)));
        assertThat(moves).doesNotContain(new Move(queenCoords, queenCoords.plus(0, -4)));

    }


    @Test
    public void whiteQueenCanMoveNorthWestUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-4, -4)));
    }

    @Test
    public void whiteQueenCanMoveNorthEastUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 3)));
    }

    @Test
    public void whiteQueenCanMoveSouthWestUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, -3)));
    }

    @Test
    public void whiteQueenCanMoveSouthEastUntilEndOfBoard() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 3)));
    }


    @Test
    public void whiteQueenCanMoveNorthWestUntilPieceOfSameColor() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(2,2);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-4, -4)));
    }

    @Test
    public void whiteQueenCanMoveNorthEastUntilPieceOfSameColor() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(2,6);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, 3)));
    }

    @Test
    public void whiteQueenCanMoveSouthWestUntilPieceOfSameColor() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(6,2);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, -3)));
    }

    @Test
    public void whiteQueenCanMoveSouthEastUntilPieceOfSameColor() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(6,6);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 3)));
    }


    @Test
    public void whiteQueenCanMoveNorthWestUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(2,2);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-4, -4)));
    }

    @Test
    public void whiteQueenCanMoveNorthEastUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(2,6);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, 3)));
    }

    @Test
    public void whiteQueenCanMoveSouthWestUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(6,2);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, -3)));
    }

    @Test
    public void whiteQueenCanMoveSouthEastUntilOnCoordinatesOfEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, queen);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(6,6);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 3)));
    }

}
