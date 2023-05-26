interface SortingStrategy {
    void sort(Integer[] list);
}

class BubbleSort implements SortingStrategy {
    @Override
    public void sort(Integer[] list) {
        int n = list.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}

class MergeSort implements SortingStrategy {
    @Override
    public void sort(Integer[] list) {
        mergeSort(list, 0, list.length - 1);
    }

    private void mergeSort(Integer[] list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private void merge(Integer[] list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Integer[] leftArr = new Integer[n1];
        Integer[] rightArr = new Integer[n2];

        System.arraycopy(list, left, leftArr, 0, n1);
        System.arraycopy(list, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                list[k++] = leftArr[i++];
            } else {
                list[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            list[k++] = leftArr[i++];
        }

        while (j < n2) {
            list[k++] = rightArr[j++];
        }
    }
}
