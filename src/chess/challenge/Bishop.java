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
     * @param limitedRange
     */
    public Bishop(Point position) {
        super(position, false);
    }

    /* (non-Javadoc)
     * @see chess.challenge.ChessPiece#getValidMoves()
     */
    @Override
    public List<Point> getValidMoves() {
        return validMoves;
    }

    @Override
    public String toString() {
        return "B";
    }
}
