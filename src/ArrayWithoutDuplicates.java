import java.util.Arrays;

public class ArrayWithoutDuplicates {
    public static int[] unDuplicatedArray(int[] receivedArray) {
        int[] fixedArray = new int[receivedArray.length];
        int[] lastArray;
        int value = receivedArray[0];
        int temp;
        int count = 0;
        boolean foundMatch = false;

        for (int i = 0; i < receivedArray.length; i++) {
            for (int j = i; j < receivedArray.length; j++) {
                if (receivedArray[i] > receivedArray[j]) {
                    temp = receivedArray[i];
                    receivedArray[i] = receivedArray[j];
                    receivedArray[j] = temp;
                }
            }
        }
        for (int i = 0; i < receivedArray.length; i++) {
            for (int j = i + 1; j < receivedArray.length; j++) {
                if (receivedArray[i] == receivedArray[j])
                    count++;
                break;
            }
        }
        int j = 0;
        for (int numberInReceivedArray : receivedArray) {
            if (value == numberInReceivedArray && !foundMatch) {
                foundMatch = true;
            }
            if (value != numberInReceivedArray) {
                j++;
                fixedArray[j] = value;
                value = numberInReceivedArray;
                foundMatch = false;
            }
            fixedArray[j] = value;

        }
        lastArray = new int[fixedArray.length - count];
        int lastArrayIndex = 0;
        for (int i = 0; i <= lastArray.length; i++) {
            if (fixedArray[i] > 0) {
                lastArray[lastArrayIndex] = fixedArray[i];
                lastArrayIndex++;
            }
        }
        return lastArray;

    }

    public static void main(String[] args) {
       // int[] input = new int[]{1, 1, 3, 7, 7, 8, 9, 9, 9, 10};
       // System.out.println(Arrays.toString(unDuplicatedArray(new int[]{1, 2, 3, 2, 2, 2, 1, 4, 5})));
       // System.out.println(Arrays.toString(unDuplicatedArray(new int[]{9, 7, 5, 4, 14, 2, 1, 3, 4, 6})));

    }
}
