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

	private static final String SYMBOL = "K";
	private static final boolean LIMITED_RANGE = true;

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
     * Constructor defining initial position.
     * 
     * @param position Initial piece position.
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
    public String getSymbol() {
        return SYMBOL;
    }
}
