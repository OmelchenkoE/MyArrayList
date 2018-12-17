package main;

import java.util.Collection;

class Node {
    Node(Object currentEl) {
        this.currentEl = currentEl;
        this.nextEl = nextEl;
    }

    Object currentEl;
    Node nextEl;
}

public class MyLinkedList implements SimpleList {
    Node first;
    Node last;
    private int count = 0;

    @Override
    public Object get(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.nextEl;
        }
        return node.currentEl;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        count--;
        Object o;
        Node node = first;
        for (int i = 0; i < index - 1; i++) {
            node = node.nextEl;
        }
        if (index == 0) {
            o = node.currentEl;
            first = node.nextEl;
        } else {
            o = node.nextEl.currentEl;
            node.nextEl = node.nextEl.nextEl;
        }
        return o;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return first == null && last == null;
    }

    @Override
    public boolean add(Object o) {
        Node node = new Node(o);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.nextEl = node;
            last = node;
        }
        count++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
}
