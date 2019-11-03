package training.chessington.model;

import training.chessington.model.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.PlayerColour.WHITE;

public class BoardSquare {

    private Piece piece;
    private List<Move> blackPiecesAvailableMoves;
    private List<Move> whitePiecesAvailableMoves;

    public BoardSquare(Piece piece) {
        this.piece = piece;
        blackPiecesAvailableMoves = new ArrayList<>();
        whitePiecesAvailableMoves = new ArrayList<>();
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        if (blackPiecesAvailableMoves == null) {
            blackPiecesAvailableMoves = new ArrayList<>();
        }
        if (whitePiecesAvailableMoves == null) {
            whitePiecesAvailableMoves = new ArrayList<>();
        }
    }

    public void addPossibleMoveToThisSquare(Move move, PlayerColour colour) {
        if(colour == WHITE){
            whitePiecesAvailableMoves.add(move);
        }else {
            blackPiecesAvailableMoves.add(move);
        }

    }

    public void clearPreviousListOfPossibleMoves() {
        whitePiecesAvailableMoves.clear();
        blackPiecesAvailableMoves.clear();
    }

    public List<Move> getBlackPiecesAvailableMoves() {
        return blackPiecesAvailableMoves;
    }

    public List<Move> getWhitePiecesAvailableMoves() {
        return whitePiecesAvailableMoves;
    }
}
