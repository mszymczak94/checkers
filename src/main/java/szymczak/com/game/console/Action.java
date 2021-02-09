package szymczak.com.game.console;

import lombok.Data;

@Data
public class Action {
    private final User user;
    public Validator validateMove() {
        return null;
    }

    public boolean isMoveValid() {
        return false;
    }

    public boolean isGameOver() {
        return false;
    }

    public User nextUser() {
        return user == User.UserOne ? User.UserTwo : User.UserOne;
    }
}
