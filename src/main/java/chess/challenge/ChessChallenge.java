package chess.challenge;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

import chess.challenge.piece.Bishop;
import chess.challenge.piece.ChessPiece;
import chess.challenge.piece.King;
import chess.challenge.piece.Knight;
import chess.challenge.piece.Queen;
import chess.challenge.piece.Rock;

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
        boolean showSummary = args.length > 0 && "-v".equals(args[0]);
        ChessBoard.ComputationSummary stats;
        if (summaryOnly) {
            stats = board.computeUniqueBoardCombinations(pieces);

        } else {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            stats = board.printUniqueBoardCombinations(pieces, out);
        }

        if (showSummary || summaryOnly) {
            System.out.println(stats.getCalculations() + " calculations resulted in " + stats.getUniqueBoards()
            + " unique combinations in " + (double) stats.getElapsedTime() / 1000.0 + " seconds.");
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
