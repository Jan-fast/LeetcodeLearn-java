 # Offer39

## Question:

A number that appears more than half the time in the array.

## Solution:

> In this question, numbers that appear more than half of the time in the array are called mode for short.

### Boyer-Moore majority vote algorithm

> Set the mode of the input array `nums` be $x$, array's length be $n$.

**推论一：** 若记 **众数** 的票数为 +1，**非众数** 的票数为 −1，则一定有所有数字的 **票数和 >0** 。

**推论二：** 若数组的前 *a* 个数字的 **票数和 = 0** ，则 数组剩余 (*n*−*a*) 个数字的 **票数和一定仍 >0** ，即后 (*n*−*a*) 个数字的 **众数仍为 x** 。

<img src="/Users/jan/Code/java/learn/img/offer39_1.png" style="zoom:40%;" />

__algorithm:__

1. **initalize:** `votes = 0`, mode `x` ;
2. __cycle:__ traverse the array `nums` 
	- if `votes == 0`, than set current number be mode `x` ;
	- if current number is equal to `x` , `votes++` ; or `votes--` .
3. __return value:__ return `x` .

```java
public int majorityElement(int[] nums) {
    int x = nums[0], votes = 1;
    for (int i = 1; i < nums.length; i++) {
        if (votes == 0) x = nums[i];
        if (nums[i] == x) votes++;
        else votes--;
    }
    return x;
}
```

