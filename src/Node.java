import java.util.ArrayList;

public class Node<T> {
    private T value;
    private int[] histogram;
    private ArrayList<Node<String>> children;

    public Node(T value) {
        this.value = value;
        this.histogram = new int[24];
        this.children = new ArrayList<Node<String>>();
    }

    public void setHistogram(){

    }

    public void addChildren(Node<String> newChildren){
        this.children.add(newChildren);
    }

    public T getValue() {
        return this.value;
    }
}