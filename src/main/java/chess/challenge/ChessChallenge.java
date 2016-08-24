package chess.challenge;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author mabernardo
 */
public class ChessChallenge {

    private static int calculations = 0;
    private static int uniqueBoards = 0;

    private ChessChallenge() { }

    /**
     * Application entry point.
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ranks = scan.nextInt();
        int files = scan.nextInt();

        ChessBoard board = new ChessBoard(ranks, files);
        Queue<ChessPiece> pieces = new ArrayDeque<>();

        int kings = scan.nextInt();
        while (kings-- > 0) {
            pieces.add(new King());
        }

        int queens = scan.nextInt();
        while (queens-- > 0) {
            pieces.add(new Queen());
        }

        int bishops = scan.nextInt();
        while (bishops-- > 0) {
            pieces.add(new Bishop());
        }

        int rocks = scan.nextInt();
        while (rocks-- > 0) {
            pieces.add(new Rock());
        }

        int knights = scan.nextInt();
        while (knights-- > 0) {
            pieces.add(new Knight());
        }
        scan.close();

        long startTime = System.currentTimeMillis();
        printConfigurations(board, pieces);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        if (args.length > 0 && "-v".equals(args[0])) {
            System.out.println(calculations + " calculations resulted in " + uniqueBoards + " unique combinations in "
                    + (double) elapsedTime / 1000.0 + " seconds.");
        }
    }

    /**
     * Facade for the other printConfigurations method. This method creates a
     * buffered writer to the stdout, which is much more efficient then writing
     * direct to it.
     * 
     * @param board
     * @param pieces
     */
    public static void printConfigurations(ChessBoard board, Queue<ChessPiece> pieces) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            printConfigurations(board, pieces, out, null, 0, 0);
            out.flush();
        } catch (Exception e) {
            System.err.println(e);
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
    private static void printConfigurations(ChessBoard board, Queue<ChessPiece> pieces, PrintWriter out,
            String previous, int startRank, int startFile) {
        ChessPiece p = pieces.poll();
        ChessBoard testBoard = new ChessBoard(board);
        int startM = 0;
        int startN = 0;

        if (p.getSymbol().equals(previous)) {
            startM = startRank;
            startN = startFile;
        }
        for (int m = startM; m < board.getRanks(); ++m) {
            for (int n = startN; n < board.getFiles(); ++n) {
                calculations++;
                ChessPiece testPiece = ChessPiece.newFromSymbol(p.getSymbol(), m, n);
                if (!testBoard.putPiece(testPiece)) {
                    continue;
                }
                if (pieces.isEmpty()) {
                    testBoard.print(out);
                    uniqueBoards++;
                } else {
                    Queue<ChessPiece> remainingPieces = new ArrayDeque<>(pieces);
                    printConfigurations(testBoard, remainingPieces, out, p.getSymbol(), m, n);
                }
                testBoard = new ChessBoard(board);
            }
            startN = 0;
        }
    }
}
