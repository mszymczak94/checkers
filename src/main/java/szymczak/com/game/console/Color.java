package szymczak.com.game.console;

public enum Color {
    White {
        @Override
        public char getMan() {
            return 'w';
        }

        @Override
        public char getKing() {
            return 'W';
        }
    }, Black {
        @Override
        public char getMan() {
            return 'b';
        }

        @Override
        public char getKing() {
            return 'B';
        }
    };

    public abstract char getMan();
    public abstract char getKing();
}
