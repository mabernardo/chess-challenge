package chess.challenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

import chess.challenge.Bishop;
import chess.challenge.ChessBoard;
import chess.challenge.King;
import chess.challenge.Knight;
import chess.challenge.Queen;
import chess.challenge.Rock;


public class ChessBoardTest {

    @Test
    public void testChessBoard() {
        ChessBoard board = new ChessBoard(7, 7);
        assertTrue(board.putPiece(new King(3, 3)));
        
        board = new ChessBoard(7, 7);
        assertTrue(board.putPiece(new Queen(3, 3)));

        board = new ChessBoard(7, 7);
        assertTrue(board.putPiece(new Rock(3, 3)));

        board = new ChessBoard(7, 7);
        assertTrue(board.putPiece(new Knight(3, 3)));

        board = new ChessBoard(7, 7);
        assertTrue(board.putPiece(new Bishop(3, 3)));
    }

    @Test
    public void testChessBoardCopy() {
        final int threatMarker = -1;
        ChessBoard board = new ChessBoard(3, 3);

        assertTrue(board.putPiece(new King(0, 0)));
        assertTrue(board.putPiece(new King(2, 2)));

        assertEquals(PieceType.KING, PieceType.get(board.getBoardState()[0][0]));
        assertEquals(PieceType.KING, PieceType.get(board.getBoardState()[2][2]));

        assertEquals(threatMarker, board.getBoardState()[0][1]);
        assertEquals(threatMarker, board.getBoardState()[1][0]);
        assertEquals(threatMarker, board.getBoardState()[1][1]);

        assertEquals(threatMarker, board.getBoardState()[2][1]);
        assertEquals(threatMarker, board.getBoardState()[1][2]);
        assertEquals(threatMarker, board.getBoardState()[1][1]);

        ChessBoard copy = new ChessBoard(board);
        assertEquals(PieceType.KING, PieceType.get(copy.getBoardState()[0][0]));
        assertEquals(PieceType.KING, PieceType.get(copy.getBoardState()[2][2]));

        assertEquals(threatMarker, copy.getBoardState()[0][1]);
        assertEquals(threatMarker, copy.getBoardState()[1][0]);
        assertEquals(threatMarker, copy.getBoardState()[1][1]);

        assertEquals(threatMarker, copy.getBoardState()[2][1]);
        assertEquals(threatMarker, copy.getBoardState()[1][2]);
        assertEquals(threatMarker, copy.getBoardState()[1][1]);
    }

    @Test
    public void testGetRanks() {
        ChessBoard board = new ChessBoard(8, 8);
        assertEquals(8, board.getRanks());
    }

    /**
     * Test method for {@link chess.challenge.ChessBoard#getFiles()}.
     */
    @Test
    public void testGetFiles() {
    	ChessBoard board = new ChessBoard(8, 8);
        assertEquals(8, board.getFiles());
    }

    /**
     * Test method for {@link chess.challenge.ChessBoard#getBoardState()}.
     */
    @Test
    public void testGetBoardState() {
    	ChessBoard board = new ChessBoard(8, 8);
    	assertEquals(8, board.getBoardState().length);
        assertEquals(8, board.getBoardState()[0].length);
    }

    /**
     * Test method for {@link chess.challenge.ChessBoard#putPiece()}.
     */
    @Test
    public void testPutPiece() {
        ChessBoard board = new ChessBoard(7, 7);

        assertTrue(board.putPiece(new King(3, 3)) && PieceType.KING.code() == board.getBoardState()[3][3]);
        assertFalse(board.putPiece(new Queen(0, 0)));
        assertFalse(board.putPiece(new Queen(0, 6)));
        assertFalse(board.putPiece(new Queen(6, 0)));
        assertFalse(board.putPiece(new Queen(6, 6)));
        assertFalse(board.putPiece(new Queen(0, 3)));
        assertFalse(board.putPiece(new Queen(3, 6)));
        assertFalse(board.putPiece(new Queen(6, 3)));
        assertFalse(board.putPiece(new Queen(3, 0)));

        assertTrue(board.getBoardState()[0][0] == 0);
        assertTrue(board.getBoardState()[0][6] == 0);
        assertTrue(board.getBoardState()[6][0] == 0);
        assertTrue(board.getBoardState()[6][6] == 0);
        assertTrue(board.getBoardState()[0][3] == 0);
        assertTrue(board.getBoardState()[3][6] == 0);
        assertTrue(board.getBoardState()[6][3] == 0);
        assertTrue(board.getBoardState()[3][0] == 0);

        assertTrue(board.putPiece(new King(1, 1)));
        assertTrue(board.putPiece(new King(1, 3)));
        assertTrue(board.putPiece(new King(1, 5)));
        assertTrue(board.putPiece(new King(3, 1)));
        assertTrue(board.putPiece(new King(3, 5)));
        assertTrue(board.putPiece(new King(5, 1)));
        assertTrue(board.putPiece(new King(5, 3)));
        assertTrue(board.putPiece(new King(5, 5)));
    }

    @Test
    public void testEquals() {
        ChessBoard board1 = new ChessBoard(3, 3);
        ChessBoard board2 = new ChessBoard(3, 3);
        assertEquals(board1, board2);

        board1.putPiece(new King(0, 0));
        board2.putPiece(new King(0, 0));
        assertEquals(board1, board2);

        board2.putPiece(new King(2, 2));
        assertNotEquals(board1, board2);

        board1 = new ChessBoard(3, 3);
        board2 = new ChessBoard(2, 2);
        assertNotEquals(board1, board2);
    }

    @Test
    public void testPrintUniqueBoardCombinations() {
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
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(ps)));

        ChessBoard.ComputationSummary s = board.printUniqueBoardCombinations(pieces, pw);
        assertTrue(result.equals(out.toString().replaceAll("\n", "").replaceAll("\r", "")));
        assertEquals(8, s.getUniqueBoards());
    }

    @Test
    public void testComputeUniqueBoardCombinations() {
        ChessBoard board = new ChessBoard(4, 4);
        Queue<ChessPiece> pieces = new ArrayDeque<>();

        pieces.add(new Rock());
        pieces.add(new Rock());
        pieces.add(new Knight());
        pieces.add(new Knight());
        pieces.add(new Knight());
        pieces.add(new Knight());

        ChessBoard.ComputationSummary s = board.computeUniqueBoardCombinations(pieces);
        assertEquals(8, s.getUniqueBoards());
    }
}
