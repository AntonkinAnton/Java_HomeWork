package HomeWork5;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {

        int[] array = new int[10];

        arrayRandomizer(array);

        System.out.println("\nВаш массив: " + Arrays.toString(array));

        heapSort(array);

        System.out.println("\nВаш отсортированный массив: " + Arrays.toString(array) + "\n");

    }
    
    private static void heapSort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            addToHeap(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            addToHeap(arr, i, 0);
        }
    }

    private static void addToHeap(int arr[], int n, int i) {
        int largest = i; 
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            addToHeap(arr, n, largest);
        }
    }

    private static void arrayRandomizer(int[] array) {
        Random rnd = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(0, 20);
        }
    }
}
