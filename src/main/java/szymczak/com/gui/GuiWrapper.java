package szymczak.com.gui;

import lombok.RequiredArgsConstructor;
import szymczak.com.game.console.Color;

@RequiredArgsConstructor
public class GuiWrapper {
    private final Gui gui;

    public boolean isUserPiece(boolean isUserPiece, Color color) {
        if (!isUserPiece) {
            gui.displayMessage("This is not your pawn, please choose one of " + color + " pawns");
        }
        return isUserPiece;
    }
}
