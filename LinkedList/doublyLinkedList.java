import java.util.*;

public class doublyLinkedList {

    public static class Node {
        int data; // node data
        Node next; // points towards next node
        Node prev; // points towards prev node

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // function to print linkedlist
    public void Print() {
        if (head == null) {
            System.out.print("Linked list is empty, size: 0");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        // printing size
        System.out.print("size: " + size);
        System.out.println();
    }

    // adding oprations
    // function to add first
    public void addFirst(int data) {
        // createing a node
        Node newNode = new Node(data);
        if (size == 0) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = head.prev;
        size++;
    }

    // function to add last popsition in a linkedlist
    public void addLast(int data) {
        // creating a node
        Node newNode = new Node(data);
        if (size == 0) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = tail.next;
        size++;
    }

    // removing oprations
    // function to remove first node
    public int removeFirst() {
        if (size == 0) {
            System.out.println("lnkedList is empty");
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            int temp = head.data;
            head = tail = null;
            size--;
            return temp;
        }
        int temp = head.data;
        head = head.next;
        head.prev.next = null;
        head.prev = null;
        size--;
        return temp;
    }

    // function to remove last node
    public int removeLast() {
        if (size == 0) {
            System.out.println("lnkedList is empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int temp = head.data;
            head = tail = null;
            size--;
            return temp;
        }
        int temp = tail.data;
        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;
        size--;
        return temp;
    }

    // function to reverse a linkedlist
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        doublyLinkedList dll = new doublyLinkedList();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        // dll.Print();
        // System.out.println("Removed data: " + dll.removeFirst());
        // dll.Print();
        // System.out.println("Removed data: " + dll.removeLast());
        // dll.Print();
        // System.out.println("Removed data: " + dll.removeLast());
        // dll.Print();
        // System.out.println("Removed data: " + dll.removeLast());
        // dll.Print();
        dll.Print();
        dll.reverse();
        dll.Print();
    }
}
