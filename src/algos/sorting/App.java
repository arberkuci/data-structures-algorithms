package algos.sorting;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        Random random = new Random();
        int[] values = new int[1000000];
        for (int i = 999999; i >= 0; i--) values[i] = random.nextInt();
        MergeSort mergeSort = new MergeSort();
        System.out.println("========================================");
        System.out.println("========== Starting merge sort =========");
        System.out.println("========================================");
        long start = System.currentTimeMillis();
        mergeSort.mergeSort(values, 0, values.length - 1);
        long finish = System.currentTimeMillis();
        System.out.println(((finish - start) / 1000) + " seconds");
        System.out.println("========================================");
        System.out.println("========== Finished merge sort =========");
        System.out.println("========================================");
        System.out.println();

        values = new int[1000000];
        for (int i = 999999; i >= 0; i--) values[i] = random.nextInt();
        HeapSort heapSort = new HeapSort(values);
        System.out.println("=======================================");
        System.out.println("========== Starting heap sort =========");
        System.out.println("=======================================");
        start = System.currentTimeMillis();
        heapSort.sort();
        finish = System.currentTimeMillis();
        System.out.println(((finish - start) / 1000) + " seconds");
        System.out.println("=======================================");
        System.out.println("========== Finished heap sort =========");
        System.out.println("=======================================");
        System.out.println();

        InsertionSort insertionSort = new InsertionSort();
        values = new int[1000000];
        for (int i = 999999; i >= 0; i--) values[i] = random.nextInt();
        System.out.println("============================================");
        System.out.println("========== Starting insertion sort =========");
        System.out.println("============================================");
        start = System.currentTimeMillis();
        insertionSort.insertionSort(values);
        finish = System.currentTimeMillis();
        System.out.println(((finish - start) / 1000) + " seconds");
        System.out.println("============================================");
        System.out.println("========== Finished insertion sort =========");
        System.out.println("============================================");
        System.out.println();
    }

}
