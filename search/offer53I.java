package search;
public class offer53I {
    public static void main(String[] args) {
        int[] nums = {0,0,1,2,2};
        int target = 2;
        searchRepeat search = new searchRepeat();
        System.out.println(search.binarySearch(nums, target));
    }
}

class searchRepeat {
    public int binarySearch(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int l = 0, r = nums.length-1, mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else break;
        }
        int i = mid, sum = 0;
        while (i < nums.length && nums[i] == target) {
            sum++;
            i++;
        }
        i = mid - 1;
        while (i >= 0 && nums[i] == target) {
            sum++;
            i--;
        }
        return sum;
    }
}