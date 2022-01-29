package Sort;
public class offer45 {
    public static void main(String[] args) {
        
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);

        //method1
        quickSort(strs, 0, strs.length-1);

        //method2
        //Arrays.sort(strs, (x, y)->(x + y).compareTo(y + x));

        StringBuffer res = new StringBuffer();
        for (String s : strs) res.append(s);
        return res.toString();
    }
    
    public void quickSort(String[] strs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            while (i < j && (strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0) j--;
            while (i < j && (strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i-1);
        quickSort(strs, i+1, r);
    }
}
