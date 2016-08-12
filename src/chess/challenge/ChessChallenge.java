package chess.challenge;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author mabernardo
 */
public class ChessChallenge {

    private static int calculations = 0;
    private static int uniqueBoards = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ranks = scan.nextInt();
        int files = scan.nextInt();
        int kings = scan.nextInt();
        int queens = scan.nextInt();
        int bishops = scan.nextInt();
        int rocks = scan.nextInt();
        int knights = scan.nextInt();
        scan.close();

        ChessBoard board = new ChessBoard(ranks, files);
        Queue<ChessPiece> pieces = new ArrayDeque<>();
        while (kings-- > 0) {
            pieces.add(new King());
        }
        while (queens-- > 0) {
            pieces.add(new Queen());
        }
        while (bishops-- > 0) {
            pieces.add(new Bishop());
        }
        while (rocks-- > 0) {
            pieces.add(new Rock());
        }
        while (knights-- > 0) {
            pieces.add(new Knight());
        }

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
     * Facade for the
     * 
     * @param board
     * @param pieces
     */
    public static void printConfigurations(ChessBoard board, Queue<ChessPiece> pieces) {
        printConfigurations(board, pieces, null, 0, 0);
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
    private static void printConfigurations(ChessBoard board, Queue<ChessPiece> pieces, String previous, int startRank,
            int startFile) {
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
                if (testBoard.putPiece(testPiece)) {
                    if (pieces.isEmpty()) {
                        testBoard.print(System.out);
                        uniqueBoards++;
                    } else {
                        Queue<ChessPiece> remainingPieces = new ArrayDeque<>(pieces);
                        printConfigurations(testBoard, remainingPieces, p.getSymbol(), m, n);
                    }
                    testBoard = new ChessBoard(board);
                }
            }
            startN = 0;
        }
    }

}
