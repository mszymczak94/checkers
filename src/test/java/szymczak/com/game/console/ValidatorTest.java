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
                .assertFalse(validator.isUserPiece(User.UserTwo, new Pawn('w', -1)));
        Assertions.
                assertFalse(validator.isUserPiece(User.UserOne, new Pawn('b', -1)));
    }

    @Test
    public void isUserPiece_ShouldReturnTrueWhenUserIsAPawnOwner() {
        Assertions
                .assertTrue(validator.isUserPiece(User.UserOne, new Pawn('w', -1)));
        Assertions.
                assertTrue(validator.isUserPiece(User.UserTwo, new Pawn('b', -1)));
    }

    @Test
    public void isMoveValid_ShouldReturnFalseWhenActionIsNull() {
        Assertions.assertFalse(validator.isMoveValid(null));
    }

    @Test
    public void isInputMoveValid_ShouldReturnFalseWhenInputIsNullOrEmpty() {
       Assertions.assertFalse(validator.isInputMoveValid(null));
       Assertions.assertFalse(validator.isInputMoveValid(""));
    }

    @Test
    public void isInputMoveValid_ShouldReturnFalseWhenInputIsIncorrect() {
        Assertions.assertFalse(validator.isInputMoveValid("Incorrect"));
        Assertions.assertFalse(validator.isInputMoveValid("12.14.16.18"));
        Assertions.assertFalse(validator.isInputMoveValid("12,14?16*18"));
        Assertions.assertFalse(validator.isInputMoveValid("-1"));
        Assertions.assertFalse(validator.isInputMoveValid("1,2,3,4,5, "));
        Assertions.assertFalse(validator.isInputMoveValid("1,2,asd,4,5"));
        Assertions.assertFalse(validator.isInputMoveValid("1,2,,4,5"));
    }

    @Test
    public void isInputMoveValid_ShouldReturnTrueWhenInputIsCorrect() {
        Assertions.assertTrue(validator.isInputMoveValid("2"));
        Assertions.assertTrue(validator.isInputMoveValid("2,4,5,6,7,8"));
        Assertions.assertTrue(validator.isInputMoveValid("2,4,5,6,7,8,"));
    }
}
