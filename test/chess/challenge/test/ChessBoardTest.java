package chess.challenge.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import chess.challenge.Bishop;
import chess.challenge.ChessBoard;
import chess.challenge.King;
import chess.challenge.Knight;
import chess.challenge.Queen;
import chess.challenge.Rock;


public class ChessBoardTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for {@link chess.challenge.ChessBoard#ChessBoard(int, int)}.
     */
    @Test
    public void testChessBoard() {
        ChessBoard board = new ChessBoard(7, 7);
        assertTrue(board.putPiece(new King(3, 3)));
        board.printBoard();
        System.out.println();
        
        board = new ChessBoard(7, 7);
        assertTrue(board.putPiece(new Queen(3, 3)));
        board.printBoard();
        System.out.println();

        board = new ChessBoard(7, 7);
        assertTrue(board.putPiece(new Rock(3, 3)));
        board.printBoard();
        System.out.println();

        board = new ChessBoard(7, 7);
        assertTrue(board.putPiece(new Knight(3, 3)));
        board.printBoard();
        System.out.println();

        board = new ChessBoard(7, 7);
        assertTrue(board.putPiece(new Bishop(3, 3)));
        board.printBoard();
        System.out.println();
    }

    /**
     * Test method for {@link chess.challenge.ChessBoard#getRanks()}.
     */
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
    	ChessBoard board = new ChessBoard(8, 8);
        King k = new King(0, 0);
        Queen q = new Queen(2, 1);
        
        assertTrue(board.putPiece(k));
        assertTrue(board.putPiece(q));
        /*
        assertTrue("K".equals(board.getBoardState()[0][0]));
        assertTrue("X".equals(board.getBoardState()[0][1]));
        assertTrue("X".equals(board.getBoardState()[1][0]));
        assertTrue("X".equals(board.getBoardState()[1][1]));
        assertNull(board.getBoardState()[0][2]);
        assertNull(board.getBoardState()[1][2]);
        assertNull(board.getBoardState()[2][0]);
        assertNull(board.getBoardState()[2][1]);
        assertNull(board.getBoardState()[2][2]);
        
        
        assertFalse(board.putPiece(k, 0, 0));
        assertFalse(board.putPiece(k, 0, 1));
        assertFalse(board.putPiece(k, 1, 1));
        assertTrue(board.putPiece(k, 0, 2));
        assertFalse(board.putPiece(q, 2, 0));
        assertFalse(board.putPiece(q, 1, 1));
        assertTrue(board.putPiece(q, 2, 1));
        */
        board.printBoard();
    }

}
