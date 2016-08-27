package chess.challenge.piece;

import chess.challenge.piece.behaviour.Threat;

/**
 * Abstract representation of a chess piece.
 * 
 * @author mabernardo
 * @version 1.0
 * @since 1.0
 */
public abstract class ChessPiece implements Threat {
    private final int rank;
    private final int file;

    /**
     * Protected constructor defining the initial piece position and whether the
     * piece has a limited range or not.
     * 
     * @param position
     *            Initial piece position.
     * @param limitedRange
     *            Sets if the piece has a limited range.
     */
    protected ChessPiece(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    /**
     * Gets the piece type.
     * 
     * @return PieceType.
     */
    public abstract PieceType getType();

    /**
     * Creates a new instance of the specified piece type.
     * 
     * @param type
     *            symbol of the piece to be created.
     * @param rank
     *            rank where the piece will be placed.
     * @param file
     *            file where the piece will be placed.
     * @return a new instance of the piece.
     */
    public static ChessPiece newFromType(PieceType type, int rank, int file) {
        ChessPiece cp;
        switch (type) {
        case KING:
            cp = new King(rank, file);
            break;
        case QUEEN:
            cp = new Queen(rank, file);
            break;
        case ROCK:
            cp = new Rock(rank, file);
            break;
        case KNIGHT:
            cp = new Knight(rank, file);
            break;
        case BISHOP:
            cp = new Bishop(rank, file);
            break;
        default:
            return null;
        }
        return cp;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public int getFile() {
        return file;
    }

    /**
     * Prints out the piece coordinates in algebraic notation. 
     */
    @Override
    public String toString() {
        final int asciiCodeA = 97;
        final int standardBoardSize = 8;
        StringBuilder sb = new StringBuilder();
        sb.append(this.getType().symbol());
        sb.append(Character.toString((char) (asciiCodeA + file)));
        sb.append(String.valueOf(rank + Math.abs(rank - standardBoardSize)));

        return sb.toString();
    }
}
