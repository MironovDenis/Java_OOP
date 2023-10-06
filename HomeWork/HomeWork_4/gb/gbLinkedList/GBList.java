package gbLinkedList;

public interface GBList <T> extends Iterable<T>{
    T get(int index); // получение элемента по индексу
    void addLast(T t); // добавление элемента в конец списка
    int size(); // размер списка
}
