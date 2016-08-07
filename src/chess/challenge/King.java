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
    public King(Point position) {
        super(position, true);
    }

    @Override
    public List<Point> getValidMoves() {
        return validMoves;
    }

    @Override
    public String toString() {
        return "K";
    }
}
