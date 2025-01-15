package io.github.precodertech.codingjava;


class StackUsingArray {
    private int[] stack;
    private int top;

    StackUsingArray(int size) {
        this.stack = new int[size];
        this.top = -1;
    }

    void push(int value) throws Exception {
        if (this.top == stack.length - 1) throw new Exception("Stack is full");
        this.stack[++this.top] = value;
    }

    int pop() throws Exception {
        if (this.top == -1) throw new Exception("Stack is empty");
        return this.stack[top--];
    }
}

