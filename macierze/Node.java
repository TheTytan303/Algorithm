package macierze;

public class Node <T> {
    private T element;
    private Node<T> nextElement;
    public Node(T val, Node<T> next){
        this.element=val;
        this.nextElement = next;
    }
    public T getElements() {
        return element;
    }
    public Node<T> getNextElement() {
        return nextElement;
    }
    public void setElement(T val){
        this.element = val;
    }
    public void setNextElement(T val){
        this.nextElement= new Node<T>(val, null);
    }
}
