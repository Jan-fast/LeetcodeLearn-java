public class offer39 {
    public static void main(String[] args) {
        
    }

    public int majorityElement(int[] nums) {
        int x = nums[0], votes = 1;
        for (int i = 1; i < nums.length; i++) {
            if (votes == 0) x = nums[i];
            if (nums[i] == x) votes++;
            else votes--;
        }
        return x;
    }
}
