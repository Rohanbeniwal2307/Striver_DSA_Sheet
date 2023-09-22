public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            leftHalf[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            rightHalf[i - mid] = arr[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(arr, leftHalf, rightHalf);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int leftIdx = 0, rightIdx = 0, arrIdx = 0;

        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] < right[rightIdx]) {
                arr[arrIdx] = left[leftIdx];
                leftIdx++;
            } else {
                arr[arrIdx] = right[rightIdx];
                rightIdx++;
            }
            arrIdx++;
        }

        while (leftIdx < left.length) {
            arr[arrIdx] = left[leftIdx];
            leftIdx++;
            arrIdx++;
        }

        while (rightIdx < right.length) {
            arr[arrIdx] = right[rightIdx];
            rightIdx++;
            arrIdx++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
