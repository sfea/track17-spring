package track.lessons.lesson3;

import java.util.NoSuchElementException;

/**
 * Должен наследовать List
 * Односвязный список
 */
public class MyLinkedList extends List {

    /**
     * private - используется для сокрытия этого класса от других.
     * Класс доступен только изнутри того, где он объявлен
     * <p>
     * static - позволяет использовать Node без создания экземпляра внешнего класса
     */


    /** исправил поля класса Node, так как сказано,
     * что список должен быть односвязным
    */
    private int pointer = 0;
    public static final int DEFAULT_CAPACITY = 16;

    private static class Node {
        Node next;
        int val;

        Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
    }

    public Node[] nodes = new Node[DEFAULT_CAPACITY];

    public void resize(Node[] array, int newlength) {
        Node[] newArray = new Node[newlength];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    void add(int item) {
        if (pointer >= nodes.length - 1) {
            resize(nodes, (nodes.length + 1) * 2);
        }
        if (pointer == 0) {
            nodes[pointer] = new Node(null, item);
        } else if (pointer > 0) {
            nodes[pointer] = new Node(null, item);
            nodes[pointer - 1].next = nodes[pointer];
        }
        pointer++;
    }

    @Override
    int remove(int idx) throws NoSuchElementException {
        if (idx < 0 || idx >= pointer) {
            throw new NoSuchElementException();
        }
        if (idx != 0 && idx != pointer - 1) {
            nodes[idx - 1].next = nodes[idx + 1];
            System.arraycopy(nodes, idx + 1, nodes, idx, pointer - idx);
        } else if (idx == 0 && pointer == 1) {
            nodes[idx].next = null;
        } else if (idx == 0) {
            System.arraycopy(nodes, idx + 1, nodes, idx, pointer - idx);
        } else if (idx == pointer - 1) {
            nodes[idx - 1].next = null;
        }
        pointer--;
        return 0;
    }

    @Override
    int get(int idx) throws NoSuchElementException {
        if (idx < 0 || idx >= pointer) {
            throw new NoSuchElementException();
        }
        return nodes[idx].val;
    }

    @Override
    int size() {
        return pointer;
    }
}