package mathmatical;
public class offer65 {
    public static void main(String[] args) {
        
    }

    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
