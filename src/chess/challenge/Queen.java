package chess.challenge;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Queen chess piece implementation.
 * 
 * @author mabernardo
 * @version 1.0
 * @since 1.0
 */
public class Queen extends ChessPiece {

    public static final String SYMBOL = "Q";
    private static final boolean LIMITED_RANGE = false;

    @SuppressWarnings("serial")
    private static final List<Point> validMoves = new ArrayList<Point>() {{
        add(new Point(-1, -1));
        add(new Point(-1, 0));
        add(new Point(-1, 1));
        add(new Point(0, -1));
        add(new Point(0, 1));
        add(new Point(1, -1));
        add(new Point(1, 0));
        add(new Point(1, 1));
    }};

    /**
     * Default constructor.
     */
    public Queen() {
        super(0, 0, LIMITED_RANGE);
    }

    /**
     * Constructor defining initial position.
     * 
     * @param position
     * @param limitedRange
     */
    public Queen(int rank, int file) {
        super(rank, file, LIMITED_RANGE);
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
    public String getSymbol() {
        return SYMBOL;
    }
}
