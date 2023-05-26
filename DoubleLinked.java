import java.util.*;

public class DoubleLinked {
    private Node head;
    private Node tail;
    private int length = 0;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }

    }

    public DoubleLinked() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;

    }

    public void prepend(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    public Node removeFirst() {
        if (head == null)
            return null;
        if (length == 1) {
            head = null;
            tail = null;
            length = 0;
            return null;
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        length--;
        return temp;
    }

    public Node removeLast() {
        if (head == null) {
            return null;
        }
        if (length == 1) {
            head = null;
            tail = null;
            length = 0;
            return null;
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public Node get(int index) {

        if (index < 0 || index >= length)
            return null;
        Node temp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public Node search(int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void sortList() {

        // Node current will point to head
        Node current = head, index = null;

        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;

                while (index != null) {
                    // If current node's value is greater
                    // than index's node value, swap the value
                    // between them
                    if (current.value > index.value) {
                        temp = current.value;
                        current.value = index.value;
                        index.value = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;

    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }

    public Node removeItem(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        // Other Methodk
        // Node temp = get(index);
        // temp.next.prev = temp.prev;
        // temp.prev.next = temp.next;
        // temp.next=null;
        // tem.prev=null;
        Node before = get(index - 1);
        Node after = before.next.next;k
        before.next = after;
        after.prev = before;
        length--;
        return before;
    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                    if (runner.next != null) {
                        runner.next.prev = runner;
                    } else {
                        tail = runner;
                    }
                    length--;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        DoubleLinked dll = new DoubleLinked();

        for (int i = 0; i < n; i++) {
            dll.append(arr[i]);
        }
        dll.printList();
        dll.removeDuplicates();
        dll.printList();

        sc.close();
    }
}
