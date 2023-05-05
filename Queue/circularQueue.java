public class circularQueue {

    static class Queue {
        static int data[];
        static int size;
        static int rear;
        static int front;

        // constructor
        Queue(int n) {
            data = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // function to check queue is empty or not
        public static boolean isEmpty() {
            return (rear == -1) && (front == -1);
        }

        // function to check queue is full or not
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // function to add in queue
        public void add(int num) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front++;
            }
            rear = (rear + 1) % size;
            data[rear] = num;
        }

        // remove function
        public int remove() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            int result = data[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return data[front];
        }

        // function to print queue
        public void printQueue() {
            int i = Math.abs(rear - front + 1);
            int j = front;
            while (i > 0) {
                System.out.print(data[j] + " ");
                i--;
                j = (j + 1) % size;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        q.printQueue();
        System.out.println(q.remove());
        q.printQueue();
        q.add(6);
        q.printQueue();
        System.out.println(q.remove());
        q.remove();
        q.printQueue();
        q.add(7);
        q.printQueue();
    }
}
