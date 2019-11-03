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

public class KingTest {

    @Test
    public void whiteKingCanMoveForwardOnlyOneSquare() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-4, 0)));
    }

    @Test
    public void whiteKingCanMoveRightOnlyOneSquare() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 3)));
    }

    @Test
    public void whiteKingCanMoveLeftOnlyOneSquare() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, -3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, -4)));
    }

    @Test
    public void whiteKingCanMoveDownOnlyOneSquare() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 0)));
    }

    @Test
    public void whiteKingCanMoveNorthWestOnlyOneSquare() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-4, -4)));
    }

    @Test
    public void whiteKingCanMoveNorthEastOnlyOneSquare() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, 3)));
    }

    @Test
    public void whiteKingCanMoveSouthWestOnlyOneSquare() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, -3)));
    }

    @Test
    public void whiteKingCanMoveSouthEastOnlyOneSquare() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 3)));
    }

    @Test
    public void whiteKingCannotMoveForwardBecausePieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Piece rook = new Rook(WHITE);
        Coordinates kingCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(3, 4);
        board.placePiece(kingCoords, king);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = king.getAllowedMoves(kingCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(-1, 0)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(-2, 0)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(-3, 0)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(-4, 0)));
    }

    @Test
    public void whiteKingCannotMoveBackwardsBecausePieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Piece rook = new Rook(WHITE);
        Coordinates kingCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(5, 4);
        board.placePiece(kingCoords, king);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = king.getAllowedMoves(kingCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(1, 0)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(2, 0)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(3, 0)));


    }

    @Test
    public void whiteKingCannotMoveRightBecausePieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece King = new King(WHITE);
        Piece rook = new Rook(WHITE);
        Coordinates kingCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(4, 5);
        board.placePiece(kingCoords, King);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = King.getAllowedMoves(kingCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(0, 1)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(0, 2)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(0, 3)));
    }

    @Test
    public void whiteKingCannotMoveLeftBecausePieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Piece rook = new Rook(WHITE);
        Coordinates kingCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(4, 3);
        board.placePiece(kingCoords, king);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = king.getAllowedMoves(kingCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(0, -1)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(0, -2)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(0, -3)));
    }

    @Test
    public void whiteKingCannotMoveNorthWestBecausePieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece King = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, King);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(3,3);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = King.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-4, -4)));
    }

    @Test
    public void whiteKingCannotMoveNorthEastBecausePieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece King = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, King);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(3,5);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = King.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, 3)));
    }

    @Test
    public void whiteKingCannotMoveSouthWestBecausePieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece King = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, King);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(5,3);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = King.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, -3)));
    }

    @Test
    public void whiteKingCannotMoveSouthEastBecausePieceOfSameColour() {

        // Arrange
        Board board = Board.empty();
        Piece King = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, King);
        Piece pawn = new Pawn(WHITE);
        Coordinates pawnCoords = new Coordinates(5,5);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = King.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 3)));
    }

    @Test
    public void whiteKingCanMoveForwardOneSquareOnEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Piece rook = new Rook(BLACK);
        Coordinates kingCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(3, 4);
        board.placePiece(kingCoords, king);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = king.getAllowedMoves(kingCoords, board);

        // Assert
        assertThat(moves).contains(new Move(kingCoords, kingCoords.plus(-1, 0)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(-2, 0)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(-3, 0)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(-4, 0)));
    }

    @Test
    public void whiteKingCanMoveBackwardsOneSquareOnEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Piece rook = new Rook(BLACK);
        Coordinates kingCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(5, 4);
        board.placePiece(kingCoords, king);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = king.getAllowedMoves(kingCoords, board);

        // Assert
        assertThat(moves).contains(new Move(kingCoords, kingCoords.plus(1, 0)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(2, 0)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(3, 0)));
    }

    @Test
    public void whiteKingCanMoveRightOneSquareOnEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Piece rook = new Rook(BLACK);
        Coordinates kingCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(4, 5);
        board.placePiece(kingCoords, king);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = king.getAllowedMoves(kingCoords, board);

        // Assert
        assertThat(moves).contains(new Move(kingCoords, kingCoords.plus(0, 1)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(0, 2)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(0, 3)));
    }

    @Test
    public void whiteKingCanMoveLeftOneSquareOnEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Piece rook = new Rook(BLACK);
        Coordinates kingCoords = new Coordinates(4, 4);
        Coordinates rookCoords = new Coordinates(4, 3);
        board.placePiece(kingCoords, king);
        board.placePiece(rookCoords, rook);

        // Act
        List<Move> moves = king.getAllowedMoves(kingCoords, board);

        // Assert
        assertThat(moves).contains(new Move(kingCoords, kingCoords.plus(0, -1)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(0, -2)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(0, -3)));
        assertThat(moves).doesNotContain(new Move(kingCoords, kingCoords.plus(0, -4)));

    }



    @Test
    public void whiteKingCanMoveNorthWestOneSquareOnEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece king = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(3,3);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-4, -4)));
    }

    @Test
    public void whiteKingCanMoveNorthEastOneSquareOnEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece King = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, King);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(3,5);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = King.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, 3)));
    }

    @Test
    public void whiteKingCanMoveSouthWestOneSquareOnEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece King = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, King);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(5,3);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = King.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, -3)));
    }

    @Test
    public void whiteKingCanMoveSouthEastOneSquareOnEnemyPiece() {

        // Arrange
        Board board = Board.empty();
        Piece King = new King(WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, King);
        Piece pawn = new Pawn(BLACK);
        Coordinates pawnCoords = new Coordinates(5,5);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = King.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 3)));
    }

    @Test
    public void whiteKingIsCheckByBlackQueen() {

        // Arrange
        Board board = Board.empty();
        King blackKing = new King(BLACK);
        board.placePiece(new Coordinates(1,1), blackKing);
        King king = new King(WHITE);
        Coordinates coords = new Coordinates(7, 4);
        board.placePiece(coords, king);
        Piece queen = new Queen(BLACK);
        Coordinates queenCoords = new Coordinates(4, 5);
        board.placePiece(queenCoords, queen);
        board.move(queenCoords, new Coordinates(4,4));
        board.calculateAllPossibleMoves();

        // Act
        boolean check = king.isCheck();

        // Assert
        assertThat(check).isEqualTo(true);
    }


}
