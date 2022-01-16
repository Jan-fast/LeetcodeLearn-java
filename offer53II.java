public class offer53II {
    public static void main(String[] args) {
        int[] nums = {0,2,3};
        missingNum miss = new missingNum();
        System.out.println(miss.missingNumber(nums));
    }
}

class missingNum {
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length-1, mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l == nums.length-1 && nums[l] == l) l++;
        return l;
    }
}