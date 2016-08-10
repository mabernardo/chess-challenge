package chess.challenge.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

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

}
