package chess.challenge;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

        System.setIn(in);
        System.setOut(ps);

        ChessChallenge.main(new String[] {});
        assertTrue(result.equals(out.toString().replaceAll("\n", "").replaceAll("\r", "")));

        System.setIn(System.in);
        System.setOut(System.out);
    }
}
