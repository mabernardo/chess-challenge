/**
 * 
 */
package chess.challenge;

import java.awt.Point;
import java.io.PrintWriter;
import java.util.Arrays;
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
     * @param ranks
     *            number of ranks in board.
     * @param files
     *            number of files in board.
     */
    public ChessBoard(int ranks, int files) {
        this.ranks = ranks;
        this.files = files;
        boardState = new String[ranks][files];
    }

    /**
     * Copy constructor.
     * 
     * @param board
     *            Board to be copied.
     */
    public ChessBoard(ChessBoard board) {
        this.ranks = board.ranks;
        this.files = board.files;
        boardState = new String[ranks][files];

        String[][] state = board.getBoardState();
        for (int m = 0; m < state.length; m++) {
            for (int n = 0; n < state[0].length; n++) {
                boardState[m][n] = state[m][n];
            }
        }
    }

    /**
     * Attempt to put a piece in the specified board coordinates. If the cell is
     * empty, mark the position with the piece symbol and marks the threat area
     * of that piece.
     * 
     * @param piece
     *            piece to be put.
     * @param rank
     *            rank where the piece is to be put.
     * @param file
     *            file where the piece is to be put.
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

    /**
     * Update the boarsState with the cells list passed in the parameter.
     * 
     * @param threatList
     */
    private void markThreatArea(List<Point> threatList) {
        for (Point tp : threatList) {
            boardState[tp.x][tp.y] = new String(THREAT_MARKER);
        }
    }

    /**
     * Print out the board to the specified PrintStream.
     * 
     * @param pw
     *            writer where is to be printed.
     */
    public void print(PrintWriter pw) {
        for (String[] m : boardState) {
            for (String n : m) {
                pw.print(n == null || THREAT_MARKER.equals(n) ? EMPTY_MARKER : n);
            }
            pw.println();
        }
        pw.println();
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(boardState);
        result = prime * result + files;
        result = prime * result + ranks;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChessBoard other = (ChessBoard) obj;
        if (!Arrays.deepEquals(boardState, other.boardState))
            return false;
        if (files != other.files)
            return false;
        if (ranks != other.ranks)
            return false;
        return true;
    }
}
