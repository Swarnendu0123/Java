import java.util.*;

public class LinkedList {
    // creation of node class inside linkedlist class
    public static class Node {
        int data;
        Node next;// points towards next node

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // dicleration of head and tail
    public static Node head;
    public static Node tail;
    public static int size;

    // function to add one node at front
    public void addFirst(int data) {
        // step 1 => create a new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step 2 => newNode.next=head
        newNode.next = head;
        // step 3 => head =newNode
        head = newNode;
    }

    // function to add one node at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // function to add a node in a perticular index
    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        int i = 0;
        Node temp = head;
        while (i < index - 1) {
            i++;
            temp = temp.next;
        }
        // step 1
        Node newNode = new Node(data);
        size++;
        // step 2
        newNode.next = temp.next;
        // step 3
        temp.next = newNode;
    }

    // function to remove first element
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size--;
            return value;
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    // function to remove last element
    public int removeLast() {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int i = 0;
        Node temp = head;
        int val = 0;
        while (temp.next.next != null) {
            i++;
            temp = temp.next;
            val = temp.next.data;
        }
        tail = temp.next = null;
        size--;
        return val;
    }

    // function to print linkedlist
    public void Print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // function to itrative search in a linkedlist
    public int search(int key) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (key == temp.data) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    // function to search in linkedlist by recurtion 3rd method
    public int search3(Node temp, int key, int index) {
        // base case
        if (temp == null) {
            return -1;
        }
        if (key == temp.data) {
            return index;
        }
        return search3(temp.next, key, index + 1);
    }

    // function to search in linkedlist by recurtion 2nd method
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int index = helper(head.next, key);
        if (index == -1) {
            return -1;
        }
        return index + 1;
    }

    public int search2(int key) {
        return helper(head, key);
    }

    // reverseing a linked list
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // find and remove Nth node from end
    // n>=1
    public int removeNthFromLast(int n) {
        if (n == size) {
            return removeFirst();
        }
        Node temp = head;
        for (int i = 0; i < size - n - 1; i++) {
            temp = temp.next;
        }
        size--;
        int val = temp.next.data;
        temp.next = temp.next.next;
        return val;
    }

    // function to find moddle node
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow;
    }

    // function to check LL is pelindrom or not
    public boolean checkPalindrome() {
        // corner cases
        if (head == null || head.next == null) {
            return true;
        }
        // step1 - find mid
        Node midNode = findMid(head);
        // step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;// head of right half
        Node left = head;
        // step3 -checking
        while (right != null) {
            if (right.data != left.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // function to check cycle in a linkedlist
    // floyd's cycle finding method
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // function to remove cycle
    public static void removeCycle() {
        // detect cycyle
        Node fast = head;
        Node slow = head;
        boolean cycle = false;
        while (fast.next != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        // find meeting point
        slow = head;
        while (fast.next != slow.next) {
            fast = fast.next;
            slow = slow.next;
        }
        // remove the cycle
        fast.next = null;
    }

    // function to merge new left and new right
    private static Node merge(Node head1, Node head2) {
        Node meargedLL = new Node(-1);
        Node temp = meargedLL;
        while (!(head1 == null || head2 == null)) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            temp = temp.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            temp.next = head2;
            temp = temp.next;
            head2 = head2.next;
        }
        return meargedLL.next;
    }

    // function to get mid
    private static Node findMid2(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast == null && fast.next == null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;// mid node
    }

    // function for merge sort
    // time complexity = O(nlog(n))
    public static Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = findMid2(head);
        // merge left and right part
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        // mearging step
        return merge(newLeft, newRight);
    }

    public void zigzag(Node head) {
        // find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;// middle
        // reversing the linkedlist
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // zigzag pattern
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while (left != null && right != null) {
            // zigzag pattern creation
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            // updation step
            left = nextL;
            right = nextR;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);

        ll.Print(head);
        ll.zigzag(head);
        ll.Print(head);
    }
}
