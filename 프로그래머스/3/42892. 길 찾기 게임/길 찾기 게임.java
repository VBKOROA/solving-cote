import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	public int[][] solution(int[][] nodeinfo) {
		List<Node> nodes = new ArrayList<>();

		for (int i = 0; i < nodeinfo.length; i++) {
			nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
		}

		nodes = nodes.stream()
			.sorted(Comparator.comparingInt((Node node) -> node.y).reversed().thenComparingInt(node -> node.x))
			.collect(Collectors.toList());

		Node rootNode = nodes.get(0);

		for (int i = 1; i < nodes.size(); i++) {
			Node parent = rootNode;
			Node current = nodes.get(i);
			while (true) {
				if (parent.x > current.x) {
					if (parent.left != null) {
						parent = parent.left;
						continue;
					}

					parent.left = current;
				} else {
					if (parent.right != null) {
						parent = parent.right;
						continue;
					}

					parent.right = current;
				}
				current.parent = parent;
				break;
			}
		}

		List<Integer> preOrder = new ArrayList<>();
		List<Integer> postOrder = new ArrayList<>();
		Deque<Node> stack = new ArrayDeque<>();
		stack.addLast(rootNode);

		while (!stack.isEmpty()) {
			Node curr = stack.pollLast();
			preOrder.add(curr.data);

			if (curr.right != null) {
				stack.addLast(curr.right);
			}

			if (curr.left != null) {
				stack.addLast(curr.left);
			}
		}

		Node prev = null;
		Node curr = rootNode;

		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				stack.addLast(curr);
				curr = curr.left;
			} else {
				Node peek = stack.peekLast();

				if (peek.right != null && peek.right != prev) {
					curr = peek.right;
				} else {
					prev = stack.pollLast();
					postOrder.add(prev.data);
				}
			}
		}

		int[][] answer = {
			preOrder.stream().mapToInt(Integer::intValue).toArray(),
			postOrder.stream().mapToInt(Integer::intValue).toArray()
		};
		return answer;
	}

	class Node {
		public int x;
		public int y;
		public int data;
		public Node parent;
		public Node left;
		public Node right;

		public Node(int x, int y, int data) {
			this.x = x;
			this.y = y;
			this.data = data;
		}
	}
}
