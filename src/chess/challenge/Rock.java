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

	private static final String SYMBOL = "R";
	private static final boolean LIMITED_RANGE = false;

    @SuppressWarnings("serial")
    private static final List<Point> validMoves = new ArrayList<Point>() {{
        add(new Point(-1, 0));
        add(new Point(0, 1));
        add(new Point(1, 0));
        add(new Point(0, -1));
    }};

    /** 
     * Constructor defining the initial position.
     * @param position
     * @param limitedRange
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
