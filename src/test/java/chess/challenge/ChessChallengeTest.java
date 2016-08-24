package chess.challenge;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

public class ChessChallengeTest {

    @Test
    public void testMain() {
        String result = "K.K....R."
                      + "K....RK.."
                      + "..KR....K"
                      + ".R....K.K";
        ByteArrayInputStream in = new ByteArrayInputStream("3 3 2 0 0 1 0".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);

        System.out.println(result.toString());
        System.setIn(in);
        System.setOut(ps);

        ChessChallenge.main(new String[] {});
        assertTrue(result.equals(out.toString().replaceAll("\n", "").replaceAll("\r", "")));

        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void testPrintConfigurations() {
        String result = "R....N.N..R..N.N"
                      + ".R..N.N....RN.N."
                      + "..R..N.NR....N.N"
                      + "...RN.N..R..N.N."
                      + ".N.NR....N.N..R."
                      + "N.N..R..N.N....R"
                      + ".N.N..R..N.NR..."
                      + "N.N....RN.N..R..";

        ChessBoard board = new ChessBoard(4, 4);
        Queue<ChessPiece> pieces = new ArrayDeque<>();

        pieces.add(new Rock());
        pieces.add(new Rock());
        pieces.add(new Knight());
        pieces.add(new Knight());
        pieces.add(new Knight());
        pieces.add(new Knight());

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);

        System.setOut(ps);
        ChessChallenge.printConfigurations(board, pieces);
        assertTrue(result.equals(out.toString().replaceAll("\n", "").replaceAll("\r", "")));

        System.setOut(System.out);
    }

}
