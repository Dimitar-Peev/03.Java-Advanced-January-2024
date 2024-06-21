package _14_Exams._06_JavaAdvancedRegularExam_18February2023;

import java.util.Arrays;
import java.util.Scanner;

public class _02_BlindMansBuff {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        char[][] field = new char[numbers[0]][numbers[1]];

        int myRow = -1;
        int myCol = -1;

        for (int row = 0; row < field.length; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < field[row].length; col++) {
                field[row][col] = input[col].charAt(0);

                if (field[row][col] == 'B') {
                    myRow = row;
                    myCol = col;
                }
            }
        }
//----------------------------------------------------------------------------------------------------------------------
        byte opponents = 0;
        byte moves = 0;

        String input = scanner.nextLine();
        while (!"Finish".equals(input)){
            int oldRow = myRow;
            int oldCol = myCol;

            field[myRow][myCol] = '-';
            switch (input) {
                case "up": myRow--; break;
                case "down": myRow++; break;
                case "left": myCol--; break;
                case "right": myCol++; break;
            }

            if (isOutOfBounds(myRow, myCol, field)) {
                myRow = oldRow;
                myCol = oldCol;
                moves--;
            }

            if (field[myRow][myCol] == 'P'){
                opponents++;
                moves++;

                if (opponents == 3){
                    break;
                }
            } else if (field[myRow][myCol] == 'O') {
                myRow = oldRow;
                myCol = oldCol;
            } else if (field[myRow][myCol] == '-') {
                moves++;
            }

            field[myRow][myCol] = 'B';
            input = scanner.nextLine();
        }

        System.out.printf("Game over!%nTouched opponents: %d Moves made: %d", opponents, moves);
    }

    private static boolean isOutOfBounds(int row, int col, char[][] field) {
        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }
}
