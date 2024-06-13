package arraysHash;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCases; i++) {
            int numLines = scanner.nextInt();
            scanner.nextLine();

            int totalHash = 0;
            for (int j = 0; j < numLines; j++) {
                String line = scanner.nextLine();
                totalHash += calculateHash(line, j);
            }

            System.out.println(totalHash);
        }

        scanner.close();
    }

    public static int calculateHash(String line, int lineIndex) {
        int hash = 0;
        for (int i = 0; i < line.length(); i++) {
            int positionInAlphabet = line.charAt(i) - 'A';
            hash += positionInAlphabet + lineIndex + i;
        }
        return hash;
    }
}

class HashTable<K,V> implements Map<K,V> {

    private int size;
    private Node<Entry<K,V>>[] hashTable;

    public HashTable(int mapSize) {
        hashTable = new Node[mapSize];
    }

    public static int hashCode(String key) {
        int hashCode = 0;
        int a = 5;

        for (int i = 0; i < key.length(); i++) {
            hashCode = hashCode << a | hashCode >>> (32 - a);
            hashCode += key.charAt(i);
        }

        return hashCode;
    }

    public int compression(int hashCode) {
        int comp = hashCode % hashTable.length;

        if (comp < 0) {
            comp *= -1;
        }

        return comp;
    }

    public int hashFunction(K key) {
        if (key instanceof String) {
            return compression(hashCode((String) key));
        }

        throw new RuntimeException("Hash Function does not support that data type");
    }

    @Override
    public Entry<K, V> delete(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry<K, V> get(K key) {
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
        Entry<K,V> entry = new HashEntry<>(key, value);
        Node<Entry<K,V>> newNode = new Node(entry);

        if(hashTable[index] == null) {
            hashTable[index] = newNode;
        } else {
            Node<Entry<K,V>> auxNode = hashTable[index];
          
            while(auxNode!=null) {
                if(auxNode.entry.getKey().equals(key)){
                    auxNode.entry.setValue(value);
                    return;
                }

                auxNode = auxNode.next;
            }

            newNode.next = hashTable[index];
            hashTable[index].previous = newNode;
            hashTable[index] = newNode;
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

        for(int i = 0; i < hashTable.length; i++) {
            sb.append(i);
            sb.append(":");

            Node<Entry<K,V>> auxNode = hashTable[i];
            while(auxNode!=null) {
                sb.append("\n    ");
                sb.append(auxNode.entry);

                auxNode = auxNode.next;
            }

            sb.append("\n");
        }

        return sb.toString();
    }    
}

interface Entry<K,V> {
    K getKey();
    V getValue();
    void setValue(V value);
}

class HashEntry<K,V> implements Entry<K,V> {

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

    public void setKey(K key) {
        this.key = key;
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

interface Map<K,V> {
    void put(K key, V value);
    Entry<K,V> get(K key);
    Entry<K,V> delete(K key);
    int size();
    boolean isEmpty();
}

class Node<E> {
    E entry;
    Node<E> next;
    Node<E> previous;

    public Node(E entry) {
        this.entry = entry;
    }
}
