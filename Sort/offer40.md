# Offer40

## Question:

Input an array of integers, output the least `k` numbers.

> __Input:__ arr = [3,2,1], k = 2
>
> __Output:__ [1,2] or [2,1]

## Solution:

1. **Using built-in functions to sort the array:**

```java
public int[] getLeastNumbers(int[] arr, int k) {
    //Arrays sort
    Arrays.sort(arr);
    return Arrays.copyOf(arr, k);
}
```

2. **Array division based on quick sort:**
	- Just output the smallest `k` numbers, no sorting required. Therefore, we need to divide the array into two parts: `the minimum k numbers` and `other numbers`.
	- __quickSort:__ 
		1. After the division is completed, the benchmark is arr[i]
		2. Recuring or return condition:
			- if $k < i$, represents the $(k+1)$ smallest number in the left subarray, then recuring the left subarray;
			- if $k > i$, then recuring the right subarray;
			- if $k=i$, return `arr[0...k]`.

<img src="/Users/jan/Code/java/learn/Sort/img/offer40-1.png" alt="quick sort" style="zoom:50%;" />

```java
public int[] getLeastNumbers(int[] arr, int k) {
    if (k > arr.length) return arr;
    //quick sort, only divide the blocks, not fully sort
    quickSort(arr, k, 0, arr.length - 1);
    return Arrays.copyOf(arr, k);
}

private void quickSort(int[] arr, int k, int l, int r) {
    if (l >= r) return;
    int i = l, j = r;
    while (i < j) {
        while (i < j && arr[j] >= arr[l]) j--;
        while (i < j && arr[i] <= arr[l]) i++;
        swap(arr, i, j);
    }
    swap(arr, i, l);
    if (k < i) quickSort(arr, k, l, i);
    else if (k > i) quickSort(arr, k, i + 1, r);
}

private void swap (int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}
```

