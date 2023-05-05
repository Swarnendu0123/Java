public class QueueUsingArray {
    static class Queue {
        static int data[];
        static int size;
        static int rear;

        // constructor
        Queue(int n) {
            data = new int[n];
            size = n;
            rear = -1;
        }

        // function to check queue is empty or not
        public static boolean isEmpty() {
            return rear == -1;
        }

        // function to add in queue
        public void add(int num) {
            if (rear == size - 1) {// queue is full
                System.out.println("Queue is full");
                return;
            }
            rear++;
            data[rear] = num;
        }

        // remove function
        public int remove() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            int front = data[0];
            for (int i = 0; i < rear; i++) {
                data[i] = data[i + 1];
            }
            rear--;
            return front;
        }

        // peek
        public static int peeek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return data[0];
        }

        // function to print queue
        public void printQueue() {
            for (int i = 0; i < rear + 1; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.printQueue();
        q.remove();
        q.printQueue();
    }
}
