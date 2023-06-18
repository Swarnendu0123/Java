import java.util.*;

public class HashMapCode {

    static class HashMap<K, V> {
        // node defination
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // total number of nodes
        private int N = 1; // size of array
        private LinkedList<Node> buckets[]; // N

        @SuppressWarnings("unchecked") // this line will subpress the wearnings
        public HashMap() {
            this.n = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < buckets.length; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // hashing function
        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        // function to search at particular index
        private int searchInIndex(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return i;
                }
            }
            return -1;
        }

        // function for re hashing
        @SuppressWarnings("unchecked")
        public void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;
            // initialization of new bucket linkedlist
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        // function to put at a particular index
        public void put(K key, V value) {
            int bi = hashFunction(key);
            // bucket index
            int di = searchInIndex(key, bi);
            // data index
            // valid or -1
            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;

            } else {
                Node newNode = new Node(key, value);
                buckets[bi].add(newNode);
                n++;
            }
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        // contains key function
        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInIndex(key, bi);
            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        // function to get value
        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInIndex(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        // function to remove a node
        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInIndex(key, bi);
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        // function to get all keys of a hash map
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        boolean isEmpty() {
            if (n == 0) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Chaina", 100);
        hm.put("India", 120);
        hm.put("USA", 70);
        hm.put("Indonasia", 120);

        ArrayList<String> keys = hm.keySet();
        System.out.println(keys);
        System.out.println(hm.remove("USA"));
        keys = hm.keySet();
        System.out.println(keys);
    }

}