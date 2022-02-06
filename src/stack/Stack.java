package stack;

import java.util.LinkedList;

public class Stack {
    int MAX_SIZE;
    int top;
    int[] list;

    Stack(int size) {
        this.top = -1;
        this.MAX_SIZE = size;
        list = new int[MAX_SIZE];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.MAX_SIZE-1;
    }

    public void push(int num) throws Exception {
        if (this.top == MAX_SIZE-1) throw new Exception("Stack Full...");

        this.list[++this.top] = num;
    }

    public int pop() throws Exception {
        if (this.top == -1) throw new Exception("Stack Empty...");

        return this.list[this.top--];
    }

    public int top() throws Exception {
        if (this.top == -1) throw new Exception("Stack Empty...");

        return this.list[this.top];
    }

    public void print() {
        for(int i = 0; i <= top; i++) {
            System.out.print(this.list[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            Stack stack = new Stack(32);
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.print();
            System.out.println("1st pop: " + stack.pop());
            System.out.println("2nd pop: " + stack.pop());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
