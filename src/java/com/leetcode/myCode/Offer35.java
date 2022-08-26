package java.LeetCode.myCode;

import java.util.HashMap;

public class Offer35 {

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

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node newHead = new Node(head.val);
        Node cur = newHead;
        Node pointer = head;
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(cur.val, cur);

        // 处理next
        while (pointer.next != null){
            cur.next = new Node(pointer.next.val);
            map.put(cur.next.val, cur.next);
            pointer = pointer.next;
            cur = cur.next;
        }
        cur.next = null;

        // 处理random
        pointer = head;
        cur = newHead;
        while (pointer.next != null){
            if (pointer.random == null){
                cur.random = null;
            } else {
                cur.random = map.get(pointer.random.val);
            }
            pointer = pointer.next;
            cur = cur.next;
        }
        if (pointer.random == null){
            cur.random = null;
        } else {
            cur.random = map.get(pointer.random.val);
        }

        return newHead;
    }

}
