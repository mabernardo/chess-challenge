package chess.challenge.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import chess.challenge.Queen;

public class QueenTest {

    @Test
    public void testGetValidMoves() {
        Queen queen = new Queen(0, 0);
        assertNotNull(queen.getValidMoves());
    }

    @Test
    public void testQueen() {
        Queen queen = new Queen(0, 1);
        assertEquals(0, queen.getRank());
        assertEquals(1, queen.getFile());
        assertFalse(queen.hasLimitedRange());
        assertTrue("Q".equals(queen.getSymbol()));
        assertTrue("Qb8".equals(queen.toString()));
    }
}
