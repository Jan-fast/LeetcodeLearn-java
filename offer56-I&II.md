# offer56-I&II

## Question：

1. In an integer array `nums`, except for two numbers, all other numbers appear twice. Please write a program to find these two numbers that only appear once. ==The time complexity is $O(N)$ and the space complexity is $O(1)$==.

	> Input: nums = [4,1,4,6]
	>
	> Output: [1,6] or [6,1]

2. In an array `nums`, except that one number appears only once, all other numbers appear three times. Please find the number that appears only once.

	> Input: nums = [3,4,3,3]
	>
	> Output: 4

## Solution:

### Question1:

- Let the number appearing once in the integer array `nums` be $x$ And the number appearing twice be $a,a,b,b,...$ , so $$nums=[a,a,b,b,...,x]$$ 

- If the XOR is performed on all numbers in `nums`, the result left is the number $x$ that appears once, that is $a \oplus a \oplus b \oplus b \oplus ...\oplus x = 0 \oplus 0 \oplus ... \oplus x =x$

-  ```java
	 public int[] singleNumber(int[] nums) {
	     int x = 0;
	     for(int num : nums)  // 1. 遍历 nums 执行异或运算
	         x ^= num;
	     return x;            // 2. 返回出现一次的数字 x
	 }
	```

- <img src="/Users/jan/Code/java/learn/img/offer56I_1.png" style="zoom:40%;" />

	> But in question one, array `nums` has two numbers that only appear once, so you can't get them directly through XOR.

- Let two numbers that only appear once be $x$ and $y$. Because of $x \ne y$, there is at least one bit difference between the binary of $x$ and $y$ (i.e. 0 and 1 respectively). According to this bit, `nums` can be divided into two sub arrays containing $x$ and $y$ respectively.

	- Algorithm:

		1. __traverse `nums` to execute XOR:__ $a\oplus a\oplus b\oplus b\oplus ...\oplus x\oplus y = 0\oplus 0\oplus ...\oplus x\oplus y = x\oplus y = n$

		2. __cycle left shift calculation m:__ get integer $x\oplus y$ first $1$.

			```java
			int m = 1;
			while((n & m) == 0) m <<= 1;
			```

		3. __split `nums` into two subarrays__

		4. __traverse two subarrays to perform XOR__

		5. __return the number x, y that appears only once__

	- <img src="/Users/jan/Code/java/learn/img/offer56I_2.png" style="zoom:40%;" />

```java
public int[] singleNum(int[] nums) {
    int n = 0;
    for (int i = 0; i < nums.length; i++) n ^= nums[i];
    int m = 1;
    while ((n & m) == 0) m <<= 1;
    int x = 0, y = 0;
    for (int i = 0; i < nums.length; i++) {
        if ((nums[i] & m) == 0) x ^= nums[i];
        else y ^= nums[i];
    }
    return new int[]{x, y};
}
```

### Question2:

<img src="/Users/jan/Code/java/learn/img/offer56II_1.png" style="zoom:40%;" />

__有限状态自动机__

- 考虑其中一位二进制位，对所有数字中的某二进制位1的个数，存在三种状态，即对3余数为0，1，2。

	<img src="/Users/jan/Code/java/learn/img/offer56II_2.png" style="zoom:40%;" />

- 设置`two, one` 分别表示两位二进制数，对0，1，2分别进行表示。

	<img src="/Users/jan/Code/java/learn/img/offer56II_3.png" style="zoom:40%;" />

- __计算`one`:__ 

	```java
	one = one ^ n & ~two
	```

	<img src="/Users/jan/Code/java/learn/img/offer56II_4.png" style="zoom:40%;" />

	__计算`two`:__

	```java
	two = two ^ n & ~one
	```

	<img src="/Users/jan/Code/java/learn/img/offer56II_5.png" style="zoom:40%;" />

```java
public int singleNumber(int[] nums) {
    int ones = 0, twos = 0;
    for (int num : nums) {
        ones = ones ^ num & ~twos;
        twos = twos ^ num & ~ones;
    }
    return ones;
}
```

