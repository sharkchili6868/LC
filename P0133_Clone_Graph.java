class Solution {
	// DFS
    private Map<Node, Node> map = new HashMap<>();
	public Node cloneGraph(Node node) {
		if (node == null) return null;

		if (map.containsKey(node)) return map.get(node);

		Node copy = new Node(node.val);
		map.put(node, copy);

		for(Node n : node.neighbors) {
			copy.neighbors.add(cloneGraph(n));
		}

		return copy;
	}

	// BFS
	public Node cloneGraphBFS(Node node) {
		if (node == null) return null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		Map<Node, Node> map = new HashMap<>();
		Node copy = new Node(node.val);
		map.put(node, copy);

		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			for(Node nei : cur.neighbors) {
				if (map.containsKey(nei)) {
					map.get(cur).neighbors.add(map.get(nei));
				} else {
					Node neiCopy = new Node(nei.val);
					map.put(nei, neiCopy);
					map.get(cur).neighbors.add(neiCopy);
					queue.add(nei);
				}
			}
		}

		return copy;
	}
}