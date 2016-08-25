package chess.challenge;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.List;

import org.junit.Test;

import chess.challenge.ChessBoard;
import chess.challenge.King;

public class KingTest {

    @Test
    public void testGetValidMoves() {
    	King king = new King(0, 0);
        assertNotNull(king.getValidMoves());
    }

    @Test
    public void testKing() {
        King king = new King(0, 1);
        assertEquals(0, king.getRank());
        assertEquals(1, king.getFile());
        assertTrue(king.hasLimitedRange());
        assertEquals(PieceType.KING, king.getType());
        assertTrue("K".equals(king.getType().symbol()));
        assertTrue("Kb8".equals(king.toString()));
    }
    
    @Test
    public void testThreatArea() {
    	ChessBoard board = new ChessBoard(7, 7);
    	King k = new King(3, 3);
    	List<Point> area = k.threatArea(board);
    	assertTrue(area.contains(new Point(2, 2)));
    	assertTrue(area.contains(new Point(2, 3)));
    	assertTrue(area.contains(new Point(2, 4)));
    	assertTrue(area.contains(new Point(3, 2)));
    	assertTrue(area.contains(new Point(3, 4)));
    	assertTrue(area.contains(new Point(4, 2)));
    	assertTrue(area.contains(new Point(4, 3)));
    	assertTrue(area.contains(new Point(4, 4)));
    	
    	assertFalse(area.contains(new Point(1, 1)));
    	assertFalse(area.contains(new Point(1, 5)));
    	assertFalse(area.contains(new Point(3, 1)));
    	assertFalse(area.contains(new Point(3, 5)));
    	assertFalse(area.contains(new Point(5, 1)));
    	assertFalse(area.contains(new Point(5, 5)));
    }
}
