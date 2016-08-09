package chess.challenge.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess.challenge.Bishop;

public class BishopTest {

    /**
     * Test method for {@link chess.challenge.Bishop#getValidMoves()}.
     */
    @Test
    public void testGetValidMoves() {
        Bishop bishop = new Bishop(0, 0);
    	assertNotNull(bishop.getValidMoves());
    }

    /**
     * Test method for {@link chess.challenge.Bishop#Bishop(java.awt.Point, boolean)}.
     */
    @Test
    public void testBishop() {
    	Bishop bishop = new Bishop(0, 1);
        assertEquals(0, bishop.getRank());
        assertEquals(1, bishop.getFile());
        assertFalse(bishop.hasLimitedRange());
        assertTrue("B".equals(bishop.getSymbol()));
        assertTrue("Bb8".equals(bishop.toString()));
    }
}
