/**
 * 
 */
package chess.challenge;

import java.awt.Point;
import java.util.List;

/**
 * Object representing a chess board with variable dimensions.
 * 
 * @author mabernardo
 * @version 1.0
 * @since 1.0
 */
public class ChessBoard {

    private static final String THREAT_MARKER = "X";
    private static final String EMPTY_MARKER = ".";

    private final int ranks;
    private final int files;
    private String[][] boardState;
    
    /**
     * Creates a board with dimensions ranks x files.
     * 
     * @param ranks number of ranks in board.
     * @param files number of files in board.
     */
    public ChessBoard(int ranks, int files) {
        this.ranks = ranks;
        this.files = files;
        boardState = new String[ranks][files];
    }

    /**
     * Attempt to put a piece in the specified board coordinates.
     * If the cell is empty, mark the position with the piece symbol and
     * marks the threat area of that piece.
     * 
     * @param piece piece to be put.
     * @param rank rank where the piece is to be put.
     * @param file file where the piece is to be put.
     * @return returns if it was possible to put the piece in that position.
     */
    public boolean putPiece(ChessPiece piece) {
        Point p = new Point(piece.getRank(), piece.getFile());
    	if (boardState[p.x][p.y] != null) {
            return false;
        }
        
        List<Point> threatList = piece.threatArea(this);
        for (Point tp : threatList) {
            String cell = boardState[tp.x][tp.y];
        	if (cell != null && !THREAT_MARKER.equals(cell)) {
        		return false;
        	}
        }
        boardState[p.x][p.y] = new String(piece.getSymbol());
        markThreatArea(threatList);

        return true;
    }

    private void markThreatArea(List<Point> threatList) {
        for (Point tp : threatList) {
            boardState[tp.x][tp.y] = new String(THREAT_MARKER);
        }
    }

    /**
     * Prints the board to the StdOut.
     */
    public void printBoard() {
        for (String[] m : boardState) {
            for (String n : m) {
                System.out.print(n == null ? EMPTY_MARKER : n);
            }
            System.out.println();
        }
    }

    public int getRanks() {
        return ranks;
    }

    public int getFiles() {
        return files;
    }

    public String[][] getBoardState() {
        return boardState;
    }

}
