package algos.sorting;

public class MergeSort {
    public void mergeSort(int[] values, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(values, start, middle);
            mergeSort(values, middle + 1, end);
            merge(values, start, middle, end);
        }
    }

    private void merge(int[] values, int start, int middle, int end) {
        int leftSize = middle - start + 1;
        int rightSize = end - middle;
        int[] leftValues = new int[leftSize];
        int[] rightValues = new int[rightSize];

        for (int i = 0; i < leftSize; i++)
            leftValues[i] = values[start + i];
        for (int i = 0; i < rightSize; i++)
            rightValues[i] = values[i + middle + 1];

        int idx = start;
        int leftIdx = 0;
        int rightIdx = 0;

        while (idx <= end) {
            if (leftIdx >= leftSize) {
                values[idx] = rightValues[rightIdx];
                rightIdx++;
            } else if (rightIdx >= rightSize) {
                values[idx] = leftValues[leftIdx];
                leftIdx++;
            } else {
                if (leftValues[leftIdx] <= rightValues[rightIdx]) {
                    values[idx] = leftValues[leftIdx];
                    leftIdx++;
                } else {
                    values[idx] = rightValues[rightIdx];
                    rightIdx++;
                }
            }
            idx++;
        }
    }
}
