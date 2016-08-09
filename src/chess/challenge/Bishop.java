package chess.challenge;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Bishop chess piece implementation.
 * 
 * @author mabernardo
 * @version 1.0
 * @since 1.0
 */
public class Bishop extends ChessPiece {
	
	private static final String SYMBOL = "B";
	private static final boolean LIMITED_RANGE = false;

    @SuppressWarnings("serial")
    private static final List<Point> validMoves = new ArrayList<Point>() {{
        add(new Point(-1, 1));
        add(new Point(1, 1));
        add(new Point(1, -1));
        add(new Point(-1, -1));
    }};

    /**
     * Constructor defining initial position.
     * 
     * @param position
     * @param LIMITED_RANGE
     */
    public Bishop(int rank, int file) {
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
