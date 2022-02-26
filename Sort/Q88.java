package Sort;

import java.util.Arrays;

public class Q88 {
    public static void main(String[] args) {
        int m = 3, n = 3;
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        Q88 q88 = new Q88();
        q88.merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy1 = Arrays.copyOfRange(nums1, 0, m);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (copy1[i] < nums2[j]) {
                nums1[k] = copy1[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        if (i < m) {
            while (i < m) {
                nums1[k] = copy1[i];
                i++;
                k++;
            }
        }
        if (j < n) {
            while (j < n) {
                nums1[k] = nums2[j];
                j++;
                k++;
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}
