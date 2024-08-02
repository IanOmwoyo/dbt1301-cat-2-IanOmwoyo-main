import java.util.Random;

public class SelectionSort {
    public static int[] generateRandomArray(int size){
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }
        return array;
    }
    public static void selectSort(int[] array){
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = generateRandomArray(100000);
        printArray(array);
        long startTime = System.currentTimeMillis();
        selectSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("After sorting: ");
        printArray(array);
        System.out.println("Sorting time taken: " + (endTime-startTime) + "ms");
    }
}
