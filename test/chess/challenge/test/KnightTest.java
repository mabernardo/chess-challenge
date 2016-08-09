package chess.challenge.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import chess.challenge.Knight;

public class KnightTest {

    @Test
    public void testGetValidMoves() {
    	Knight knight = new Knight(0, 1);
        assertNotNull(knight.getValidMoves());
    }

    @Test
    public void testKnight() {
        Knight knight = new Knight(0, 1);
        assertEquals(0, knight.getRank());
        assertEquals(1, knight.getFile());
        assertTrue(knight.hasLimitedRange());
        assertTrue("N".equals(knight.getSymbol()));
        assertTrue("Nb8".equals(knight.toString()));
    }

}
