/**
 * 
 */
package chess.challenge;

import java.awt.Point;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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

    public static int calculations = 0;
    public static int uniqueBoards = 0;

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
     * Calculates all possible configurations for which all of the pieces can be
     * placed on board without threatening each other.
     * 
     * @param board
     *            board with the dimensions needed for the calculation.
     * @param pieces
     *            pieces to be placed on the boards.
     * @return Set of unique configurations.
     */
    public static Set<ChessBoard> listConfigurations(ChessBoard board, Queue<ChessPiece> pieces) {
        ChessPiece p = pieces.poll();
        ChessBoard testBoard = new ChessBoard(board);
        Set<ChessBoard> configs = new LinkedHashSet<>();
        for (int m = 0; m < board.getRanks(); ++m) {
            for (int n = 0; n < board.getFiles(); ++n) {
                calculations++;
                ChessPiece testPiece = ChessPiece.newFromSymbol(p.getSymbol(), m, n);
                if (testBoard.putPiece(testPiece)) {
                    if (pieces.isEmpty()) {
                        configs.add(testBoard);
                    } else {
                        Queue<ChessPiece> remainingPieces = new ArrayDeque<>(pieces);
                        Set<ChessBoard> c = listConfigurations(testBoard, remainingPieces);
                        configs.addAll(c);
                    }
                    testBoard = new ChessBoard(board);
                }
            }
        }
        return configs;
    }

    public static Set<ChessBoard> listConfigurationsV2(ChessBoard board, Queue<ChessPiece> pieces, String previous, int x, int y) {
        ChessPiece p = pieces.poll();
        ChessBoard testBoard = new ChessBoard(board);
        Set<ChessBoard> configs = new LinkedHashSet<>();
        int startM = 0;
        int startN = 0;
        if (p.getSymbol().equals(previous)) {
            startM = x;
            startN = y;
        }
        for (int m = startM; m < board.getRanks(); ++m) {
            for (int n = startN; n < board.getFiles(); ++n) {
                calculations++;
                ChessPiece testPiece = ChessPiece.newFromSymbol(p.getSymbol(), m, n);
                if (testBoard.putPiece(testPiece)) {
                    if (pieces.isEmpty()) {
                        testBoard.print(System.out);
                        uniqueBoards++;
                    } else {
                        Queue<ChessPiece> remainingPieces = new ArrayDeque<>(pieces);
                        listConfigurationsV2(testBoard, remainingPieces, p.getSymbol(), m, n);
                    }
                    testBoard = new ChessBoard(board);
                }
            }
            startN = 0;
        }
        return configs;
    }

    public static <T> List<T> rotate(List<T> aL) {
        if (aL.size() == 0)
            return aL;

        T element = null;
        element = aL.remove(aL.size() - 1);
        aL.add(0, element);

        return aL;
    }

    /**
     * Prints the board to the StdOut.
     */
    public void print(PrintStream ps) {
        for (String[] m : boardState) {
            for (String n : m) {
                ps.print(n == null || THREAT_MARKER.equals(n) ? EMPTY_MARKER : n);
            }
            ps.println();
        }
        ps.println();
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
