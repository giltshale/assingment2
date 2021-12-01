import java.util.Scanner;

public class PrintBiggerThenAverage {

    public static void biggerNumbersPrint() {
        double average;
        double sum = 0;
        double[] userNumbersInput = new double[10];
        System.out.print("please enter 10 numbers");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < userNumbersInput.length; i++) {
            userNumbersInput[i] = scanner.nextDouble();
        }
        for (double j : userNumbersInput) {
            sum += j;
        }
        average = sum / userNumbersInput.length;
        System.out.println("the average is " + average + "  here are the numbers that is bigger then average: ");

        for (double i : userNumbersInput) {
            if (i > average) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        biggerNumbersPrint();
    }

}
