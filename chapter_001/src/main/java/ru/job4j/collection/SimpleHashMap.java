package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node<K, V>> {

    private Node[] store;
    private int modCount;
    private int size;

    public SimpleHashMap() {
        this.store = new Node[1 << 2];
    }

    boolean insert(K key, V value) {
        resizeIfNeed();
        boolean result = false;
        Node<K, V> node = new Node<>(key, value);
        int index = indexFor(node.hash, this.store.length);
        if (this.store[index] == null) {
            this.store[index] = node;
            result = true;
            this.modCount++;
            this.size++;
        }
        return result;
    }

    V get(K key) {
        V result = null;
        int index = indexFor(hashCalc(key), this.store.length);
        if ((this.store[index].getKey() == null && key == null)
                || (this.store[index].getKey().equals(key))) {
            result = (V) this.store[index].value;
        }
        return result;
    }

    boolean delete(K key) {
        boolean result = false;
        int index = indexFor(hashCalc(key), this.store.length);
        if (this.store[index] != null
                && ((this.store[index].getKey() == null && key == null)
                || (this.store[index].getKey().equals(key)))) {
            this.store[index] = null;
            result = true;
            this.modCount++;
            this.size--;
        }
        return result;
    }

    private void resizeIfNeed() {
        if (this.size == this.store.length) {
            Node[] newSizeStore = new Node[this.store.length << 1];
            for (Node node : this.store) {
                newSizeStore[indexFor(node.hash, newSizeStore.length)] = node;
            }
            this.store = newSizeStore;
        }
    }

    private static int hashCalc(Object key) {
        int result = 0;
        if (key != null) {
            int h = key.hashCode();
            result =  h ^ (h >>> 16);
        }
        return result;
    }

    private int indexFor(int hash, int length) {
        return (length - 1) & hash;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            int position = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean result = false;
                for (int i = position; !result && i < store.length; i++) {
                    if (store[i] != null) {
                        result = true;
                        position = i;
                    }
                }
                return result;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (Node<K, V>) store[position++];
            }
        };
    }

    static class Node<K, V> {
        private K key;
        private V value;
        private int hash;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = hashCalc(key);
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }
    }
}
