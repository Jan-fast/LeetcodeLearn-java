public class offer57 {
    public static void main(String[] args) {
        int[] nums = {14,15,16,22,53,60};
        int target = 76;
        offer57 twoSumTest = new offer57();
        // twoSumTest.twoSum(nums, target);
        twoSumTest.twoSum2(nums, target);
    }
    //method1: binarySearch
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target / 2) return null;
            int cur = target - nums[i];
            if (cur <= nums[nums.length - 1]) {
                int m = i + 1, n = nums.length - 1, mid = -1;
                while (m <= n) {
                    mid = (m + n) / 2;
                    if (nums[mid] > cur) n = mid - 1;
                    else if (nums[mid] < cur) m = mid + 1;
                    else {
                        ans[0] = nums[i];
                        ans[1] = nums[mid];
                        return ans;
                    }
                }
            }
        }
        return ans;
    }

    //method2: two pointers
    public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) i++;
            if (nums[i] + nums[j] > target) j--;
            if (nums[i] + nums[j] == target) {
                ans[0] = nums[i];
                ans[1] = nums[j];
                return ans;
            }
        }
        return ans;
    }
}
