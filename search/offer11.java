package search;
public class offer11 {
    public static void main(String[] args) {
        int[] numbers = {1,3,3};
        minNumOfReverseArr minnum = new minNumOfReverseArr();
        System.out.println(minnum.minArray(numbers));
    }
}

class minNumOfReverseArr {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1, mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (numbers[mid] < numbers[r]) {
                r = mid;
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else if (numbers[mid] == numbers[r]) {
                r = r - 1;
            }
        }
        return numbers[l];
    }
}