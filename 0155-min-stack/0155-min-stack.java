class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        // initially no elements, so set min to +∞
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        
        // save the old min before updating
        if(val<= min){
            stack.push(min);
            min=val;
        }
        stack.push(val);
    }
    
    public void pop() {
        // restore old min
        int removed = stack.pop();
        if(removed== min){
            min= stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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