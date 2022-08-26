package java.LeetCode.myCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Offer30 {

    class MinStack {

        /** initialize your data structure here. */
        Deque<Integer> outStack;
        Deque<Integer> cacheStack;


        public MinStack() {
            outStack = new ArrayDeque<Integer>();
            cacheStack = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            outStack.addFirst(x);
        }

        public void pop() {
            outStack.removeFirst();
        }

        public int top() {
            if (!outStack.isEmpty()){
                return outStack.peekFirst();
            } else {
                return -1;
            }
        }

        public int min() {
            if (outStack.isEmpty()){
                return -1;
            }

            int m = outStack.peekFirst();
            while (!outStack.isEmpty()){
                if (m > outStack.peekFirst()){
                    m = outStack.peekFirst();
                }
                cacheStack.addFirst(outStack.removeFirst());
            }
            while (!cacheStack.isEmpty()){
                outStack.addFirst(cacheStack.removeFirst());
            }
            return m;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

}
