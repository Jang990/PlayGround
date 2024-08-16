package com.tutorial.java.impl.list.v1;

public class MyList<T> {
    private MyNode<T> start;
    private MyNode<T> last;
    private int size;

    public MyList() {
        this.size = 0;
    }

    public void add(T instance) {
        add(instance, size);
    }

    public void add(T instance, int idx) {
        MyNode<T> node = new MyNode<>(instance);
        if (size == 0) {
            size++;
            addFirst(node);
            return;
        }

        if (size == idx) {
            size++;
            addLast(node);
            return;
        }

        size++;
        addMiddle(node, idx);
    }

    public T get(int idx) {
        return searchNode(idx).instance;
    }

    public int size() {
        return size;
    }

    private void addMiddle(MyNode<T> node, int idx) {
        MyNode<T> prevNode = searchNode(idx - 1);
        node.link(prevNode.next);
        prevNode.link(node);
    }

    private MyNode<T> searchNode(int idx) {
        if(idx >= size)
            throw new IndexOutOfBoundsException();
        MyNode<T> current = start;
        for (int i = 0; i < idx; i++) {
            current = current.getNext();
        }

        return current;
    }

    private void addLast(MyNode<T> node) {
        last.link(node);
        last = node;
    }

    private void addFirst(MyNode<T> node) {
        start = node;
        last = node;
    }

    @Override
    public String toString() {
        if(start == null)
            return "[]";
        MyNode<T> current = start;

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (true) {
            sb.append(current.instance).append(",");
            if(current.hasNext())
                current = current.next;
            else
                break;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }

    static class MyNode<T> {
        private final T instance;
        private MyNode<T> next;

        public MyNode(T instance) {
            this.instance = instance;
        }

        public void link(MyNode<T> next) {
            this.next = next;
        }

        public MyNode<T> getNext() {
            return next;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
