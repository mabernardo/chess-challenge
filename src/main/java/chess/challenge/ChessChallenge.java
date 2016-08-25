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
        Scanner scanner = new Scanner(System.in);
        ChessBoard board = scanBoard(scanner);
        Queue<ChessPiece> pieces = scanPieces(scanner);

        boolean summaryOnly = args.length > 0 && "-s".equals(args[0]);
        if (summaryOnly) {
            ChessBoard.ComputationSummary stats = board.computeUniqueBoardCombinations(pieces);

            System.out.println(stats.getCalculations() + " calculations resulted in " + stats.getUniqueBoards()
                + " unique combinations in " + (double) stats.getElapsedTime() / 1000.0 + " seconds.");

        } else {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            board.printUniqueBoardCombinations(pieces, out);
        }
    }

    private static ChessBoard scanBoard(Scanner scanner) {
        int ranks = scanner.nextInt();
        int files = scanner.nextInt();

        return new ChessBoard(ranks, files);
    }

    private static Queue<ChessPiece> scanPieces(Scanner scanner) {
        Queue<ChessPiece> pieces = new ArrayDeque<>();

        int kings = scanner.nextInt();
        while (kings-- > 0) {
            pieces.add(new King());
        }

        int queens = scanner.nextInt();
        while (queens-- > 0) {
            pieces.add(new Queen());
        }

        int bishops = scanner.nextInt();
        while (bishops-- > 0) {
            pieces.add(new Bishop());
        }

        int rocks = scanner.nextInt();
        while (rocks-- > 0) {
            pieces.add(new Rock());
        }

        int knights = scanner.nextInt();
        while (knights-- > 0) {
            pieces.add(new Knight());
        }

        return pieces;
    }
}
