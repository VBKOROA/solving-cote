import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public int solution(int n, int[][] wires) {
    Map<Integer, List<Integer>> tree = new HashMap<>();

    for (int i = 0; i < wires.length; i++) {
      tree.computeIfAbsent(wires[i][0], (k) -> new ArrayList<>()).add(i);
      tree.computeIfAbsent(wires[i][1], (k) -> new ArrayList<>()).add(i);
    }

    // 둘로 나뉜 전력망 중 송전탑의 차의 절댓값
    // 해당 값이 maxSongJeonTop 보다 작으면 업데이트
    int maxSongJeonTop = Integer.MAX_VALUE;

    for (int i = 0; i < wires.length; i++) {
      int count = countMaxSongJeonTop(n, tree, wires, i);
      maxSongJeonTop = Math.min(maxSongJeonTop, count);
    }

    return maxSongJeonTop;
  }

  private int countMaxSongJeonTop(int totalNodes, Map<Integer, List<Integer>> tree, int[][] wires,
      int exclude) {
    boolean[] visited = new boolean[totalNodes + 1];
    Deque<Integer> stack = new ArrayDeque<>();
    int count = 0;

    stack.push(1);

    while (!stack.isEmpty()) {
      int curNode = stack.pop();
      count++;
      visited[curNode] = true;

      for (int wireIndex : tree.get(curNode)) {
        if (wireIndex == exclude) {
          continue;
        }

        int nextNode = 0;

        if (wires[wireIndex][0] != curNode) {
          nextNode = wires[wireIndex][0];
        } else {
          nextNode = wires[wireIndex][1];
        }

        if (!visited[nextNode]) {
          stack.push(nextNode);
        }
      }
    }

    return Math.abs((totalNodes - count) - count);
  }
}
