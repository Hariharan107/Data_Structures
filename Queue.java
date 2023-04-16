import java.util.Scanner;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;

        }
    }

    public Queue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public void getFirst() {
        System.out.println("First: " + first.value);
    }

    public void getLast() {
        System.out.println("Last: " + last.value);
    }

    public void getlength() {
        System.out.println("Length: " + length);
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public void Dequeue() {
        if (first == null)
            return;
        if (length == 1) {
            first = null;
            last = null;
            length = 0;
            return;
        }
        Node temp = first;
        first = first.next;
        temp.next = null;
        length--;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue();
        System.out.println("Enter the length of the queue");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements for the queue");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            queue.enqueue(a[i]);
        }
        queue.printQueue();
        queue.Dequeue();
        queue.printQueue();

        sc.close();
    }
}
