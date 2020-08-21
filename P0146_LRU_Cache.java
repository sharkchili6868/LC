class LRUCache {
    
    private Node head;
	private Node tail;
	private Map<Integer, Node> cache;
	private int capacity;

	public LRUCache(int capacity) {
		this.head = new Node(0, 0);
		this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
		this.cache = new HashMap<>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) {
		int result = -1;
		Node node = cache.get(key);
		if (node != null) {
			result = node.val;
			removeNode(node);
			addNode(node);
		}

		return result;
	}

	public void put(int key, int val) {
		Node newNode = cache.get(key);
		if (newNode != null) {
			removeNode(newNode);
            newNode.val = val;
			addNode(newNode);
		} else {
			if (cache.size() >= capacity) {
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            
            newNode = new Node(key, val);
            addNode(newNode);
            cache.put(key, newNode);
		}
	}

	private void addNode(Node node) {
		Node nextOfHead = head.next;
		head.next = node;
		node.prev = head;

		node.next = nextOfHead;
		nextOfHead.prev = node;
	}

	private void removeNode(Node node) {
		Node prevNode = node.prev;
		Node nextNode = node.next;

		prevNode.next = nextNode;
		nextNode.prev = prevNode;
	}

	private static class Node {
		int key;
		int val;
		Node next;
		Node prev;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}