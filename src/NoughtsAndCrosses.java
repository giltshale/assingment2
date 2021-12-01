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

        return board[Math.abs(location - 1)] != 'X' && board[Math.abs(location - 1)] != 'O';
    }

    public static char checkWinner(char[] board) {
        if (board[0] == 'X' && board[1] == 'X' && board[2] == 'X')
            return 'X';
        else if (board[0] == 'O' && board[1] == 'O' && board[2] == 'O')
            return 'O';

        else if (board[3] == 'X' && board[4] == 'X' && board[5] == 'X')
            return 'X';
        else if (board[3] == 'O' && board[4] == 'O' && board[5] == 'O')
            return 'O';


        else if (board[6] == 'X' && board[7] == 'X' && board[8] == 'X')
            return 'X';
        else if (board[6] == 'O' && board[7] == 'O' && board[8] == 'O')
            return 'O';


        else if (board[0] == 'X' && board[3] == 'X' && board[6] == 'X')
            return 'X';
        else if (board[0] == 'O' && board[3] == 'O' && board[6] == 'O')
            return 'O';

        else if (board[1] == 'X' && board[4] == 'X' && board[7] == 'X')
            return 'X';
        else if (board[1] == 'O' && board[4] == 'O' && board[7] == 'O')
            return 'O';

        else if (board[2] == 'X' && board[5] == 'X' && board[8] == 'X')
            return 'X';
        else if (board[2] == 'O' && board[5] == 'O' && board[8] == 'O')
            return 'O';

        else if (board[0] == 'X' && board[4] == 'X' && board[8] == 'X')
            return 'X';
        else if (board[0] == 'O' && board[4] == 'O' && board[8] == 'O')
            return 'O';

        else if (board[2] == 'X' && board[4] == 'X' && board[6] == 'X')
            return 'X';
        else if (board[2] == 'O' && board[4] == 'O' && board[6] == 'O')
            return 'O';
        return '-';
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
            } else {
                if (!isAvailable(board, userChoosePosition)) {
                    System.out.println("this position is occupied");
                } else
                    flag = false;
            }
            return userChoosePosition;
        } while (isAvailable(board, userChoosePosition) && flag);
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
        boolean player1 = true;
        boolean gameOver = false;

        while (!gameOver && !boardIsFull(board)) {

            if (placeSymbolOnBoard(board, getPositionFromUser(board), symbol)) {
                System.out.println("player " + checkWinner(board) + " has won");
                gameOver = true;
            } else if (player1) {
                if (symbol == 'X') {
                    symbol = 'O';
                } else {
                    symbol = 'X';
                    player1 = false;
                }

            } else if (boardIsFull(board)) {
                System.out.println("it's draw, start a new game");
            }

        }

    }

}
