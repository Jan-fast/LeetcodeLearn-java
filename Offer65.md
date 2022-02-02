# Offer65

## Question:

Addition without +, -, *, /.

## Solution:

Set the binary form of two digits `a,b`, its sum `s = a + b`, a(i) representative `a` binary `i` bits, which are divided into the following four cases: 

| $a(i)$ | $b(i)$ | no carry-sum $n(i)$ | Carry $c(i+1)$ |
| :----: | :----: | :-----------------: | :------------: |
|   0    |   0    |          0          |       0        |
|   0    |   1    |          1          |       0        |
|   1    |   0    |          1          |       0        |
|   1    |   1    |          0          |       1        |

we can find 

$\begin{cases} 
n=a \oplus b, &no\ carry\ sum \\
c=a \& b << 1, &carry
\end{cases}$

So 

$s=a+b \Rightarrow s=n+c$

Loop `n` and `c` until the carry is in place `c=0` ; at this time `s=n`, return `n`.

<img src="/Users/jan/Code/java/learn/img/offer65.png" style="zoom:48%;" />

```java
public int add(int a, int b) {
    while (b != 0) {
        int c = (a & b) << 1;
        a ^= b;
        b = c;
    }
    return a;
}
```

