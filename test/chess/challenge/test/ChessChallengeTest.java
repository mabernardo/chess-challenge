package chess.challenge.test;

import static org.junit.Assert.assertArrayEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

import chess.challenge.ChessBoard;
import chess.challenge.ChessChallenge;
import chess.challenge.ChessPiece;
import chess.challenge.Knight;
import chess.challenge.Rock;

public class ChessChallengeTest {

    @Test
    public void testMain() {
        byte[] result = { 75, 46, 75, 10, 46, 46, 46, 10, 46, 82, 46, 10, 10, 75, 46, 46, 10, 46, 46, 82, 10, 75, 46,
                46, 10, 10, 46, 46, 75, 10, 82, 46, 46, 10, 46, 46, 75, 10, 10, 46, 82, 46, 10, 46, 46, 46, 10, 75, 46,
                75, 10, 10 };
        ByteArrayInputStream in = new ByteArrayInputStream("3 3 2 0 0 1 0".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);

        System.setIn(in);
        System.setOut(ps);

        ChessChallenge.main(new String[] {});
        assertArrayEquals(result, out.toByteArray());

        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void testPrintConfigurations() {
        byte[] result = { 82, 46, 46, 46, 10, 46, 78, 46, 78, 10, 46, 46, 82, 46, 10, 46, 78, 46, 78, 10, 10, 46, 82,
                46, 46, 10, 78, 46, 78, 46, 10, 46, 46, 46, 82, 10, 78, 46, 78, 46, 10, 10, 46, 46, 82, 46, 10, 46, 78,
                46, 78, 10, 82, 46, 46, 46, 10, 46, 78, 46, 78, 10, 10, 46, 46, 46, 82, 10, 78, 46, 78, 46, 10, 46, 82,
                46, 46, 10, 78, 46, 78, 46, 10, 10, 46, 78, 46, 78, 10, 82, 46, 46, 46, 10, 46, 78, 46, 78, 10, 46, 46,
                82, 46, 10, 10, 78, 46, 78, 46, 10, 46, 82, 46, 46, 10, 78, 46, 78, 46, 10, 46, 46, 46, 82, 10, 10, 46,
                78, 46, 78, 10, 46, 46, 82, 46, 10, 46, 78, 46, 78, 10, 82, 46, 46, 46, 10, 10, 78, 46, 78, 46, 10, 46,
                46, 46, 82, 10, 78, 46, 78, 46, 10, 46, 82, 46, 46, 10, 10 };

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
        assertArrayEquals(result, out.toByteArray());

        System.setOut(System.out);
    }

}
