package chess.challenge;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mbernardo
 * @since 3.0
 */
public enum PieceType {
    NONE(0, "."), KING(1, "K"), QUEEN(2, "Q"), BISHOP(3, "B"), ROCK(4, "R"), KNIGHT(5, "N");

    private final int code;
    private final String symbol;
    private static final Map<Integer, PieceType> codeMap = new HashMap<>();

    static {
        for (PieceType pt : EnumSet.allOf(PieceType.class)) {
            codeMap.put(pt.code, pt);
        }
    }
    PieceType(int code, String symbol) {
        this.code = code;
        this.symbol = symbol;
    }

    /**
     * Returns the PieceType with the code passed as parameter.
     * 
     * @param code Piece code.
     * @return PieceType ith the given code.
     */
    public static PieceType get(int code) {
        return codeMap.get(code);
    }
    /**
     * Returns the piece code.
     * 
     * @return piece code.
     */
    public int code() {
        return code;
    }

    /**
     * Returns the symbol of the piece.
     * 
     * @return String representing the piece.
     */
    public String symbol() {
        return symbol;
    }
}
