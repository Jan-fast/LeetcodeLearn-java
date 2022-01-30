# Offer55-II

## Question:

Input a binary tree's root node, output whether the tree is a balance binary tree.

## Solution:

1. __Preorder:__

  > Easy think but there will be a lot of duplicate calculation.

  - __`isBalanced(root)` function:__ Determines whether the tree is balanced `root`
	- **exception handling:** if the tree root node is empty, it is returned directly `true`.
	- **return value:** all subtrees need to satisfy the balance binary tree nature, so the following tree are used with logic `&&` connection:

  		1. `abs(self.maxDeep(root.left) - self.maxDeep(root.right)) <= 1` : determine whether the current subtree is a balanced tree;
  		2. `self.isBalanced(root.left)` : pre-order traversal recursion to determine whether the left subtree is a balanced tree;
  		3. `self.isBalanced(root.right)` : pre-order traversal recursion to determine whether the right subtree is a balanced tree.
- __`maxDeep(root)` function:__ calculate the depth of the tree `root`.
	- **termination condition:** when `root == null`, return 0;
	- **return value:** return the maximum value of the depth of the left/right subtree + 1.

- __time:__ $O(NlogN)$, __space:__ $O(N)$ 

```java
public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    if (isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxDeep(root.left) - maxDeep(root.right)) <= 1) return true;
    return false;
}

private int maxDeep(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDeep(root.left), maxDeep(root.right)) + 1;
}
```

2. __Post-order + pruning (bottom to top):__

> this method is the optimal solution to this problem, uneasy to think of at first time.

The idea is to do a post-order traversal of the binary tree, return the depth of subtree from the bottom to the top, and if it is determined that a subtree is not a balanced tree, "prune" and return directly upwards.

- __`recur(root)` function:__
	- **return value:** 
		1. when nodes are left/right the depth difference of the subtree `root` $\leq 1$ : returns the depth of the current subtree (`max(left, right) + 1`);
		2. when nodes are left/right the depth difference of the subtree `root` $>$ 2 : return -1, which means this subtree is not a balance tree.
- __`isBalanced(root)` function:__
	- __return value:__ if `recur(root) != -1`, then the binary tree is balance, return `true`; or return `false`.
- __time:__ $O(N)$, __space:__ $O(N)$ 
	

<img src="/Users/jan/Code/java/learn/Tree/img/offer55II-Post-1.png" alt="post 1" style="zoom:48%;" />

<img src="/Users/jan/Code/java/learn/Tree/img/offer55II-Post-2.png" alt="post 2" style="zoom:48%;" />

<img src="/Users/jan/Code/java/learn/Tree/img/offer55II-Post-3.png" alt="post 3" style="zoom:48%;" />

<img src="/Users/jan/Code/java/learn/Tree/img/offer55II-Post-4.png" alt="post 4" style="zoom:48%;" />

<img src="/Users/jan/Code/java/learn/Tree/img/offer55II-Post-5.png" alt="post 5" style="zoom:48%;" />

<img src="/Users/jan/Code/java/learn/Tree/img/offer55II-Post-6.png" alt="post 6" style="zoom:48%;" />

<img src="/Users/jan/Code/java/learn/Tree/img/offer55II-Post-7.png" alt="post 7" style="zoom:48%;" />

<img src="/Users/jan/Code/java/learn/Tree/img/offer55II-Post-8.png" alt="post 8" style="zoom:48%;" />

<img src="/Users/jan/Code/java/learn/Tree/img/offer55II-Post-9.png" alt="post 9" style="zoom:48%;" />

<img src="/Users/jan/Code/java/learn/Tree/img/offer55II-Post-10.png" alt="post 10" style="zoom:48%;" />

```java
public boolean isBalanced2(TreeNode root) {
    return recur(root) != -1 ? true : false;
}
private int recur(TreeNode root) {
    if (root == null) return 0;
    int l = recur(root.left), r = recur(root.right);
    if (l == -1 || r == -1) return -1;
    return Math.abs(l - r) <= 1 ? Math.max(l, r) + 1 : -1;
}
```

