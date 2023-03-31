package HomeWork3;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {

        int[] array = new int[10];

        int arrayLength = array.length;

        arrayRandomizer(array);

        System.out.println("\nИсходный массив:\n" + Arrays.toString(array));

        mergeSort(array, arrayLength);

        System.out.println("\nИтоговый массив:\n" + Arrays.toString(array) + "\n");

    }

    public static void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            rightArr[i - mid] = arr[i];
        }
        mergeSort(leftArr, mid);
        mergeSort(rightArr, n - mid);
        merge(arr, leftArr, rightArr, mid, n - mid);
    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }
    }

    private static void arrayRandomizer(int[] array) {
        Random rnd = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(0, 20);
        }
    }
}