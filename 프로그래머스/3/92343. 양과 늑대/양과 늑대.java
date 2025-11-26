import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	public static final Map<Integer, List<Integer>> tree = new HashMap<>();

	public int solution(int[] infos, int[][] edges) {
		for (int[] edge : edges) {
			tree.computeIfAbsent(edge[0], (k) -> new ArrayList<>()).add(edge[1]);
		}

		Deque<Info> queue = new ArrayDeque<>();

		// 루트는 무조건 양을 가지고 있음
		Info root = new Info(0, 1, 0, new HashSet<>(tree.get(0)));

		queue.addLast(root);

		int answer = 1;

		while (!queue.isEmpty()) {
			Info info = queue.pollFirst();

			for (int node : info.nexts) {
				// 방문
				Info current = new Info(info, node);

				if (infos[node] == 0) {
					current.sheep++;
				} else {
					current.wolf++;
				}

				if (current.wolf >= current.sheep) {
					continue;
				}

				answer = Math.max(answer, current.sheep);

				List<Integer> nextNodes = tree.get(node);

				if (nextNodes != null) {
					current.nexts.addAll(nextNodes);
				}

				current.nexts.remove(node);

				queue.addLast(current);
			}
		}

		return answer;
	}

	class Info {
		public int currNode;
		public int sheep;
		public int wolf;
		public Set<Integer> nexts;

		public Info(int currNode, int sheep, int wolf, Set<Integer> nexts) {
			this.currNode = currNode;
			this.sheep = sheep;
			this.wolf = wolf;
			this.nexts = nexts;
		}

		public Info(Info info, int node) {
			this.currNode = node;
			this.sheep = info.sheep;
			this.wolf = info.wolf;
			this.nexts = new HashSet<>(info.nexts);
		}
	}
}
