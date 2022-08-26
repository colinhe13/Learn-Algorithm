package java.LeetCode.myCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Offer09 {

    class CQueue {

        Deque<Integer> s1;
        Deque<Integer> s2;

        public CQueue() {
            s1 = new ArrayDeque<>();
            s2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            while (!s1.isEmpty()){
                s2.addFirst(s1.removeFirst());
            }
            s2.addFirst(value);
            while (!s2.isEmpty()){
                s1.addFirst(s2.removeFirst());
            }
        }

        public int deleteHead() {
            if (!s1.isEmpty()){
                int x = s1.peekFirst();
                s1.removeFirst();
                return x;
            } else {
                return -1;
            }

        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

}
