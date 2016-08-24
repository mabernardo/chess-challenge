package chess.challenge;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Knight chess piece implementation.
 * 
 * @author mabernardo
 * @version 1.0
 * @since 1.0
 */
public class Knight extends ChessPiece {

    public static final String SYMBOL = "N";
    private static final boolean LIMITED_RANGE = true;

    private static final List<Point> validMoves;
    static {
        validMoves = new ArrayList<>();
        validMoves.add(new Point(-2, 1));
        validMoves.add(new Point(-1, 2));
        validMoves.add(new Point(1, 2));
        validMoves.add(new Point(2, 1));
        validMoves.add(new Point(2, -1));
        validMoves.add(new Point(1, -2));
        validMoves.add(new Point(-1, -2));
        validMoves.add(new Point(-2, -1));
    }

    /**
     * Default constructor.
     */
    public Knight() {
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
    public Knight(int rank, int file) {
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
