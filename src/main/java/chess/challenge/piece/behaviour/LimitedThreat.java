package chess.challenge.piece.behaviour;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import chess.challenge.ChessBoard;

/**
 * Interface defining the default behaviour of piece with limited threat area.
 * 
 * @author mbernardo
 * @since 3.0
 */

public interface LimitedThreat extends Threat {

    /*
     * (non-Javadoc)
     * 
     * @see chess.challenge.Threat#threatArea(chess.challenge.ChessBoard)
     */
    @Override
    public default List<Point> threatArea(ChessBoard board) {
        List<Point> threats = new ArrayList<>();
        Point p = new Point(this.getRank(), this.getFile());

        this.getValidMoves().forEach(p1 -> {
            int x1 = p.x + p1.x;
            int y1 = p.y + p1.y;
            if ((x1 >= 0 && x1 < board.getRanks()) && (y1 >= 0 && y1 < board.getFiles())) {
                threats.add(new Point(x1, y1));
            }
        });
        return threats;
    }

}
