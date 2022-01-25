public class offer21 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,4,5};
        offer21 ex = new offer21();
        System.out.println(ex.exchange(nums));
    }

    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 != 0) i++;
            if (nums[j] % 2 == 0) j--;
            if (nums[i] % 2 == 0 && nums[j] % 2 != 0 && i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }
}
