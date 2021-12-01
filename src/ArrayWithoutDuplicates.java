import java.util.Arrays;

public class ArrayWithoutDuplicates {
    public static int[] unDuplicatedArray(int[] receivedArray) {
        int[] fixedArray = new int[receivedArray.length];
        int[] lastArray;
        int value = receivedArray[0];
        int temp;
        int count = 0;
        boolean flag = false;

        for (int i = 0; i < receivedArray.length; i++) {
            for (int j = i; j < receivedArray.length; j++) {
                if (receivedArray[i] > receivedArray[j]) {
                    temp = receivedArray[i];
                    receivedArray[i] = receivedArray[j];
                    receivedArray[j] = temp;
                }
            }
        }
        int j = 0;
        for (int numberInReceivedArray : receivedArray) {
            if (value == numberInReceivedArray)
                count++;
            if (value == numberInReceivedArray && !flag) {
                flag = true;

            } else if (value != numberInReceivedArray) {
                j++;
                fixedArray[j] = value;
                value = numberInReceivedArray;
                flag = false;
            }
            fixedArray[j] = value;

        }
        lastArray = new int[fixedArray.length - count ];
        int lastArrayIndex = 0;
        for (int i = 0; i < lastArray.length; i++) {
            if (fixedArray[i] > 0) {
                lastArray[lastArrayIndex] = fixedArray[i];
                lastArrayIndex++;
            }
        }
        return lastArray;

    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 3, 7, 7, 8, 9, 9, 9, 10};

        System.out.println(Arrays.toString(unDuplicatedArray(new int[]{2, 2, 3, 4, 1, 2, 1, 1})));
        System.out.println(Arrays.toString(unDuplicatedArray(new int[]{9, 7, 5, 4, 14,2,1, 3, 4, 6})));


    }
}
