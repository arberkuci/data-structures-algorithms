package algos.sorting;

public class QuickSort {

    public void quickSort(int[] elements) {
        quickSort(elements, 0, elements.length - 1);
    }

    private void quickSort(int[] elements, int left, int right) {
        if (left < right) {
            int pivotIdx = partition(elements, left, right);
            quickSort(elements, left, pivotIdx - 1);
            quickSort(elements, pivotIdx + 1, right);
        }

    }

    private int partition(int[] elements, int leftIdx, int rightIdx) {
        int pivotElement = elements[rightIdx];
        int left = leftIdx - 1;
        int right = leftIdx;
        while (right <= rightIdx - 1) {
            if (elements[right] <= pivotElement) {
                left++;
                int temp = elements[left];
                elements[left] = elements[right];
                elements[right] = temp;
            }
            right++;
        }
        int temp = elements[left + 1];
        elements[left + 1] = elements[rightIdx];
        elements[rightIdx] = temp;
        return left + 1;
    }

}
