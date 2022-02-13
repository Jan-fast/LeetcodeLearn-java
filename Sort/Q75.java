package Sort;

public class Q75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        Q75 q75 = new Q75();
        q75.sortColors(nums);
    }

    public void sortColors(int[] nums) {
        if (nums.length <= 1) return;
        int zero = 0, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, one, zero);
                one++;
                zero++;
            } else if (nums[one] == 1) {
                one++;
            } else {
                two--;
                swap(nums, one, two);
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
