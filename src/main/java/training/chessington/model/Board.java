package training.chessington.model;

import training.chessington.model.pieces.*;
import training.chessington.model.pieces.exception.KingIsCheckException;


import java.util.List;

import static training.chessington.model.PlayerColour.WHITE;
import static training.chessington.model.pieces.Piece.PieceType.KING;
import static training.chessington.model.pieces.Piece.PieceType.PAWN;

public class Board {

    private BoardSquare[][] board = new BoardSquare[8][8];

    private Board() {
    }

    public static Board forNewGame() {
        Board board = new Board();
        board.setBackRow(0, PlayerColour.BLACK);
        board.setBackRow(7, WHITE);

        for (int col = 0; col < 8; col++) {
            board.board[1][col] = new BoardSquare(new Pawn(PlayerColour.BLACK));
            board.board[6][col] = new BoardSquare(new Pawn(WHITE));
        }

        return board;
    }

    public static Board empty() {
        return new Board();
    }

    private void setBackRow(int rowIndex, PlayerColour colour) {
        board[rowIndex][0] = new BoardSquare(new Rook(colour));
        board[rowIndex][1] = new BoardSquare(new Knight(colour));
        board[rowIndex][2] = new BoardSquare(new Bishop(colour));
        board[rowIndex][3] = new BoardSquare(new Queen(colour));
        board[rowIndex][4] = new BoardSquare(new King(colour));
        board[rowIndex][5] = new BoardSquare(new Bishop(colour));
        board[rowIndex][6] = new BoardSquare(new Knight(colour));
        board[rowIndex][7] = new BoardSquare(new Rook(colour));
    }

    public static boolean isWithinBoardLimits(Coordinates proposedCoords) {
        return proposedCoords.getRow() >= 0 && proposedCoords.getRow() <= 7 &&
                proposedCoords.getCol() >= 0 && proposedCoords.getCol() <= 7;
    }

    public Piece get(Coordinates coords) {
        if (board[coords.getRow()][coords.getCol()] == null) {
            return null;
        }
        return board[coords.getRow()][coords.getCol()].getPiece();
    }

    public void move(Coordinates from, Coordinates to) {
        Piece selectedPiece = this.get(from);
        if (selectedPiece.getType() == PAWN && isEnpassantMove(from, to)) {
            board[from.getRow()][to.getCol()] = null;
        }
        board[to.getRow()][to.getCol()] = board[from.getRow()][from.getCol()];
        board[from.getRow()][from.getCol()] = null;
        selectedPiece.setPreviousPosition(from);
    }

    private boolean isEnpassantMove(Coordinates from, Coordinates to) {
        if (from.getCol() != to.getCol() && this.get(to) == null) {
            return true;
        }
        return false;
    }

    public void placePiece(Coordinates coords, Piece piece) {
        if (board[coords.getRow()][coords.getCol()] == null) {
            board[coords.getRow()][coords.getCol()] = new BoardSquare(piece);
        }
        board[coords.getRow()][coords.getCol()].setPiece(piece);
    }

    public BoardSquare getBoardSquare(Coordinates coordinates) {
        return board[coordinates.getRow()][coordinates.getCol()];
    }

    public void calculateAllPossibleMoves() {
        Piece piece;
        Piece whiteKing = null;
        Piece blackKing = null;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] != null) {

                    board[row][col].clearPreviousListOfPossibleMoves();
                }
            }
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                if (board[row][col] == null) {
                    continue;
                }

                piece = board[row][col].getPiece();
                if (piece.getType() == KING) {
                    if (piece.getColour() == WHITE) {
                        whiteKing = piece;
                    } else {
                        blackKing = piece;
                    }
                }
                if (piece != null) {
                    List<Move> allowedMoves = piece.getAllowedMoves(new Coordinates(row, col), this);

                    for (Move move : allowedMoves) {
                        Coordinates to = move.getTo();
                        if (board[to.getRow()][to.getCol()] != null) {

                            board[to.getRow()][to.getCol()].addPossibleMoveToThisSquare(move, piece.getColour());
                        }
                    }
                }
            }
        }
        checkIfIsKingCheck(whiteKing, blackKing);
    }

    private void checkIfIsKingCheck(Piece whiteKing, Piece blackKing) {
        BoardSquare whiteKingSquare = this.getBoardSquare(whiteKing.getCurrentPosition());
        BoardSquare blackKingSquare = this.getBoardSquare(blackKing.getCurrentPosition());
        System.out.println(whiteKingSquare.getBlackPiecesAvailableMoves());
        if (whiteKingSquare.getBlackPiecesAvailableMoves().size() > 0) {
            King whiteKingIsCheck = (King) whiteKing;
            whiteKingIsCheck.setCheck(true);
//            throw new KingIsCheckException("White King is checked");
        }
        if (blackKingSquare.getWhitePiecesAvailableMoves().size() > 0) {
            King blackKingIsCheck = (King) blackKing;
            blackKingIsCheck.setCheck(true);
//            throw new KingIsCheckException("Black King is checked");
        }
    }
}
