import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

  public int solution(int n, int[][] computers) {
    boolean[] visited = new boolean[n];
    int result = 0;

    for (int i = 0; i < n; i++) {
      if (visited[i]) {
        continue;
      }
      dfs(computers, visited, i, n);
      result++;
    }

    return result;
  }

  private void dfs(int[][] computers, boolean[] visited, int i, int n) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.addLast(i);

    while (!stack.isEmpty()) {
      int computer = stack.pollLast();
      visited[computer] = true;

      for (int j = 0; j < n; j++) {
        if (visited[j]) {
          continue;
        }

        if (j == computer) {
          continue;
        }

        if (computers[computer][j] == 1) {
          stack.addLast(j);
        }
      }
    }
  }
}
