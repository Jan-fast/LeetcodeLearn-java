package Recur;
public class offer64 {
    public static void main(String[] args) {
        
    }

    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}