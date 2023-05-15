import java.util.*;

public class BST {
    private Node root;

    class Node {
        Node right;
        Node left;
        int value;

        Node(int value) {
            this.value = value;
        }

    }

    public BST() {
        this.root = null;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) {
                return false;
            }
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;

                }
                temp = temp.right;
            }
        }

    }

    public boolean contains(int value) {
        if (root == null) {
            return false;
        }
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;

            } else {
                return true;
            }
        }
        return false;
    }

    public void InOrderTraversal() {
        InOrderTraversal(root);
    }

    private void InOrderTraversal(Node node) {

        if (node != null) {
            InOrderTraversal(node.left);
            System.out.print(node.value + " ");
            InOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void PostOrderTraversal() {
        PostOrderTraversal(root);
    }

    private void PostOrderTraversal(Node node) {
        if (node != null) {
            PostOrderTraversal(node.left);
            PostOrderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }

    public int findMin() {
        if (root == null) {
            throw new Error("The tree is empty");
        }
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.value;

    }

    public int findMax() {
        if (root == null) {
            throw new Error("The tree is empty");
        }
        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.value;

    }

    public ArrayList<Integer> BFS() {
        Node currNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (currNode != null)
            queue.add(currNode);
        while (!queue.isEmpty()) {
            currNode = queue.remove();
            result.add(currNode.value);
            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }
        return result;
    }

    public ArrayList<Integer> DFS() {
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse {
            Traverse(Node currNode) {
                result.add(currNode.value);
                if (currNode.left != null) {
                    new Traverse(currNode.left);
                }
                if (currNode.right != null) {
                    new Traverse(currNode.right);
                }
            }
        }
        new Traverse(root);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements to add : ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter the element to search in the tree: ");
        int search = sc.nextInt();
        sc.close();
        BST bst = new BST();
        for (int i = 0; i < n; i++) {
            bst.insert(a[i]);
        }
        ArrayList<Integer> bfs = bst.BFS();
        System.out.println("BFS: ");
        for (int num : bfs)
            System.out.print(num + " ");
        System.out.println();
        ArrayList<Integer> dfs = bst.DFS();
        System.out.println("DFS: ");
        for (int num : dfs)
            System.out.print(num + " ");
        System.out.println();
        System.out.print("INORDER TRAVERSAL: ");
        bst.InOrderTraversal();
        System.out.println();
        System.out.print("PREORDER TRAVERSAL: ");
        bst.preOrderTraversal();
        System.out.println();
        System.out.print("POSTORDER TRAVERSAL: ");
        bst.PostOrderTraversal();
        System.out.println();

        System.out.println(bst.contains(search) ? "Yes" : "No");
        int min = bst.findMin();
        int max = bst.findMax();
        System.out.println("The minimum element in the tree is : " + min);
        System.out.println("The minimum element in the tree is : " + max);

    }
}
