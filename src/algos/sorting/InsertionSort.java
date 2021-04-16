package algos.sorting;

public class InsertionSort {

    public void insertionSort(int[] values) {
        if (values.length == 1) return; // one element array is sorted.
        for (int pos = 1; pos < values.length; pos++) {
            int val = values[pos];
            int j = pos - 1;
            while (j >= 0 && values[j] > val) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = val;
        }
    }

}
