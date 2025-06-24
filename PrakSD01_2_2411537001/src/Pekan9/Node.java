package Pekan9;
//Arkan Ubaidillah Warman
//2411537001
public class Node {
    int data;
    Node left;
    Node right;
    
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
    
    public void setLeft(Node node) {
        if (left == null)
            left = node;
    }
    
    public void setRight(Node node) {
        if (right == null)
            right = node;
    }
    
    public Node getLeft() {
        return left;
    }
    
    public Node getRight() {
        return right;
    }
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    void printPreorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
    
    void printPostorder(Node node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }
    
    void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
    
    public String print() {
        return this.print("", true, "");
    }
    
    public String print(String prefix, boolean isTail, String sb) {
        if (right != null) {
            right.print(prefix + (isTail ? "│   " : "    "), false, sb);
        }
        System.out.println(prefix + (isTail ? "└── " : "┌── ") + data);
        if (left != null) {
            left.print(prefix + (isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }
}