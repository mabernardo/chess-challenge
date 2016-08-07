import java.awt.Point;
import java.util.List;

/**
 * Abstract representation of a chess piece.
 * 
 * @author mabernardo
 * @version 1.0
 * @since 1.0
 */
public abstract class ChessPiece {
    private final Point position;
    private final boolean limitedRange;

    /**
     * Protected constructor defining the initial piece position and whether 
     * the piece has a limited range or not.
     * 
     * @param position Initial piece position.
     * @param limitedRange Sets if the piece has a limited range.
     */
    protected ChessPiece(Point position, boolean limitedRange) {
        this.position = position;
        this.limitedRange = limitedRange;
    }

    /**
     * Returns the current position of the piece.
     * @return Piece position.
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Returns whether the piece has a limited range or not.
     * @return The value of limitedRage.
     */
    public boolean hasLimitedRange() {
        return limitedRange;
    }

    /**
     * Returns the list of valid moves of the piece.
     * @return List of valid moves.
     */
    public abstract List<Point> getValidMoves();

    /**
     * Checks if the piece threatens the specified point based on the board 
     * dimensions.
     * 
     * @param p Point to checked.
     * @return boolean indicating if the point is threatened by the piece.
     */
    public boolean threatens(Point p, int boardSizeM, int boardSizeN) {
        // TODO: Code to check if the piece threatens the Point p
        return false;
    }
}
