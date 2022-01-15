import java.util.HashMap;
import java.util.Map;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution1 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node pre = head;
        Map<Node, Node> map = new HashMap<>();
        
        //copy each old node, set up the map between old node and new node.
        while (pre != null) {
            map.put(pre, new Node(pre.val));
            pre = pre.next;
        }

        //use hashmap build new node's next and random. 
        pre = head;
        while (pre != null) {
            map.get(pre).next = map.get(pre.next);
            map.get(pre).random = map.get(pre.random);
            pre = pre.next;
        }
        return map.get(head);
    }
}

class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur;
        cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) 
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node nex = head.next;
        Node ans = head.next;
        while (cur.next != null) {
            cur.next = cur.next.next;
            nex.next = nex.next.next;
            cur = cur.next;
            nex = nex.next;
        }
        cur.next = null;
        return ans;
    }
}