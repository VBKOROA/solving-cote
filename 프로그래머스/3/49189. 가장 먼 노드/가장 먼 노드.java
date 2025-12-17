import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

  public int solution(int n, int[][] edges) {
    int currentDepth;
    int answer = 0;
    List<Integer>[] graph = new ArrayList[n + 1];

    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }

    answer = 1;
    currentDepth = 1;
    Deque<State> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[n + 1];

    visited[answer] = true;
    queue.offer(new State(answer, currentDepth));

    while (!queue.isEmpty()) {
      State currentState = queue.poll();

      for (int node : graph[currentState.node]) {
        if (visited[node]) {
          continue;
        }

        int newDepth = currentState.depth + 1;
        visited[node] = true;

        if (newDepth > currentDepth) {
          answer = 1;
          currentDepth = newDepth;
        } else {
          answer++;
        }

        queue.offer(new State(node, newDepth));
      }
    }

    return answer;
  }

  static class State {

    int node;
    int depth;

    public State(int node, int depth) {
      this.node = node;
      this.depth = depth;
    }
  }
}