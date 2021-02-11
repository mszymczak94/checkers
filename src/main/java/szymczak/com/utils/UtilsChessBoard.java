package szymczak.com.utils;

import lombok.Data;
import szymczak.com.game.console.Color;
import szymczak.com.game.console.Pawn;

import java.util.Arrays;
import java.util.List;

public class UtilsChessBoard {
    public static final byte BOARD_GAME_LENGTH = 8;
    private static final byte[] BLACK_MAN_POSITIONS = {
            1, 3, 5, 7, 8, 10, 12, 14, 17, 19, 21, 23
    };
    private static final byte[] WHITE_MAN_POSITIONS = {
            40, 42, 44, 46, 49, 51, 53, 55, 56, 58, 60, 62
    };

    private static final List<Integer> VALID_POSITIONS = Arrays.asList(
            1, 3, 5, 7,
            8, 10, 12, 14,
            17, 19, 21, 23,
            24, 26, 28, 30,
            33, 35, 37, 39,
            40, 42, 44, 46,
            49, 51, 53, 55,
            56, 58, 60, 62
    );


    public static char[][] initBoardGame() {
        char[][] board = new char[BOARD_GAME_LENGTH][BOARD_GAME_LENGTH];
        fillBoardGame(board, BLACK_MAN_POSITIONS, Color.Black);
        fillBoardGame(board, WHITE_MAN_POSITIONS, Color.White);
        return board;
    }

    private static void fillBoardGame(char[][] board, byte[] manPositions, Color color) {
        for (byte manPosition : manPositions) {
            Coordinate coordinate = new Coordinate(manPosition);
            board[coordinate.row][coordinate.col] = color.getMan();
        }
    }

    public static String getBoardToString(char[][] boardGame) {
        StringBuilder builder = new StringBuilder();
        int position = 0;
        for (char[] row : boardGame) {
            for (char pos : row) {
                builder.append(String.format("%3s|", ""));
                if (pos == 0) {
                    builder.append(String.format("%5s", position));
                } else {
                    builder.append(String.format("%5s", pos));
                }
                position++;
            }
            builder.append(String.format("%3s|%n", ""));
        }
        return builder.toString();
    }

    public static Pawn getPiece(int position, char[][] boardGame) {
        if (!VALID_POSITIONS.contains(position)) {
            return null;
        }
        Coordinate coordinate = new Coordinate(position);
        char pawn = boardGame[coordinate.row][coordinate.col];
        return pawn != 0 ? new Pawn(pawn, position) : null;
    }

    public static char[][] copyBoard(char[][] boardGame) {
        char[][] copy = new char[boardGame.length][];
        for (int i = 0; i < boardGame.length; i++) {
            char[] chars = boardGame[i];
            copy[i] = new char[boardGame[i].length];
            System.arraycopy(boardGame[i], 0, copy[i], 0, copy[i].length);
        }
        return copy;
    }

    @Data
    private static class Coordinate {
        private final int row;
        private final int col;

        public Coordinate(int position) {
            this.row = position / BOARD_GAME_LENGTH;
            this.col = position % BOARD_GAME_LENGTH;
        }
    }
}
