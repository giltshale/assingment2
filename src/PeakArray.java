public class PeakArray {
    public static int isArrayUpAndDown(int[] array) {
        int arrayEnd = array.length - 1;
        int starIndex = 0;
        int middleIndex;
        if (array.length == 1||array.length == 0)
            return 0;
        while (starIndex < arrayEnd) {

            middleIndex = (starIndex + arrayEnd) / 2;
            if ((array[middleIndex + 1] < array[middleIndex]) && (array[middleIndex] > array[middleIndex - 1]))
                return middleIndex;
            if (array[middleIndex] > array[middleIndex - 1]) {
                starIndex = middleIndex + 1;
            } else if (array[middleIndex] < array[middleIndex - 1])
                arrayEnd = middleIndex - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,5,6,8,4,3,2,1};
        System.out.println(isArrayUpAndDown(a));
    }
}
