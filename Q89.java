import java.util.ArrayList;
import java.util.List;

public class Q89 {
    public static void main(String[] args) {
        
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>(){{add(0);}};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size(); j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}
