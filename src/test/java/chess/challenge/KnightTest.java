package chess.challenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.List;

import org.junit.Test;

import chess.challenge.ChessBoard;
import chess.challenge.Knight;

public class KnightTest {

    @Test
    public void testGetValidMoves() {
    	Knight knight = new Knight(0, 1);
        assertNotNull(knight.getValidMoves());
    }

    @Test
    public void testKnight() {
        Knight knight = new Knight(0, 1);
        assertEquals(0, knight.getRank());
        assertEquals(1, knight.getFile());
        assertTrue(knight.hasLimitedRange());
        assertTrue("N".equals(knight.getSymbol()));
        assertTrue("Nb8".equals(knight.toString()));
    }

    @Test
    public void testThreatArea() {
    	ChessBoard board = new ChessBoard(7, 7);
    	Knight n = new Knight(3, 3);
    	List<Point> area = n.threatArea(board);
    	assertTrue(area.contains(new Point(1, 2)));
    	assertTrue(area.contains(new Point(1, 4)));
    	assertTrue(area.contains(new Point(2, 5)));
    	assertTrue(area.contains(new Point(4, 5)));
    	assertTrue(area.contains(new Point(5, 4)));
    	assertTrue(area.contains(new Point(5, 2)));
    	assertTrue(area.contains(new Point(4, 1)));
    	assertTrue(area.contains(new Point(2, 1)));
    	
    	assertFalse(area.contains(new Point(0, 0)));
    	assertFalse(area.contains(new Point(0, 1)));
    	assertFalse(area.contains(new Point(0, 2)));
    	assertFalse(area.contains(new Point(0, 3)));
    	assertFalse(area.contains(new Point(0, 4)));
    	assertFalse(area.contains(new Point(0, 5)));
    	assertFalse(area.contains(new Point(0, 6)));
    	assertFalse(area.contains(new Point(1, 1)));
    	assertFalse(area.contains(new Point(1, 5)));
    	assertFalse(area.contains(new Point(5, 1)));
    	assertFalse(area.contains(new Point(5, 5)));

    	assertFalse(area.contains(new Point(2, 2)));
    	assertFalse(area.contains(new Point(2, 3)));
    	assertFalse(area.contains(new Point(2, 4)));
    	assertFalse(area.contains(new Point(3, 2)));
    	assertFalse(area.contains(new Point(3, 4)));
    	assertFalse(area.contains(new Point(4, 2)));
    	assertFalse(area.contains(new Point(4, 3)));
    	assertFalse(area.contains(new Point(4, 4)));
    }
}
