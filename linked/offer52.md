# LeetCode Offer 52.
## Question:  
**Input two linkedlists, find their first common node.**  
![alt example](img/offer52.png)
***Example1:***  
![alt example1](img/offer52_example_1.png)
- `Input:` listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], intersectVal = 8
- `Output:` Reference of the node with value = 8  
## Solution:
1. **Method 1:**  
    Count two lists' length, move the longer one's head pointer by the difference of the length of the two lists. Then move two head pointer together, compare two pointers to the same node.
    ```java
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode Acur, Bcur;
        int Alen = 0, Blen = 0;
        Acur = headA;
        Bcur = headB;
        while (Acur != null || Bcur != null) {
            Alen = Acur == null ? Alen : Alen + 1;
            Blen = Bcur == null ? Blen : Blen + 1;
            Acur = Acur == null ? null : Acur.next;
            Bcur = Bcur == null ? null : Bcur.next;
        }
        int len = Math.abs(Alen - Blen);
        if (Alen > Blen) {
            while (len > 0) {
                headA = headA.next;
                len--;
            }
        } else {
            while (len > 0) {
                headB = headB.next;
                len--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) break;
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    ```
2. **Method 2:**  
    Be the first common node be `Node`, the number of nodes in linked list A is `a`, linked list B is `b`.  
    The number between `headA` and `Node` is $a-c$, between `headB` and `Node` is $b-c$.
    ![alt method2](img/offer52_method2.png)  
    Build two pointer `A` and `B` point to `headA` and `headB`, do the following:  
    - pointer `A` traverse `linked list A` and then start traverse `linked list B`.When traversing to `Node`, the total number of steps taken is $$a+(b-c)$$
    - pointer `B` traverse `linked list B` and then start traverse `linked list A`.When traversing to `Node`, the total number of steps taken is $$b+(a-c)$$

    Only when $$a+(b-c)=b+(a-c)$$ two pointer `A` and `B` will match and have two conditions:  
    1. If two linked list have common tail $(c > 0)$: `A` and `B` point to `Node`.
    2. If two linked list don't have common tail $(c = 0)$: `A` and `B` point to `null`.  

    ```java
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
    ```
    