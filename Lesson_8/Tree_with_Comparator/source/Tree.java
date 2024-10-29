import java.util.Comparator;

class Tree<T> {
    public static void main(String[] args) {

    }

    class Node {
        public T value;
        public Node left;
        public Node right;

        Node(T value) {
            this.value = value;
        }
    };

    private Node root;
    private Comparator<T> comparator;

    public Tree(Comparator<T> comparator) {
        root = null;
        this.comparator = comparator;
    }

    /*public Tree(Comparator<T> comparator) throws Exception {
        root = null;
        this.comparator = comparator;
    }*/

    /*public void setComparator(Comparator<T> comparator){
        this.comparator = comparator;
    }*/

    /*public Tree(Node root) {
        this.root = root;
    }

    public Tree(T value) {
        this.root.value = value;
    }*/

    public void add(T value) {
        root = add(value, root);
    }

    private Node add(T value, Node current) {
        if (current == null) {
            return new Node(value);
        }
        int compare = comparator.compare(value, current.value);
        if (compare < 0) {
            current.left = add(value, current.left);
        } else {
            current.right = add(value, current.right);
        }
        return current;
    }

    public boolean find(T value) {
        return find(value, root);
    }

    private boolean find(T value, Node current) {
        if (current == null) {
            return false;
        }
        int compare = comparator.compare(value, current.value);
        if (compare == 0) {
            return true;
        } else {
            if (compare < 0) {
                return find(value, current.left);
            }
            return find(value, current.right);
        }
    }

    // PRINT : Left - Vertex - Right
    public void printLVRln() {
        printLVR(root);
        System.out.println();
    }

    public void printLVR() {
        printLVR(root);
    }

    private void printLVR(Node current) {
        if (current == null) {
            return;
        }
        printLVR(current.left);
        System.out.print(current.value + " ");
        printLVR(current.right);
    }

    // PRINT : Left - Right - Vertex
    public void printLRVln() {
        printLRV(root);
        System.out.println();
    }

    public void printLRV() {
        printLRV(root);
    }

    private void printLRV(Node current) {
        if (current == null) {
            return;
        }
        printLRV(current.left);
        printLRV(current.right);
        System.out.print(current.value + " ");
    }

    // PRINT : Vertex - Left - Right
    public void printVLRln() {
        printVLR(root);
        System.out.println();
    }

    public void printVLR() {
        printVLR(root);
    }

    private void printVLR(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.value + " ");
        printVLR(current.left);
        printVLR(current.right);
    }

    public void remove(T value) {
        root = remove(value, root);
    }

    private Node remove(T value, Node current) {
        if (current == null) {
            return null;
        }
        int compare = comparator.compare(value, current.value);
        if (compare < 0) {
            current.left = remove(value, current.left);
        } else if (compare > 0) {
            current.right = remove(value, current.right);
        } else {
            // Leaf
            if (current.left == null && current.right == null) {
                return null;
            }
            // One child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            // Two children
            T mostLeftAtRight = findMostLeftAtRight(current.right);
            current.value = mostLeftAtRight;
            current.right = remove(mostLeftAtRight, current.right);
        }
        return current;
    }

    private T findMostLeftAtRight(Node current) {
        return (current.left == null) ? (current.value) : (findMostLeftAtRight(current.left));
    }
}