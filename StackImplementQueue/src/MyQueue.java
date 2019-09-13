import java.util.Stack;

public class MyQueue {
    private Stack<Integer> A;
    private Stack<Integer> B;
    public MyQueue() {
        //定义A栈为入队的栈
        //定义B栈为出队的栈
        A = new Stack<>();
        B = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        A.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()){
            return -1;
        }
        if (B.empty()) {
            while (!(A.empty())) {
                B.push(A.pop());
            }
        }
        return B.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (empty()){
            return -1;
        }
        if (B.empty()) {
            while (!(A.empty())) {
                B.push(A.pop());
            }
        }
        return B.peek();
    }
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (A.empty() && B.empty()){
            return true;
        }else{
            return false;
        }
    }
}
