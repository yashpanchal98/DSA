class LRUCache {
    private static class Node implements Comparable<Node> {
        int key, value;
        long time; // last access time

        Node(int key, int value, long time) {
            this.key = key;
            this.value = value;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            if (this.time == other.time) {
                return Integer.compare(this.key, other.key); 
            }
            return Long.compare(this.time, other.time);
        }
    }

    private final int capacity;
    private long timestamp = 0; 
    private final Map<Integer, Node> map;
    private final TreeSet<Node> set;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.set = new TreeSet<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        set.remove(node);             
        node.time = ++timestamp;      
        set.add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            set.remove(node);
            node.value = value;
            node.time = ++timestamp;
            set.add(node);
        } else {
            if (map.size() == capacity) {
                Node lru = set.first();   
                set.remove(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key, value, ++timestamp);
            map.put(key, node);
            set.add(node);
        }
    }
}