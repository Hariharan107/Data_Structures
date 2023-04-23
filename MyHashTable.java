import java.util.*;

public class MyHashTable {
    private Node[] dataMap;
    private int size;

    class Node {
        Node next;
        String key;
        int value;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashTable(int size) {
        this.size = size;
        dataMap = new Node[size];
    }

    public List<String> getKeys() {
        List<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public void insert(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        throw new NoSuchElementException("Key not found: " + key);
    }

    private int hash(String key) {
        int hash = 0;
        char keyChars[] = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % size;
        }
        return hash;
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + " ");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println(" {" + temp.key + "= " + temp.value + "}");

                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the hash table: ");
        int size = sc.nextInt();

        MyHashTable hashTable = new MyHashTable(size);
        System.out.print("Enter the number of key-value pairs to insert: ");
        int numPairs = sc.nextInt();
        for (int i = 0; i < numPairs; i++) {
            System.out.print("Enter key for pair #" + (i + 1) + ": ");
            String key = sc.next();
            System.out.print("Enter value for pair #" + (i + 1) + ": ");
            int value = sc.nextInt();
            hashTable.insert(key, value);
        }
        hashTable.printTable();

        List<String> keys = hashTable.getKeys();
        System.out.println("Keys in the hash table: ");
        for (String key : keys) {
            System.out.print("{ " + key);
            System.out.print(" }");
        }
        sc.close();

    }
}
