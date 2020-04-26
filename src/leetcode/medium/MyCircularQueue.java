package leetcode.medium;

class MyCircularQueue {

    private int[] arr = null;
    private int front, rear;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (!isFull() && arr.length > 0) {
            rear = (rear + 1) % arr.length;
            arr[rear] = value;
            if(front == -1){
                front += 1;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if(!isEmpty()){
            if(front == rear){
                front = -1;
                rear = -1;
            }else{
                arr[front] = 0;
                front += 1;
            }
            return true;
        }else{
            return false;
        }

    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return isEmpty()? -1 : arr[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return isEmpty()? -1 : arr[rear];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == -1 || rear == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (front == 0 && rear == arr.length-1) || (front == (rear + 1));
    }

    public static void main(String[] args) {
        MyCircularQueue mcq = new MyCircularQueue(5);
        mcq.enQueue(1);
        mcq.enQueue(2);
        mcq.enQueue(3);
        mcq.enQueue(4);
        mcq.enQueue(5);
        mcq.deQueue();
        mcq.enQueue(6);
        mcq.enQueue(6);
    }
}
