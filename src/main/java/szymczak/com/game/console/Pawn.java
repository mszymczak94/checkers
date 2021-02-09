package szymczak.com.game.console;

import lombok.Data;

@Data
public class Pawn {
    private final Color color;
    private final char pawn;

    public Pawn (char pawnAsChar) {
        this.color = Color.getColorFromChar(pawnAsChar);
        this.pawn = pawnAsChar;
    }
}
