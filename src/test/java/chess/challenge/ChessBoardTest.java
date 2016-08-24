package chess.challenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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
        ChessBoard board = new ChessBoard(3, 3);

        assertTrue(board.putPiece(new King(0, 0)));
        assertTrue(board.putPiece(new King(2, 2)));

        assertTrue("K".equals(board.getBoardState()[0][0]));
        assertTrue("K".equals(board.getBoardState()[2][2]));

        assertTrue("X".equals(board.getBoardState()[0][1]));
        assertTrue("X".equals(board.getBoardState()[1][0]));
        assertTrue("X".equals(board.getBoardState()[1][1]));

        assertTrue("X".equals(board.getBoardState()[2][1]));
        assertTrue("X".equals(board.getBoardState()[1][2]));
        assertTrue("X".equals(board.getBoardState()[1][1]));

        ChessBoard copy = new ChessBoard(board);
        assertTrue("K".equals(copy.getBoardState()[0][0]));
        assertTrue("K".equals(copy.getBoardState()[2][2]));

        assertTrue("X".equals(copy.getBoardState()[0][1]));
        assertTrue("X".equals(copy.getBoardState()[1][0]));
        assertTrue("X".equals(copy.getBoardState()[1][1]));

        assertTrue("X".equals(copy.getBoardState()[2][1]));
        assertTrue("X".equals(copy.getBoardState()[1][2]));
        assertTrue("X".equals(copy.getBoardState()[1][1]));
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

        assertTrue(board.putPiece(new King(3, 3)) && "K".equals(board.getBoardState()[3][3]));
        assertFalse(board.putPiece(new Queen(0, 0)));
        assertFalse(board.putPiece(new Queen(0, 6)));
        assertFalse(board.putPiece(new Queen(6, 0)));
        assertFalse(board.putPiece(new Queen(6, 6)));
        assertFalse(board.putPiece(new Queen(0, 3)));
        assertFalse(board.putPiece(new Queen(3, 6)));
        assertFalse(board.putPiece(new Queen(6, 3)));
        assertFalse(board.putPiece(new Queen(3, 0)));

        assertTrue(board.getBoardState()[0][0] == null);
        assertTrue(board.getBoardState()[0][6] == null);
        assertTrue(board.getBoardState()[6][0] == null);
        assertTrue(board.getBoardState()[6][6] == null);
        assertTrue(board.getBoardState()[0][3] == null);
        assertTrue(board.getBoardState()[3][6] == null);
        assertTrue(board.getBoardState()[6][3] == null);
        assertTrue(board.getBoardState()[3][0] == null);

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
}
