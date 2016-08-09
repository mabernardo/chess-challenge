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
     * Protected constructor defining the initial piece position and whether 
     * the piece has a limited range or not.
     * 
     * @param position Initial piece position.
     * @param limitedRange Sets if the piece has a limited range.
     */
    protected ChessPiece(int rank, int file, boolean limitedRange) {
        this.rank = rank;
        this.file = file;
        this.limitedRange = limitedRange;
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
     * Gets the symbol representing the piece.
     * 
     * @return symbol representing the piece.
     */
    public abstract String getSymbol();

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

    /**
     * Returns a list of coordinates that the piece threatens.
     * 
     * @param board the board where the threat area will be tested
     * @return list of coordinates that the piece threatens.
     */
    public List<Point> threatArea(ChessBoard board) {
    	List<Point> threats = new ArrayList<>();
    	Point p = new Point(this.rank, this.file);

    	if (this.hasLimitedRange()) {
	        for (Point p1 : this.getValidMoves()) {
                int x1 = p.x + p1.x;
                int y1 = p.y + p1.y;
                if ((x1 >= 0 && x1 < board.getRanks())
                		&& (y1 >= 0 && y1 < board.getFiles())) {
                	threats.add(new Point(x1, y1));
                }
        	}
        } else {
	        for (Point p1 : this.getValidMoves()) {
                int x1 = p.x + p1.x;
                int y1 = p.y + p1.y;
                int distance = 1;
                while ((x1 >= 0 && x1 < board.getRanks())
                		&& (y1 >= 0 && y1 < board.getFiles())) {
                	threats.add(new Point(x1, y1));
                    
                	distance++;
                	x1 = p.x + p1.x * distance;
                    y1 = p.y + p1.y * distance;
                }
        	}
        }
    	return threats;
    }

	public int getRank() {
		return rank;
	}

	public int getFile() {
		return file;
	}

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getSymbol() + Character.toString((char)(97 + file)) +  String.valueOf(rank + Math.abs(rank - 8));
    }

}
