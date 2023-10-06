package gbLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class GBLinkedList<T> implements GBList<T> {
    private GBNode<T> first;
    private GBNode<T> last;
    private int size = 0;

    public GBLinkedList() {
        first = new GBNode<>(null, null, null);
        last = new GBNode<>(null, first, null);
        first.setNext(last);
    }

    @Override
    public T get(int index) {
        GBNode<T> element = first.getNext();
        for (int i = 0; i < index; i++) {
            element = element.getNext();
        }
        return element.getItem();
    }

    @Override
    public void addLast(T t) {
        GBNode<T> prev = last.getPrev();
        GBNode<T> addNode = new GBNode<>(t, prev, last);
        last.setPrev(addNode);
        prev.setNext(addNode);
        size++;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return get(index++);
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());

        if (size < 1) return sb.toString();
        sb.append( " ");
        for (T el: this) {
            sb.append(" -");
            sb.append(el);
            sb.append("- ");
        }

        return sb.toString();
    }
}
