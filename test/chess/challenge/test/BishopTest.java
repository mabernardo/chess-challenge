package chess.challenge.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.awt.Point;

import org.junit.Test;

import chess.challenge.Bishop;

public class BishopTest {

    Bishop bishop = new Bishop(new Point(0, 0));
    /**
     * Test method for {@link chess.challenge.Bishop#getValidMoves()}.
     */
    @Test
    public void testGetValidMoves() {
        assertNotNull(bishop.getValidMoves());
    }

    /**
     * Test method for {@link chess.challenge.Bishop#Bishop(java.awt.Point, boolean)}.
     */
    @Test
    public void testBishop() {
        assertTrue(bishop.getPosition().equals(new Point(0, 0)));
        assertFalse(bishop.hasLimitedRange());
    }

    /**
     * Test method for {@link chess.challenge.Bishop#toString()}.
     */
    @Test
    public void testToString() {
        assertTrue("B".equals(bishop.toString()));
    }

}
