package chess.challenge;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * King chess piece implementation.
 * 
 * @author mabernardo
 * @version 1.0
 * @since 1.0
 */
public final class King extends ChessPiece {

    private static final boolean LIMITED_RANGE = true;

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
    public King() {
        super(0, 0, LIMITED_RANGE);
    }

    /**
     * Constructor defining initial position.
     * 
     * @param rank
     *            rank of the piece
     * @param file
     *            file of the piece
     */
    public King(int rank, int file) {
        super(rank, file, LIMITED_RANGE);
    }

    /*
     * (non-Javadoc)
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
        return PieceType.KING;
    }
}
