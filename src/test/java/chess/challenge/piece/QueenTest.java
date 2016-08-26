package chess.challenge.piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.List;

import org.junit.Test;

import chess.challenge.ChessBoard;
import chess.challenge.piece.PieceType;
import chess.challenge.piece.Queen;
import chess.challenge.piece.behaviour.UnlimitedThreat;

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
        assertTrue(queen instanceof UnlimitedThreat);
        assertEquals(PieceType.QUEEN, queen.getType());
        assertTrue("Q".equals(queen.getType().symbol()));
        assertTrue("Qb8".equals(queen.toString()));
    }

    @Test
    public void testThreatArea() {
        ChessBoard board = new ChessBoard(7, 7);
        Queen q = new Queen(3, 3);
        List<Point> area = q.threatArea(board);
        assertTrue(area.contains(new Point(0, 0)));
        assertTrue(area.contains(new Point(1, 1)));
        assertTrue(area.contains(new Point(2, 2)));
        assertTrue(area.contains(new Point(2, 4)));
        assertTrue(area.contains(new Point(1, 5)));
        assertTrue(area.contains(new Point(0, 6)));
        assertTrue(area.contains(new Point(4, 2)));
        assertTrue(area.contains(new Point(5, 1)));
        assertTrue(area.contains(new Point(6, 0)));
        assertTrue(area.contains(new Point(4, 4)));
        assertTrue(area.contains(new Point(5, 5)));
        assertTrue(area.contains(new Point(6, 6)));
        assertTrue(area.contains(new Point(0, 3)));
        assertTrue(area.contains(new Point(1, 3)));
        assertTrue(area.contains(new Point(2, 3)));
        assertTrue(area.contains(new Point(3, 0)));
        assertTrue(area.contains(new Point(3, 1)));
        assertTrue(area.contains(new Point(3, 2)));
        assertTrue(area.contains(new Point(4, 3)));
        assertTrue(area.contains(new Point(5, 3)));
        assertTrue(area.contains(new Point(6, 3)));
        assertTrue(area.contains(new Point(3, 4)));
        assertTrue(area.contains(new Point(3, 5)));
        assertTrue(area.contains(new Point(3, 6)));

        assertFalse(area.contains(new Point(1, 2)));
        assertFalse(area.contains(new Point(1, 4)));
        assertFalse(area.contains(new Point(2, 5)));
        assertFalse(area.contains(new Point(4, 5)));
        assertFalse(area.contains(new Point(5, 4)));
        assertFalse(area.contains(new Point(5, 2)));
        assertFalse(area.contains(new Point(4, 1)));
        assertFalse(area.contains(new Point(2, 1)));
    }

}
