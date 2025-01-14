import java.util.Random;
public class MergeSort {
    public static int[] generateRandomArray(){
        int[] arr = new int[100000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }
    public static int[] mergeSort(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = new int[mid];
        int[] right = new int[arr.length-mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length-mid);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
    public static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        int i = 0, j = 0, k = 0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                result[k++] = left[i++];
        }else{
            result[k++] = right[j++];
        }
    }
    while (i<left.length) {
        result[k++] = left[i++];
    }
    while (j<right.length) {
        result[k++] = right[j++];
    }
    return result;
}
public static void main(String[] args) {
    int[] arr = generateRandomArray();
    long startTime = System.currentTimeMillis();
    int[] sortedArr = mergeSort(arr);
    long endTime = System.currentTimeMillis();
    System.out.println("Sorted array took " + (endTime - startTime) + " ms");
    System.out.println("All 100k elements of the sorted array");
    for (int i = 0; i < sortedArr.length; i++) {
        System.out.print(sortedArr[i] + " ");
    }
}
}