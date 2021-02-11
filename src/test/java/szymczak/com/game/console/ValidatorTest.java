package szymczak.com.game.console;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import szymczak.com.gui.ConsoleGui;

public class ValidatorTest {
    private static Validator validator;

    @BeforeAll
    static void init(){
        validator = new Validator(new ConsoleGui());
    }

    @Test
    public void isUserPiece_ShouldReturnFalseWhenPawnIsNull() {
        Assertions.assertFalse(validator.isUserPiece(null, null));
    }

    @Test
    public void isUserPiece_ShouldReturnFalseWhenUserIsNotAPawnOwner() {
        Assertions
                .assertFalse(validator.isUserPiece(User.UserTwo, new Pawn('w')));
        Assertions.
                assertFalse(validator.isUserPiece(User.UserOne, new Pawn('b')));
    }

    @Test
    public void isUserPiece_ShouldReturnTrueWhenUserIsAPawnOwner() {
        Assertions
                .assertTrue(validator.isUserPiece(User.UserOne, new Pawn('w')));
        Assertions.
                assertTrue(validator.isUserPiece(User.UserTwo, new Pawn('b')));
    }

    @Test
    public void isMoveValid_ShouldReturnFalseWhenActionIsNull() {
        Assertions.assertFalse(validator.isMoveValid(null));
    }
}
