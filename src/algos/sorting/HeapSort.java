package algos.sorting;

import java.util.Arrays;

public class HeapSort {

    private int[] values;
    private int heapSize = 0;

    public HeapSort(int[] values) {
        this.values = values;
        this.heapSize = values.length;
    }

    /**
     * Sorts the elements in an increasing order.
     */
    public void sort() {
        buildMaxHeap();
        for (int i = heapSize - 1; i >= 1; i--) {
            int temp = values[i];
            values[i] = values[0];
            values[0] = temp;
            heapSize--;
            maxHeapify(0);
        }
    }

    public void buildMaxHeap() {
        for (int i = heapSize / 2; i >= 0; i--) maxHeapify(i);
    }

    public void buildMinHeap() {
        for (int i = heapSize / 2; i >= 0; i--) minHeapify(i);
    }

    private void maxHeapify(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int largest = index;//assume that the largest value is stored in node indexed with 'index'
        if (leftChildIndex < heapSize && values[index] < values[leftChildIndex])
            largest = leftChildIndex;
        if (rightChildIndex < heapSize && values[largest] < values[rightChildIndex])
            largest = rightChildIndex;
        if (largest != index) {
            int temp = values[index];
            values[index] = values[largest];
            values[largest] = temp;
            maxHeapify(largest);
        }
    }

    private void minHeapify(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int minimum = index;
        if (leftChildIndex < heapSize && values[index] > values[leftChildIndex])
            minimum = leftChildIndex;
        if (rightChildIndex < heapSize && values[minimum] > values[rightChildIndex])
            minimum = rightChildIndex;
        if (minimum != index) {
            int temp = values[minimum];
            values[minimum] = values[index];
            values[index] = temp;
            minHeapify(minimum);
        }
    }

    private int getLeftChildIndex(int idx) {
        return 2 * idx + 1;
    }

    private int getRightChildIndex(int idx) {
        return 2 * idx + 2;
    }
}
