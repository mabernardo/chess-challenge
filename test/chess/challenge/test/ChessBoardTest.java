package chess.challenge.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import chess.challenge.Bishop;
import chess.challenge.ChessBoard;
import chess.challenge.ChessPiece;
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
    public void testPrintConfigurations() {
        ChessBoard board = new ChessBoard(3, 3);
        Queue<ChessPiece> pieces = new ArrayDeque<>();
        pieces.add(new King(0, 0));
        pieces.add(new King(0, 0));
        pieces.add(new Rock(0, 0));
        
        ChessBoard.printConfigurations(board, pieces);
    }
}
