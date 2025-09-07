package main.java;

import java.util.Stack;

public class MyQueue <V>{
    Stack<V> stack1 = new Stack<>();
    Stack<V> stack2 = new Stack<>();
    public void push(V value){
        stack1.push(value);
    }
    public V poll(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public V peek(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public int size(){
        return stack1.size() + stack2.size();
    }

}
