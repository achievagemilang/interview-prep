package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    Deque<Integer> st;
    Deque<Integer> minSt;
    public MinStack() {
        this.st = new ArrayDeque<>();
        this.minSt = new ArrayDeque<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty() || val <= minSt.peek()){
            minSt.push(val);
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;

        int val = st.pop();
        if(minSt.peek() == val){
            minSt.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }  
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 /*
 Use double stack to keep consistencies between data as requeirements suggest

 st1 : normal stack
 st2 : minimum stack -> top must be the highest possible 

T(n):
void push(int val) pushes the element val onto the stack. -> O(1)
void pop() removes the element on the top of the stack. -> O(1)
int top() gets the top element of the stack. -> O(1)
int getMin() retrieves the minimum element in the stack. -> O(1)

 S(n): O(n)
 */