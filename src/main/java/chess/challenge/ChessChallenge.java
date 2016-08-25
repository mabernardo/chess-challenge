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

    private ChessChallenge() {
    }

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

        ChessBoard.ComputationSummary stats;
        boolean summaryOnly = (args.length > 0 && "-s".equals(args[0]));
        if (summaryOnly) {
            stats = board.computeUniqueBoardCombinations(pieces);
        } else {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            stats = board.printUniqueBoardCombinations(pieces, out);
        }

        if (summaryOnly) {
            System.out.println(stats.getCalculations() + " calculations resulted in " + stats.getUniqueBoards()
                    + " unique combinations in " + (double) stats.getElapsedTime() / 1000.0 + " seconds.");
        }
    }

}
