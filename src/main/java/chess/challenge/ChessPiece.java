package chess.challenge;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract representation of a chess piece.
 * 
 * @author mabernardo
 * @version 1.0
 * @since 1.0
 */
public abstract class ChessPiece {
    private final int rank;
    private final int file;
    private final boolean limitedRange;

    /**
     * Protected constructor defining the initial piece position and whether the
     * piece has a limited range or not.
     * 
     * @param position
     *            Initial piece position.
     * @param limitedRange
     *            Sets if the piece has a limited range.
     */
    protected ChessPiece(int rank, int file, boolean limitedRange) {
        this.rank = rank;
        this.file = file;
        this.limitedRange = limitedRange;
    }

    /**
     * Returns whether the piece has a limited range or not.
     * 
     * @return The value of limitedRage.
     */
    public boolean hasLimitedRange() {
        return limitedRange;
    }

    /**
     * Returns the list of valid moves of the piece.
     * 
     * @return List of valid moves.
     */
    public abstract List<Point> getValidMoves();

    /**
     * Gets the symbol representing the piece.
     * 
     * @return symbol representing the piece.
     */
    public abstract PieceType getType();

    /**
     * Returns a list of coordinates that the piece threatens.
     * 
     * @param board
     *            the board where the threat area will be tested
     * @return list of coordinates that the piece threatens.
     */
    public List<Point> threatArea(ChessBoard board) {
        if (this.hasLimitedRange()) {
            return threatAreaLimited(board);
        }
        return threatAreaUnlimited(board);
    }

    private List<Point> threatAreaLimited(ChessBoard board) {
        List<Point> threats = new ArrayList<>();
        Point p = new Point(this.rank, this.file);

        for (Point p1 : this.getValidMoves()) {
            int x1 = p.x + p1.x;
            int y1 = p.y + p1.y;
            if ((x1 >= 0 && x1 < board.getRanks()) && (y1 >= 0 && y1 < board.getFiles())) {
                threats.add(new Point(x1, y1));
            }
        }
        return threats;
    }

    private List<Point> threatAreaUnlimited(ChessBoard board) {
        List<Point> threats = new ArrayList<>();
        Point p = new Point(this.rank, this.file);

        for (Point p1 : this.getValidMoves()) {
            int x1 = p.x + p1.x;
            int y1 = p.y + p1.y;
            int distance = 1;
            while ((x1 >= 0 && x1 < board.getRanks()) && (y1 >= 0 && y1 < board.getFiles())) {
                threats.add(new Point(x1, y1));
                distance++;
                x1 = p.x + p1.x * distance;
                y1 = p.y + p1.y * distance;
            }
        }
        return threats;
    }

    /**
     * Creates a new instance of the specified piece type.
     * 
     * @param type
     *            symbol of the piece to be created.
     * @param rank
     *            rank where the piece will be placed.
     * @param file
     *            file where the piece will be placed.
     * @return a new instance of the piece.
     */
    public static ChessPiece newFromType(PieceType type, int rank, int file) {
        ChessPiece cp;
        switch (type) {
        case KING:
            cp = new King(rank, file);
            break;
        case QUEEN:
            cp = new Queen(rank, file);
            break;
        case ROCK:
            cp = new Rock(rank, file);
            break;
        case KNIGHT:
            cp = new Knight(rank, file);
            break;
        case BISHOP:
            cp = new Bishop(rank, file);
            break;
        default:
            return null;
        }
        return cp;
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

    /**
     * Prints out the piece coordinates in algebraic notation. 
     */
    @Override
    public String toString() {
        final int asciiCodeA = 97;
        final int standardBoardSize = 8;
        StringBuilder sb = new StringBuilder();
        sb.append(this.getType().symbol());
        sb.append(Character.toString((char) (asciiCodeA + file)));
        sb.append(String.valueOf(rank + Math.abs(rank - standardBoardSize)));

        return sb.toString();
    }
}
