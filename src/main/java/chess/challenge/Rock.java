package chess.challenge;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Rock chess piece implementation.
 * 
 * @author mabernardo
 * @version 1.0
 * @since 1.0
 */
public class Rock extends ChessPiece {

    public static final String SYMBOL = "R";
    private static final boolean LIMITED_RANGE = false;

    private static final List<Point> validMoves;
    static {
        validMoves = new ArrayList<>();
        validMoves.add(new Point(-1, 0));
        validMoves.add(new Point(0, 1));
        validMoves.add(new Point(1, 0));
        validMoves.add(new Point(0, -1));
    }

    /**
     * Default constructor.
     */
    public Rock() {
        super(0, 0, LIMITED_RANGE);
    }

    /** 
     * Constructor defining the initial position.
     * @param rank
     *            rank of the piece
     * @param file
     *            file of the piece
     */
    public Rock(int rank, int file) {
        super(rank, file, LIMITED_RANGE);
    }

    /* (non-Javadoc)
     * @see chess.challenge.ChessPiece#getValidMoves()
     */
    @Override
    public List<Point> getValidMoves() {
        return validMoves;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
