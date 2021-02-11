package szymczak.com.game.console;

import lombok.Data;

@Data
public class Pawn {
    private final Color color;
    private final char pawn;
    private final int position;

    public Pawn (char pawnAsChar, int position) {
        this.color = Color.getColorFromChar(pawnAsChar);
        this.pawn = pawnAsChar;
        this.position = position;
    }
}
