package chess.challenge.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import chess.challenge.Knight;

public class KnightTest {

    Knight knight = new Knight(new Point(0, 0));

    /**
     * Test method for {@link chess.challenge.Knight#getValidMoves()}.
     */
    @Test
    public void testGetValidMoves() {
        assertNotNull(knight.getValidMoves());
    }

    /**
     * Test method for {@link chess.challenge.Knight#Knight(java.awt.Point)}.
     */
    @Test
    public void testKnight() {
        assertTrue(knight.getPosition().equals(new Point(0, 0)));
        assertTrue(knight.hasLimitedRange());
    }

    /**
     * Test method for {@link java.lang.Object#toString()}.
     */
    @Test
    public void testToString() {
        assertTrue("N".equals(knight.toString()));
    }

}
