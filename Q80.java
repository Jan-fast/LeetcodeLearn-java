public class Q80 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,2,3,3,4};
        Q80 q80 = new Q80();
        System.out.println(q80.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int count = 1, i = 1, j = 1;
        while (j < nums.length) {
            if (nums[j] == nums[i-1]) {
                if (count < 2) {
                    nums[i] = nums[j];
                    count++;
                    i++;
                }
            } else {
                nums[i] = nums[j];
                count = 1;
                i++;
            }
            j++;
        }
        return i;
    }
}
