package szymczak.com.game.console;

public enum User {
    UserOne(Color.White), UserTwo(Color.Black);

    private Color color;
    User(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
