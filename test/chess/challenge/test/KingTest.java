package chess.challenge.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import chess.challenge.King;

public class KingTest {

    King king = new King(new Point(0, 0));

    @Test
    public void testGetValidMoves() {
        assertNotNull(king.getValidMoves());
    }

    @Test
    public void testKing() {
        assertTrue(king.getPosition().equals(new Point(0, 0)));
        assertTrue(king.hasLimitedRange());
    }

    @Test
    public void testToString() {
        assertTrue("K".equals(king.toString()));
    }

}
