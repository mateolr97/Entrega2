public class Node {
    private Enemigo key;
    private Node right;
    private Node left;
    private Node parent;
    private int height;

    public Node(Enemigo key) {
        this.key = key;
    }

    public Node() {
    }

    public Enemigo getKey() {
        return key;
    }

    public void setKey(Enemigo key) {
        this.key = key;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }    

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
}