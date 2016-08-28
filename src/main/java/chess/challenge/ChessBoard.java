package chess.challenge;

import java.awt.Point;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import chess.challenge.piece.ChessPiece;
import chess.challenge.piece.PieceType;

/**
 * Object representing a chess board with variable dimensions.
 * 
 * @author mabernardo
 * @version 1.0
 * @since 1.0
 */
public class ChessBoard {

    private final int ranks;
    private final int files;
    private PieceType[][] boardState;

    private static int calculations = 0;
    private static int uniqueBoards = 0;

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
        boardState = new PieceType[ranks][files];

        // Leaving the array uninitialized had no impact on the performance.
        for (PieceType[] rank : boardState) {
            Arrays.fill(rank, PieceType.NONE);
        }
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
        boardState = new PieceType[ranks][files];

        PieceType[][] state = board.getBoardState();
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
        if (boardState[p.x][p.y] != PieceType.NONE) {
            return false;
        }

        List<Point> threatList = piece.threatArea(this);
        for (Point tp : threatList) {
            PieceType cell = boardState[tp.x][tp.y];
            if (cell != PieceType.NONE && cell != PieceType.THREAT) {
                return false;
            }
        }
        boardState[p.x][p.y] = piece.getType();
        markThreatArea(threatList);

        return true;
    }

    /**
     * Update the boarsState with the cells list passed in the parameter.
     * 
     * @param threatList
     */
    private void markThreatArea(List<Point> threatList) {
        threatList.forEach(tp -> {
            boardState[tp.x][tp.y] = PieceType.THREAT;
        });
    }

    /**
     * Static nested class with the results of the computation of unique board
     * combinations. Contains data about the processing time, number of
     * iterations and number of unique boards found during the process.
     */
    static class ComputationSummary {
        private final long startTime;
        private long endTime;
        private long elapsedTime;
        private long calculations;
        private long uniqueBoards;

        private ComputationSummary() {
            startTime = System.nanoTime();
        }

        /**
         * Creates a new instance of this class initializing the starting time
         * of computation.
         * 
         * @return a new ComputationSummary instance
         */
        public static ComputationSummary start() {
            return new ComputationSummary();
        }

        /**
         * Marks the end time of computation and calculates the elapsed time.
         */
        public void stop() {
            endTime = System.nanoTime();
            elapsedTime = TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS);
        }

        public long getStartTime() {
            return startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public long getElapsedTime() {
            return elapsedTime;
        }

        public long getCalculations() {
            return calculations;
        }

        public long getUniqueBoards() {
            return uniqueBoards;
        }
    }

    /**
     * Facade for the main board computation method receiving a printer to where
     * the results are to be printed.
     * 
     * @param pieces
     *            Pieces to be added to the boards
     * @param out
     *            PrinterWriter where the results will br printed.
     * @return ComputationSummary with duration, iterations and number of unique
     *         boards found.
     */
    public ComputationSummary printUniqueBoardCombinations(Queue<ChessPiece> pieces, PrintWriter out) {
        ComputationSummary s = executeBoardsComputation(pieces, out);
        out.flush();
        return s;
    }

    /**
     * Facade for the main board computation method. This method passes
     * a null writer to the executor method, so nothing will be printed.
     * 
     * @param pieces
     *            Pieces to be added to the boards
     * @return ComputationSummary with duration, iterations and number of unique
     *         boards found.
     */
    public ComputationSummary computeUniqueBoardCombinations(Queue<ChessPiece> pieces) {
        return executeBoardsComputation(pieces, null);
    }

    /**
     * Fires the execution of the board computation method and filling out the
     * ComputationSummary.
     * 
     * @param pieces
     *            Pieces to be added to the boards
     * @param out
     *            PrinterWriter where the results will br printed.
     * @return ComputationSummary
     */
    private ComputationSummary executeBoardsComputation(Queue<ChessPiece> pieces, PrintWriter out) {
        resetCounters();
        ComputationSummary stats = ComputationSummary.start();
        printUniqueBoardCombinations(this, pieces, out, null, 0, 0);
        stats.stop();
        stats.calculations = calculations;
        stats.uniqueBoards = uniqueBoards;

        return stats;
    }

    private static void resetCounters() {
        calculations = 0;
        uniqueBoards = 0;
    }

    /**
     * Calculates all possible configurations for which all of the pieces can be
     * placed on board without threatening each other.
     * This method is not thread safe.
     * 
     * @param board
     *            board with the dimensions needed for the calculation.
     * @param pieces
     *            pieces to be placed on the boards.
     * @return Set of unique configurations.
     */
    private static void printUniqueBoardCombinations(ChessBoard board, Queue<ChessPiece> pieces, PrintWriter out,
            PieceType previousPieceType, int previousRank, int previousFile) {
        ChessPiece p = pieces.poll();
        ChessBoard testBoard = new ChessBoard(board);
        int startRank = 0;
        int startFile = 0;

        if (p.getType() == previousPieceType) {
            startRank = previousRank;
            startFile = previousFile;
        }
        for (int rank = startRank; rank < board.getRanks(); ++rank) {
            for (int file = startFile; file < board.getFiles(); ++file) {
                calculations++;
                ChessPiece testPiece = ChessPiece.newFromType(p.getType(), rank, file);
                if (!testBoard.putPiece(testPiece)) {
                    continue;
                }
                if (pieces.isEmpty()) {
                    testBoard.print(out);
                    uniqueBoards++;
                } else {
                    Queue<ChessPiece> remainingPieces = new ArrayDeque<>(pieces);
                    printUniqueBoardCombinations(testBoard, remainingPieces, out, p.getType(), rank, file);
                }
                testBoard = new ChessBoard(board);
            }
            startFile = 0;
        }
    }

    /**
     * Print out the board to the specified PrintWriter.
     * 
     * @param pw
     *            writer where is to be printed.
     */
    public void print(PrintWriter pw) {
        if (pw == null) {
            return;
        }

        for (PieceType[] rank : boardState) {
            for (PieceType cell : rank) {
                pw.print(cell.symbol());
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

    public PieceType[][] getBoardState() {
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
