import java.util.Scanner;

public class Stack {
    private Node top;
    private int height;

    class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }

    }

    public Stack() {
        this.top = null;
        this.height = 0;
    }

    public void getTop() {
        System.out.println("TOP :" + top.value);
    }

    public void getHeight() {
        System.out.println("HEIGHT :" + height);
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public void pop() {
        if (height == 0) {
            return;
        }
        if (height == 1) {
            top = null;
            height = 0;
            return;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        System.out.println("Enter the size to push to stack");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements to push to stack");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            stack.push(a[i]);
        }
        stack.printStack();
        stack.getHeight();
        stack.pop();
        stack.printStack();
        stack.getHeight();

        sc.close();

    }
}