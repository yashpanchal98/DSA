class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1; 
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void add(Node node) {
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeHead() {
            if (size > 0) {
                Node node = head.next;
                remove(node);
                return node;
            }
            return null;
        }
    }

    private int capacity, minFreq;
    private Map<Integer, Node> keyMap; 
    private Map<Integer, DoublyLinkedList> freqMap; 

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;
        Node node = keyMap.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyMap.size() >= capacity) {
                DoublyLinkedList minList = freqMap.get(minFreq);
                Node toRemove = minList.removeHead();
                keyMap.remove(toRemove.key);
            }
            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);
            freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).add(newNode);
            minFreq = 1; 
        }
    }
    private void updateFreq(Node node) {
        int freq = node.freq;
        DoublyLinkedList oldList = freqMap.get(freq);
        oldList.remove(node);

        if (freq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).add(node);
    }
}