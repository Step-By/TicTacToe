import java.util.Scanner;

public class TicTacToe {
    public static final int WIN_1 = 1;
    public static final int WIN_2 = 2;
    public static final int DRAW = 3;
    public static final int CONTINUE = 0;
    public static final char PLAYER_1 = '-';
    public static final char PLAYER_2 = '+';
    public static final char EMTY = '@';

    public static void main(String[] args) {
        char[][] gameField = {{EMTY, EMTY, EMTY}, {EMTY, EMTY, EMTY}, {EMTY, EMTY, EMTY}};
        int result;
        char symbol = PLAYER_1;
        showGameField(gameField);
        do {
            makeMove(gameField, symbol);
            symbol = symbol == PLAYER_1 ? PLAYER_2 : PLAYER_1;
            showGameField(gameField);
            result = chekField(gameField);
        } while (result == CONTINUE );
        showResult(result);
    }

    public static void showGameField(char[][] gameField) {
        System.out.println(gameField[0][0] + "|" + gameField[0][1] + "|" + gameField[0][2]);
        System.out.println("-----");
        System.out.println(gameField[1][0] + "|" + gameField[1][1] + "|" + gameField[1][2]);
        System.out.println("-----");
        System.out.println(gameField[2][0] + "|" + gameField[2][1] + "|" + gameField[2][2]);
    }

    public static void makeMove(char[][] gameField, char symbol) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сейчас ходит =" + symbol);
        int n, m, number;

        do {
            number = scanner.nextInt();
            n = 2 - (number - 1) / 3;
            m = 2 - (number - 1) % 3;
        } while (number < 1 || number > 9 || gameField[n][m] != EMTY);
        gameField[n][m] = symbol;
    }

    public static int chekField(char[][] gameField) {
        int result = 0;

        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == gameField[i][1]
                    && gameField[i][0] == gameField[i][2]) {
                if (gameField[i][0] == PLAYER_1) return WIN_1;
                if (gameField[i][0] == 'o') return WIN_2;
            }
            if (gameField[0][i] == gameField[1][i]
                    && gameField[0][i] == gameField[2][i]) {
                if (gameField[0][i] == PLAYER_1) return WIN_1;
                if (gameField[0][i] == 'o') return WIN_2;
            }
        }
        if (gameField[0][0] == gameField[1][1]
                && gameField[0][0] == gameField[2][2]) {
            if (gameField[0][0] == PLAYER_1) return WIN_1;
            if (gameField[0][0] == 'o') return WIN_2;
        }
        if (gameField[2][0] == gameField[1][1]
                && gameField[2][0] == gameField[0][2]) {
            if (gameField[2][0] == PLAYER_1) return WIN_1;
            if (gameField[2][0] == 'o') return WIN_2;
        }
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if (gameField[i][j] == EMTY) return CONTINUE;
            }
            return DRAW;
        }

        return result;
    }

    public static void showResult(int result) {
        switch (result) {
            case WIN_1:
                System.out.println("Победа"+PLAYER_1);
                break;
            case WIN_2:
                System.out.println("Победа"+PLAYER_2);
                break;
            case  DRAW:
                System.out.println("\n" + "Draw");
        }
    }

}
