import java.util.*;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length = 0;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
    // public LinkedList(int value) {
    // Node newNode = new Node(value);
    // head = newNode;
    // tail = newNode;
    // length++;

    // }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void printList() {
        Node temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
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

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;

    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;

        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;

    }

    public Node removeFirst() {
        if (length == 0)
            return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node removeLast() {
        if (length == 0)
            return null;
        if (length == 1) {
            head = null;
            tail = null;
            length = 0;
            return null;
        }
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;

        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;

    }

    public Boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public Node removeItem(int index, int value) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1)
            return removeLast();
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Boolean insert(int index, int value) {
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
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;

    }

    // public void reverse() {
    // if (length <= 1) {
    // return;
    // }
    // Node previousNode = null;
    // Node currentNode = head;
    // Node nextNode = null;
    // while (currentNode != null) {
    // nextNode = currentNode.next;
    // currentNode.next = previousNode;
    // previousNode = currentNode;
    // currentNode = nextNode;
    // }
    // tail = head;
    // head = previousNode;
    // }
    public void reverse() {
        if (length <= 1)
            return;
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void createLoop(int index) {
        if (head == null || index >= length)
            return;
        Node loop = get(index);
        if (loop != null)
            loop.next = head;

    }

    public boolean hasLoop() {
        if (head == null)
            return false;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If the slow and fast pointers meet, there is a loop
            if (slow == fast) {
                return true;
            }
        }

        // If the loop terminates, there is no loop
        return false;
    }

    public Node Search(int value) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < length; i++) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void removeDuplicates(Node head) {
        if (head == null)
            return;

        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                    length--;
                } else {
                    runner = runner.next;
                }

            }
            current = current.next;
        }
    }

    // public LinkedList mergeLinkedList(LinkedList list1, LinkedList list2) {
    // if (list1.length == 0) {
    // return list2;
    // }
    // if (list2.length == 0) {
    // return list1;
    // }
    // LinkedList mergedList = new LinkedList();
    // Node Current1 = list1.head;
    // Node Current2 = list2.head;
    // while (Current1 != null && Current2 != null) {
    // if (Current1.value < Current2.value) {
    // mergedList.append(Current1.value);
    // Current1 = Current1.next;
    // } else if (Current2.value < Current1.value) {
    // mergedList.append(Current2.value);
    // Current2 = Current2.next;
    // } else if (Current1.value == Current2.value) {
    // mergedList.append(Current1.value);
    // Current1 = Current1.next;
    // Current2 = Current2.next;
    // }

    // }
    // while (Current1 != null) {
    // mergedList.append(Current1.value);
    // Current1 = Current1.next;
    // }
    // while (Current2 != null) {
    // mergedList.append(Current2.value);
    // Current2 = Current2.next;
    // }

    // return mergedList;

    //
    public void merge(LinkedList list1, LinkedList list2) {
        if (list1.head == null) {
            head = list2.head;
        } else if (list2.head == null) {
            head = list1.head;
        } else {
            head = list1.head;
            list1.tail.next = list2.head;
        }
        if (list2.tail != null) {
            tail = list2.tail;
        } else {
            tail = list1.tail;
        }
    }

    public void sort(Node head) {
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            while (next != null) {
                if (current.value > next.value) {
                    int temp = current.value;
                    current.value = next.value;
                    next.value = temp;
                }
                next = next.next;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        LinkedList myLinkedList = new LinkedList();

        for (int i = 0; i < size; i++) {
            myLinkedList.append(array[i]);
        }
        scanner.close();
        LinkedList myLinkedList1 = new LinkedList();
        myLinkedList1.append(23);
        myLinkedList1.append(243);
        myLinkedList1.append(223);
        myLinkedList1.append(13);
        myLinkedList1.append(3);
        // myLinkedList1.printList();
        // myLinkedList.printList();

        myLinkedList.merge(myLinkedList, myLinkedList1);
        // myLinkedList.removeDuplicates(myLinkedList.head);
        // myLinkedList.sort(myLinkedList.head);
        myLinkedList.printList();
        // myLinkedList
        // merged.removeDuplicates();
        // merged.sort(merged);
        // merged.printList();
        // myLinkedList.reverse();
        // // System.out.print("List after removing duplicates: ");
        // myLinkedList.printList();
        // scanner.close();
    }
}
