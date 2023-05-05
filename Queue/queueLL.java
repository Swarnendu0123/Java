public class queueLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        // function to check queue is empty or not
        public static boolean isEmpty() {
            return (head == null) && (tail == null);
        }

        // function to add in queue
        public void add(int num) {
            Node newNode = new Node(num);
            if (isEmpty()) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // remove function
        public int remove() {
            // empty
            if (isEmpty()) {
                System.out.println("it is empty");
                return Integer.MIN_VALUE;
            }
            // single element
            int first = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            return first;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }

        // function to print queue
        public void printQueue() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.printQueue();
        System.out.println(q.remove());
        q.printQueue();
        q.add(6);
        q.printQueue();
        System.out.println(q.remove());
        q.printQueue();
        q.add(7);
        q.printQueue();
        q.remove();
        q.remove();
        q.remove();
        System.out.println(q.isEmpty());
    }
}
