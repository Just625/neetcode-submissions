class MinStack {
    Deque<Integer> stack;
    // Create a second stack that holds the current min value
    Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int minVal;
        if (stack.isEmpty()) {
            minVal = val;
        } else {
            minVal = Math.min(this.minStack.peek(), val);
        }

        this.stack.push(val);
        this.minStack.push(minVal);
    }
    
    // pop, top and getMin will always be called on non-empty stacks.
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
