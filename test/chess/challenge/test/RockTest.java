package chess.challenge.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.List;

import org.junit.Test;

import chess.challenge.ChessBoard;
import chess.challenge.Rock;


public class RockTest {

    @Test
    public void testGetValidMoves() {
        Rock rock = new Rock(0, 0);
    	assertNotNull(rock.getValidMoves());
    }

    @Test
    public void testRock() {
        Rock rock = new Rock(0, 1);
        assertEquals(0, rock.getRank());
        assertEquals(1, rock.getFile());
        assertFalse(rock.hasLimitedRange());
        assertTrue("R".equals(rock.getSymbol()));
        assertTrue("Rb8".equals(rock.toString()));
    }

    @Test
    public void testThreatArea() {
    	ChessBoard board = new ChessBoard(7, 7);
    	Rock r = new Rock(3, 3);
    	List<Point> area = r.threatArea(board);
    	assertTrue(area.contains(new Point(0, 3)));
    	assertTrue(area.contains(new Point(1, 3)));
    	assertTrue(area.contains(new Point(2, 3)));
    	assertTrue(area.contains(new Point(3, 0)));
    	assertTrue(area.contains(new Point(3, 1)));
    	assertTrue(area.contains(new Point(3, 2)));
    	assertTrue(area.contains(new Point(4, 3)));
    	assertTrue(area.contains(new Point(5, 3)));
    	assertTrue(area.contains(new Point(6, 3)));
    	assertTrue(area.contains(new Point(3, 4)));
    	assertTrue(area.contains(new Point(3, 5)));
    	assertTrue(area.contains(new Point(3, 6)));

    	assertFalse(area.contains(new Point(0, 0)));
    	assertFalse(area.contains(new Point(1, 1)));
    	assertFalse(area.contains(new Point(2, 2)));
    	assertFalse(area.contains(new Point(2, 4)));
    	assertFalse(area.contains(new Point(1, 5)));
    	assertFalse(area.contains(new Point(0, 6)));
    	assertFalse(area.contains(new Point(4, 2)));
    	assertFalse(area.contains(new Point(5, 1)));
    	assertFalse(area.contains(new Point(6, 0)));
    	assertFalse(area.contains(new Point(4, 4)));
    	assertFalse(area.contains(new Point(5, 5)));
    	assertFalse(area.contains(new Point(6, 6)));
    }
}
