package tabelasHash;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            int M = scanner.nextInt();
            int C = scanner.nextInt();
            scanner.nextLine();
            
            HashTable<Integer, Integer> hashTable = new HashTable<>(M);

            for (int c = 0; c < C; c++) {
                int key = scanner.nextInt();
                hashTable.put(key, key);
            }
            scanner.nextLine();
            
            System.out.println(hashTable);
            if (t < testCases - 1)
                System.out.println();
        }

        scanner.close();
    }
}

class HashTable<K, V> implements Map<K, V> {

    private int size;
    private Node<Entry<K, V>>[] hashTable;

    public HashTable(int mapSize) {
        hashTable = new Node[mapSize];
    }

    public int hashFunction(K key) {
        return ((Integer) key) % hashTable.length;
    }

    @Override
    public V delete(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(K key, V value) {
        int index = hashFunction(key);
        Entry<K, V> entry = new HashEntry<>(key, value);
        Node<Entry<K, V>> newNode = new Node<>(entry);

        if (hashTable[index] == null) {
            hashTable[index] = newNode;
        } else {
            Node<Entry<K, V>> auxNode = hashTable[index];

            while (auxNode.next != null) {
                auxNode = auxNode.next;
            }

            auxNode.next = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < hashTable.length; i++) {
            sb.append(i);
            sb.append(" ->");

            Node<Entry<K, V>> auxNode = hashTable[i];
            while (auxNode != null) {
                sb.append(" ");
                sb.append(auxNode.entry.getKey());
                sb.append(" ->");
                auxNode = auxNode.next;
            }

            sb.append(" \\");
            sb.append("\n");
        }

        return sb.toString();
    }
}

interface Entry<K, V> {
    K getKey();
    V getValue();
    void setValue(V value);
}

class HashEntry<K, V> implements Entry<K, V> {

    private K key;
    private V value;

    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + key + ":" + value + "}";
    }
}

interface Map<K, V> {
    void put(K key, V value);
    V get(K key);
    V delete(K key);
    int size();
    boolean isEmpty();
}

class Node<E> {
    E entry;
    Node<E> next;

    public Node(E entry) {
        this.entry = entry;
    }
}
