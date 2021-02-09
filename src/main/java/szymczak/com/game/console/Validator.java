package szymczak.com.game.console;

import szymczak.com.gui.Gui;
import szymczak.com.gui.GuiWrapper;

public class Validator {
    private final Gui gui;
    private final GuiWrapper guiWrapper;

    public Validator(Gui gui) {
        this.gui = gui;
        this.guiWrapper = new GuiWrapper(gui);
    }

    public boolean isGameOver() {
        return false;
    }

    public boolean isMoveValid(Action action) {
        if (action == null) {
            return false;
        }
        return true;
    }

    public boolean isUserPiece(User user, Pawn pawn) {
        if (pawn == null) {
            gui.customMessage("This is incorrect input - there isn't any pawn or you have written too small or to big number");
            return false;
        }
        return guiWrapper.isUserPiece(user.getColor() == pawn.getColor(), user.getColor());
    }
}
