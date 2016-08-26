package chess.challenge.piece.bahaviour;

import java.awt.Point;
import java.util.List;

import chess.challenge.ChessBoard;

/**
 * Base interface of a Threat behaviour.
 * 
 * @author mbernardo
 * @since 3.0
 */
public interface Threat {

    /**
     * Gets the rank where the piece is in.
     * 
     * @return rank of the piece
     */
    int getRank();

    /**
     * Gets the file where the piece is in.
     * 
     * @return file of the piece
     */
    int getFile();

    /**
     * Gets the list of valid moves of the piece.
     * 
     * @return List of valid moves.
     */
    List<Point> getValidMoves();

    /**
     * Returns a list of coordinates that the piece threatens.
     * 
     * @param board
     *            the board where the threat area will be tested
     * @return list of coordinates that the piece threatens.
     */
    List<Point> threatArea(ChessBoard board);

}
