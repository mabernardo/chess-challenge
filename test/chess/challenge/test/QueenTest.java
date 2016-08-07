package chess.challenge.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.awt.Point;

import org.junit.Test;

import chess.challenge.Queen;

public class QueenTest {

    Queen queen = new Queen(new Point(0, 0));
    /**
     * Test method for {@link chess.challenge.Queen#getValidMoves()}.
     */
    @Test
    public void testGetValidMoves() {
        assertNotNull(queen.getValidMoves());
    }

    /**
     * Test method for {@link chess.challenge.Queen#Queen(java.awt.Point)}.
     */
    @Test
    public void testQueen() {
        assertTrue(queen.getPosition().equals(new Point(0, 0)));
        assertFalse(queen.hasLimitedRange());
    }

    /**
     * Test method for {@link java.lang.Object#toString()}.
     */
    @Test
    public void testToString() {
        assertTrue("Q".equals(queen.toString()));
    }

}
