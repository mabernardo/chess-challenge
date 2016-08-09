package chess.challenge.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
        assertTrue("K".equals(king.getSymbol()));
        assertTrue("Kb8".equals(king.toString()));
    }
}
