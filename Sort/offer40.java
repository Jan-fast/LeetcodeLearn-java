package Sort;
import java.util.Arrays;

public class offer40 {
    public static void main(String[] args) {
        int[] arr = {30,40,3,34,5,9};
        int k = 5;
        offer40 getleast = new offer40();
        System.out.println(getleast.getLeastNumbers(arr, k));
    }
    
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k > arr.length) return arr;
        //Arrays sort
        // Arrays.sort(arr);

        //quick sort, only divide the blocks, not fully sort
        quickSort(arr, k, 0, arr.length - 1);

        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int k, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (k < i) quickSort(arr, k, l, i);
        else if (k > i) quickSort(arr, k, i + 1, r);
    }

    private void swap (int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
