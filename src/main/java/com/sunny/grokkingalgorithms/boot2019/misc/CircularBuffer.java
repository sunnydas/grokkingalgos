package com.sunny.grokkingalgorithms.boot2019.misc;

public class CircularBuffer {

    /*
    https://medium.com/@edwin.cloud/wrapping-your-head-around-circular-buffers-e84cbf549a04
     */

    private int head;

    private int tail;

    public CircularBuffer() {
    }

    int[] buffer;


    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
        if(bufferSize <= 0){
            throw new IllegalArgumentException("Invalid buffer size " + bufferSize);
        }
        this.buffer = new int[bufferSize];
        for(int i = 0 ; i < buffer.length ; i++){
            buffer[i] = Integer.MIN_VALUE;
        }
    }

    int bufferSize;


    public void enqueue(int value){
        if(isFull()){
            throw new IllegalArgumentException("Buffer is full cannot enqueue");
        }
        buffer[tail] = value;
        int nextTailIndex = (tail + 1)%bufferSize;
        tail = nextTailIndex;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("Empty buffer nothing to dequeue");
        }
        int value = buffer[head];
        buffer[head] = Integer.MIN_VALUE;
        int nextHeadIndex = (head + 1)%bufferSize;
        head = nextHeadIndex;
        return value;
    }

    public boolean isFull(){
        return tail == (head-1)%bufferSize;
    }

    public boolean isEmpty(){
        return head == tail && buffer[head] == Integer.MIN_VALUE;
    }


    public void printBufferState(){
        System.out.println();
        System.out.println(" head = " + head + " tail " + tail);
        System.out.print("[ ");
        for(int i = 0; i < buffer.length ; i++){
            System.out.print(buffer[i] + " ");
        }
        System.out.print(" ] ");
        System.out.println();
    }



    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer();
        circularBuffer.setBufferSize(5);
        circularBuffer.enqueue(1);
        circularBuffer.enqueue(2);
        circularBuffer.printBufferState();
        circularBuffer.enqueue(3);
        circularBuffer.printBufferState();
        circularBuffer.enqueue(4);
        circularBuffer.printBufferState();
        circularBuffer.enqueue(5);
        circularBuffer.printBufferState();
        circularBuffer.enqueue(6);
        circularBuffer.printBufferState();
        System.out.println(circularBuffer.dequeue());
        System.out.println(circularBuffer.dequeue());
        System.out.println(circularBuffer.dequeue());
        System.out.println(circularBuffer.dequeue());
        System.out.println(circularBuffer.dequeue());
    }


}
