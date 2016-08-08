package chess.challenge.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import chess.challenge.Rock;


public class RockTest {

    Rock rock = new Rock(new Point(0, 0));

    /**
     * Test method for {@link chess.challenge.Rock#getValidMoves()}.
     */
    @Test
    public void testGetValidMoves() {
        assertNotNull(rock.getValidMoves());
    }

    /**
     * Test method for {@link chess.challenge.Rock#Rock(java.awt.Point)}.
     */
    @Test
    public void testRock() {
        assertTrue(rock.getPosition().equals(new Point(0, 0)));
        assertFalse(rock.hasLimitedRange());
    }

    /**
     * Test method for {@link java.lang.Object#toString()}.
     */
    @Test
    public void testToString() {
        assertTrue("R".equals(rock.toString()));
    }

}
