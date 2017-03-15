package track.lessons.lesson3;

import java.util.NoSuchElementException;

/**
 * Должен наследовать List
 * Односвязный список
 */
public class MyLinkedList extends List implements Stack, Queue {

    /**
     * private - используется для сокрытия этого класса от других.
     * Класс доступен только изнутри того, где он объявлен
     * <p>
     * static - позволяет использовать Node без создания экземпляра внешнего класса
     */

    public MyLinkedList() { }

    private static class Node {
        Node prev;
        Node next;
        int val;

        Node(Node prev, Node next, int val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }

    @Override
    public void add(int item) {
        Node prevTail = tail;
        Node node = new Node(prevTail, null, item);
        tail = node;
        if (prevTail == null) {
            head = node;
        } else {
            prevTail.next = node;
        }
        ++size;
    }

    @Override
    public int remove(int idx) throws NoSuchElementException {
        if (idx >= size) {
            throw new NoSuchElementException();
        }
        Node node = head;
        for (int i = 0; i < idx; ++i) {
            node = node.next;
        }
        Node next = node.next;
        Node prev = node.prev;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;

        }
        node.val = 0;
        size--;
        return node.val;
    }

    @Override
    public int get(int idx) throws NoSuchElementException {
        if (idx >= size) {
            throw new NoSuchElementException();
        }
        Node node = head;
        for (int i = 0; i < idx; ++i) {
            node = node.next;
        }
        return node.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(int item) {
        this.add(item);
    }

    @Override
    public int pop() throws NoSuchElementException {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        int item = tail.val;
        if (tail.prev == null) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
        --size;
        return item;
    }

    @Override
    public void enqueue(int item) {
        this.add(item);
    }

    @Override
    public int dequeue() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException();
        }
        int item = head.val;
        if (head.next == null) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
        --size;
        return item;
    }

    private Node head;
    private Node tail;
    private int size;

}
