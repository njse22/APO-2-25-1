package structures;

import java.util.Objects;
import java.util.UUID;

public class Node <T extends Comparable<T> > {
    private String id;
    private int index;
    private T data;

    private Node<T> next;
    private Node<T> previous;

    public Node(T data) {
        this.id = UUID.randomUUID().toString();
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    @Override
   public String toString() {
       return "Node{" +
               "data='" + data + '\'' +
               " index= " + index +
               '}';
   }
}
