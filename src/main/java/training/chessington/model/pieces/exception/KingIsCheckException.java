package training.chessington.model.pieces.exception;

public class KingIsCheckException extends RuntimeException {
    public KingIsCheckException(String message) {
        super(message);
    }
}
