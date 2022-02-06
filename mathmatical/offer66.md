# offer66

## Question:

Given an array `A[0,1,...,n-1]` , please build an array `B[0,1,...,n-1]` , where the value of `B[i]` is the product of the elements in array `A` excluding subscript i, which is `B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]` . Cannot use division.

## Solution:

**Algorithm:**

1. **initialize:** array B, set `B[0]=1` ; auxiliary variable `tmp=1` ;
2. Calculate the product of the element of the lower triangle of `B[i]` and multiply directly into `B[i]` .
3. Calculate the product of the element of the upper triangle of `B[i]` , denoted as `tmp` and multiply into `B[i]` .
4. return `B` .

<img src="/Users/jan/Code/java/learn/img/offer66_1.png" style="zoom:50%;" />

<img src="/Users/jan/Code/java/learn/img/offer66_2.png" style="zoom:50%;" />

<img src="/Users/jan/Code/java/learn/img/offer66_3.png" style="zoom:50%;" />

<img src="/Users/jan/Code/java/learn/img/offer66_4.png" style="zoom:50%;" />

<img src="/Users/jan/Code/java/learn/img/offer66_5.png" style="zoom:50%;" />

<img src="/Users/jan/Code/java/learn/img/offer66_6.png" style="zoom:50%;" />

<img src="/Users/jan/Code/java/learn/img/offer66_7.png" style="zoom:50%;" />

```java
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        if (a.length == 0) return b;
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i-1] * a[i-1];
        }
        int tmp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i+1];
            b[i] *= tmp;
        }
        return b;
    }
```

