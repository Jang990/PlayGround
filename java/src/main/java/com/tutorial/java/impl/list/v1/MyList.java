package com.tutorial.java.impl.list.v1;

public class MyList<T> {
    private MyNode<T> start;
    private MyNode<T> last;
    private int size;

    public MyList() {
        this.size = 0;
    }

    public void add(T instance) {
        add(size, instance);
    }

    public void add(int idx, T instance) {
        MyNode<T> node = new MyNode<>(instance);
        if (size == 0) {
            addFirst(node);
            return;
        }

        if (size == idx) {
            addLast(node);
            return;
        }

        addMiddle(node, idx);
    }

    public T get(int idx) {
        return searchNode(idx).instance;
    }

    public int size() {
        return size;
    }

    public boolean contains(T val) {
        return searchNode(val) != null;
    }

    public boolean remove(T val) {
        MyNode<T> target = searchNode(val);
        if(target == null)
            return false;

        if (target == start) {
            removeStartNode();
            return true;
        }

        if (target == last) {
            removeLastNode();
            return true;
        }

        size--;
        connect(target.prev, target.next);
        target.next = null;
        target.prev = null;
        return true;
    }

    private void removeLastNode() {
        size--;
        MyNode<T> newLast = last.prev;
        newLast.next = null;
        if(last == start)
            start = newLast;
        last = newLast;
    }

    private void removeStartNode() {
        size--;
        if (size == 0) {
            start = null;
            last = null;
            return;
        }

        MyNode<T> newStart = start.next;
        start = newStart;
        newStart.prev = null;
    }

    private void addMiddle(MyNode<T> node, int idx) {
        size++;
        MyNode<T> target = searchNode(idx);
        MyNode<T> targetPrev = target.prev;

        connect(targetPrev, node);
        connect(node, target);
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

    private MyNode<T> searchNode(T val) {
        if(start == null)
            return null;

        MyNode<T> current = start;
        while (current != null) {
            if(current.instance.equals(val))
                return current;
            current = current.next;
        }

        return null;
    }

    private void addLast(MyNode<T> node) {
        size++;
        connect(last, node);
        last = node;
    }

    private void connect(MyNode<T> prev, MyNode<T> next) {
        prev.next(next);
        next.prev(prev);
    }

    private void addFirst(MyNode<T> node) {
        size++;
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
            sb.append(current.instance).append(", ");
            if(current.hasNext())
                current = current.next;
            else
                break;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }

    static class MyNode<T> {
        private final T instance;
        private MyNode<T> next;
        private MyNode<T> prev;

        public MyNode(T instance) {
            this.instance = instance;
        }

        public void next(MyNode<T> next) {
            this.next = next;
        }

        public void prev(MyNode<T> prev) {
            this.prev = prev;
        }

        public MyNode<T> getNext() {
            return next;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
