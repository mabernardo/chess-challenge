package chess.challenge;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author mabernardo
 */
public class ChessChallenge {

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
        ChessBoard.listConfigurationsV2(board, pieces, null, 0, 0);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        if (args.length > 0 && "-v".equals(args[0])) {
            System.out.println(ChessBoard.calculations + " calculations resulted in "
                    + ChessBoard.uniqueBoards + " unique combinations in " 
                    + (double) elapsedTime / 1000.0 + " seconds.");
        }
    }

}
