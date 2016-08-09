package chess.challenge.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import chess.challenge.Rock;


public class RockTest {

    @Test
    public void testGetValidMoves() {
        Rock rock = new Rock(0, 0);
    	assertNotNull(rock.getValidMoves());
    }

    @Test
    public void testRock() {
        Rock rock = new Rock(0, 1);
        assertEquals(0, rock.getRank());
        assertEquals(1, rock.getFile());
        assertFalse(rock.hasLimitedRange());
        assertTrue("R".equals(rock.getSymbol()));
        assertTrue("Rb8".equals(rock.toString()));
    }
}
