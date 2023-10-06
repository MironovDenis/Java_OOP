package gbLinkedList;

public class Main {
    public static void main(String[] args) {
        GBLinkedList<String> gbLinkedList = new GBLinkedList<>();
        gbLinkedList.addLast("Dog");
        gbLinkedList.addLast("Cat");
        gbLinkedList.addLast("Rat");
        System.out.println(gbLinkedList);
        System.out.println(gbLinkedList.get(2));
        System.out.println(gbLinkedList.size());
        gbLinkedList.addLast("Fish");
        System.out.println(gbLinkedList);
        System.out.println(gbLinkedList);
    }
}
