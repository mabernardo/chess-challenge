package chess.challenge.piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import chess.challenge.piece.bahaviour.UnlimitedThreat;

/**
 * Queen chess piece implementation.
 * 
 * @author mabernardo
 * @version 1.0
 * @since 1.0
 */
public class Queen extends ChessPiece implements UnlimitedThreat {

    private static final List<Point> validMoves;
    static {
        validMoves = new ArrayList<>();
        validMoves.add(new Point(-1, -1));
        validMoves.add(new Point(-1, 0));
        validMoves.add(new Point(-1, 1));
        validMoves.add(new Point(0, -1));
        validMoves.add(new Point(0, 1));
        validMoves.add(new Point(1, -1));
        validMoves.add(new Point(1, 0));
        validMoves.add(new Point(1, 1));
    }

    /**
     * Default constructor.
     */
    public Queen() {
        super(0, 0);
    }

    /**
     * Constructor defining initial position.
     * 
     * @param rank
     *            rank of the piece
     * @param file
     *            file of the piece
     */
    public Queen(int rank, int file) {
        super(rank, file);
    }

    /* (non-Javadoc)
     * @see chess.challenge.ChessPiece#getValidMoves()
     */
    @Override
    public List<Point> getValidMoves() {
        return validMoves;
    }

    /*
     * (non-Javadoc)
     * @see chess.challenge.ChessPiece#getSymbol()
     */
    @Override
    public PieceType getType() {
        return PieceType.QUEEN;
    }
}
