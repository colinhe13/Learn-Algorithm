package java.LeetCode.myCode;

import java.util.HashMap;

public class Offer35_1 {

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

    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 判断当前map中是否存在该键值对
        if (map.containsKey(head)) return map.get(head);
        if (!map.containsKey(head)){
            // 如果不存在则递归创建
            Node node = new Node(head.val);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
            map.put(head, node);
        }

        return map.get(head);
    }


}
