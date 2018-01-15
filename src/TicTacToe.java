import java.util.Scanner;
import java.util.Scanner;
/**
 * Created by st on 15.01.2018.
 */
public class TicTacToe {



        public static void main(String[] args) {
            char[][] gameField = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
            int result;
            char symbol = 'X';
            showGameField(gameField);
            do {
                makeMove(gameField, symbol);
                symbol = symbol == 'X' ? '0' : 'X';
                showGameField(gameField);
                result = chek(gameField);
            } while (result == 0);
            switch (result) {
                case 1:
                    System.out.println("Win X");
                    break;
                case 2:
                    System.out.println("Win O");
                    break;
                case 3:
                    System.out.println("\n" + "Draw");
            }
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
            } while (number < 1 || number > 9 || gameField[n][m] != ' ');
            gameField[n][m] = symbol;
        }

        public static int chek(char[][] gameField) {
            int result = 0;

            for (int i = 0; i < 3; i++) {
                if (gameField[i][0] == gameField[i][1]
                        && gameField[i][0] == gameField[i][2]) {
                    if (gameField[i][0] == 'x') return 1;
                    if (gameField[i][0] == 'o') return 2;
                }
                if (gameField[0][i] == gameField[1][i]
                        && gameField[0][i] == gameField[2][i]) {
                    if (gameField[0][i] == 'x') return 1;
                    if (gameField[0][i] == 'o') return 2;
                }
            }
            if (gameField[0][0] == gameField[1][1]
                    && gameField[0][0] == gameField[2][2]) {
                if (gameField[0][0] == 'x') return 1;
                if (gameField[0][0] == 'o') return 2;
            }
            if (gameField[2][0] == gameField[1][1]
                    && gameField[2][0] == gameField[0][2]) {
                if (gameField[2][0] == 'x') return 1;
                if (gameField[2][0] == 'o') return 2;
            }
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 3; i++) {
                    if (gameField[i][j] == ' ') return 0;
                }
                return 3;
            }

            return result;
        }

    }
