package gbLinkedList;


public class GBNode<T> {
    private T item;
    private GBNode<T> prev;
    private GBNode<T> next;

    public GBNode(T item, GBNode<T> prev, GBNode<T> next){
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public GBNode<T> getPrev() {
        return prev;
    }

    public GBNode<T> getNext() {
        return next;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setPrev(GBNode<T> prev) {
        this.prev = prev;
    }

    public void setNext(GBNode<T> next) {
        this.next = next;
    }
}
