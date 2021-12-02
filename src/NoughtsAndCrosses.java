import java.util.Scanner;

public class NoughtsAndCrosses {
    public static final int JUMP_ROW = 3;
    public static final int EDGE_LIMIT = 2;

    public static void printBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i]);
            System.out.print(" | ");
            if (i % JUMP_ROW == EDGE_LIMIT) {
                System.out.print("\n");
            }
        }
    }

    public static boolean isAvailable(char[] board, int location) {
        if (1 > location || location > 9)
            return false;
        else
            return board[Math.abs(location - 1)] != 'X' && board[Math.abs(location - 1)] != 'O';
    }

    public static char checkWinner(char[] board) {
        char drawOrBoardIsFull = ' ';
        for (int i = 0; i < JUMP_ROW; i += JUMP_ROW) {
            if (board[i] == board[i + 1] && board[i] == board[i + 2])
                return board[i];
        }
        for (int i = 0; i < JUMP_ROW; i++) {
            if (board[i] == board[i + JUMP_ROW] && board[i] == board[i + 2 * JUMP_ROW])
                return board[i];
        }
        if (boardIsFull(board)) {
            drawOrBoardIsFull = '-';
            return drawOrBoardIsFull;
        }
        if (board[0] == board[4] && board[4] == board[8])
            return board[4];
        else if (board[2] == board[4] && board[4] == board[6])
            return board[4];

        return drawOrBoardIsFull;
    }

    public static boolean boardIsFull(char[] board) {
        int count = 0;
        for (char charOnBoard : board) {
            if (charOnBoard != '-') {
                count++;
            }
        }
        return count > 8;
    }

    public static int getPositionFromUser(char[] board) {
        int userChoosePosition;
        boolean flag = true;
        do {
            System.out.println("Please enter number between 1-9 to mark your symbol: ");
            Scanner scanner = new Scanner(System.in);
            userChoosePosition = scanner.nextInt();
            if (1 > userChoosePosition || userChoosePosition > 9) {
                System.out.println("your number is wrong, please try again : ");
                continue;
            } else if (!isAvailable(board, userChoosePosition)) {
                System.out.println("this position is occupied");
                continue;
            } else {
                flag = false;
            }
            return userChoosePosition;

        } while (isAvailable(board, userChoosePosition) || flag);

        return userChoosePosition;
    }

    public static boolean placeSymbolOnBoard(char[] board, int position, char whichPlayer) {

        switch (position) {
            case 1:
                board[0] = whichPlayer;

                break;
            case 2:
                board[1] = whichPlayer;
                break;
            case 3:
                board[2] = whichPlayer;
                break;
            case 4:
                board[3] = whichPlayer;
                break;
            case 5:
                board[4] = whichPlayer;
                break;
            case 6:
                board[5] = whichPlayer;
                break;
            case 7:
                board[6] = whichPlayer;
                break;
            case 8:
                board[7] = whichPlayer;
                break;
            case 9:
                board[8] = whichPlayer;
                break;
            default:
                break;
        }
        printBoard(board);
        return checkWinner(board) == 'X' || checkWinner(board) == 'O';
    }

    public static void main(String[] args) {
        char symbol = 'X';
        char[] board = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
        boolean gameOver = false;

        while (!gameOver && !boardIsFull(board)) {
            if (!placeSymbolOnBoard(board, getPositionFromUser(board), symbol)) {
                if (boardIsFull(board)) {
                    System.out.println("-");
                }
                if (symbol == 'X') {
                    symbol = 'O';
                } else {
                    symbol = 'X';
                }
            } else {
                System.out.println("player " + checkWinner(board) + " has won");
                gameOver = true;
            }
        }
    }
}
