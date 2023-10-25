package org.example;

public class MyContainer<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyContainer() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T item) {
        if (size == elements.length) {
            resizeArray();
        }
        elements[size] = item;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) elements[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        elements[size] = null;
    }

    public int size() {
        return size;
    }

    private void resizeArray() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public static void main(String[] args) {
        MyContainer<String> container = new MyContainer<>();
        container.add("Item 1");
        container.add("Item 2");
        container.add("Item 3");

        System.out.println("Container size: " + container.size());

        for (int i = 0; i < container.size(); i++) {
            System.out.println("Item " + i + ": " + container.get(i));
        }

        container.remove(1);
        System.out.println("After removing item 1:");
        for (int i = 0; i < container.size(); i++) {
            System.out.println("Item " + i + ": " + container.get(i));
        }
    }
}
