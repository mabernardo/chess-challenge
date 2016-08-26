package chess.challenge.piece.behaviour;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import chess.challenge.ChessBoard;

/**
 * Interface defining the default behaviour of piece with unlimited threat area.
 * @author mbernardo
 * @since 3.0
 */
public interface UnlimitedThreat extends Threat {

    /*
     * (non-Javadoc)
     * @see chess.challenge.Threat#threatArea(chess.challenge.ChessBoard)
     */
    @Override
    public default List<Point> threatArea(ChessBoard board) {
        List<Point> threats = new ArrayList<>();
        Point p = new Point(this.getRank(), this.getFile());

        for (Point p1 : this.getValidMoves()) {
            int x1 = p.x + p1.x;
            int y1 = p.y + p1.y;
            int distance = 1;
            while ((x1 >= 0 && x1 < board.getRanks()) && (y1 >= 0 && y1 < board.getFiles())) {
                threats.add(new Point(x1, y1));
                distance++;
                x1 = p.x + p1.x * distance;
                y1 = p.y + p1.y * distance;
            }
        }
        return threats;
    }

}
