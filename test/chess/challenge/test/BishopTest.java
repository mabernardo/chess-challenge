package chess.challenge.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.List;

import org.junit.Test;

import chess.challenge.Bishop;
import chess.challenge.ChessBoard;

public class BishopTest {

    @Test
    public void testGetValidMoves() {
        Bishop bishop = new Bishop(0, 0);
    	assertNotNull(bishop.getValidMoves());
    }

    @Test
    public void testBishop() {
    	Bishop bishop = new Bishop(0, 1);
        assertEquals(0, bishop.getRank());
        assertEquals(1, bishop.getFile());
        assertFalse(bishop.hasLimitedRange());
        assertTrue("B".equals(bishop.getSymbol()));
        assertTrue("Bb8".equals(bishop.toString()));
    }
    
    @Test
    public void testThreatArea() {
    	ChessBoard board = new ChessBoard(7, 7);
    	Bishop b = new Bishop(3, 3);
    	List<Point> area = b.threatArea(board);
    	assertTrue(area.contains(new Point(0, 0)));
    	assertTrue(area.contains(new Point(1, 1)));
    	assertTrue(area.contains(new Point(2, 2)));
    	assertTrue(area.contains(new Point(2, 4)));
    	assertTrue(area.contains(new Point(1, 5)));
    	assertTrue(area.contains(new Point(0, 6)));
    	assertTrue(area.contains(new Point(4, 2)));
    	assertTrue(area.contains(new Point(5, 1)));
    	assertTrue(area.contains(new Point(6, 0)));
    	assertTrue(area.contains(new Point(4, 4)));
    	assertTrue(area.contains(new Point(5, 5)));
    	assertTrue(area.contains(new Point(6, 6)));
    	
    	assertFalse(area.contains(new Point(2, 3)));
    	assertFalse(area.contains(new Point(3, 2)));
    	assertFalse(area.contains(new Point(4, 3)));
    	assertFalse(area.contains(new Point(3, 4)));
    }
}
