package search;

public class Q81 {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        Q81 q81 = new Q81();
        System.out.println(q81.search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) return true;
            if (nums[l] == nums[mid] && nums[r] == nums[mid]) {
                l++;
                r--;
            } else if (nums[mid] >= nums[l]) {
                if (target >= nums[l] && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[nums.length-1]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return false;
    }
}
