import java.util.Arrays;

public class ArrayIntersections {
    public static int[] intersecting2DigitArrays(int[] firstArray, int[] secondArray) {
        int[] allIntersectingNumbers = new int[firstArray.length];
        int[] arrayAfterIntersection ;
        int intersections = 0;
        int newArrayIndex = 0;
        for (int value : firstArray) {
            for (int valueOfSecondArray : secondArray)
                if (value == valueOfSecondArray) {
                    {
                        allIntersectingNumbers[newArrayIndex] = value;
                        newArrayIndex++;
                        intersections++;
                    }
                }
        }
       arrayAfterIntersection = new int[intersections];
       for (int i = 0; i < arrayAfterIntersection.length; i++) {
           arrayAfterIntersection[i] = allIntersectingNumbers[i];
       }
        return arrayAfterIntersection;

    }
    public  static boolean isStrangerArrays(int[]firstArray,int[] secondArray){
        int[]isIntersecting;
        isIntersecting=intersecting2DigitArrays(firstArray,secondArray);
        for (int value : isIntersecting) {
            if (value != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersecting2DigitArrays(new int[]{1,3,4}, new int[]{3,7})));
        System.out.println(isStrangerArrays(new int[]{1, 8,3, 5, 6,}, new int[]{4, 7,5,3, 4, 2}));
    }
}

