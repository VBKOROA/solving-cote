import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int solution(int n, int[][] costs) {
    int[] parents = new int[n];
    int[] sizes = new int[n];
    int connects = 0;

    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }

    Arrays.fill(sizes, 1);

    int answer = 0;

    int[][] sortedCosts = Arrays.stream(costs)
        .sorted(Comparator.comparingInt(cost -> cost[2])).toArray(int[][]::new);

    for (int[] cost : sortedCosts) {
      int islandA = cost[0];
      int islandB = cost[1];

      int parentA = find(islandA, parents);
      int parentB = find(islandB, parents);

      if (parentA == parentB) {
        continue;
      }

      union(parentA, parentB, parents, sizes);

      answer += cost[2];
      connects++;

      if (connects == n - 1) {
        break;
      }
    }

    return answer;
  }

  public int find(int n, int[] parents) {
    while (parents[n] != n) {
      n = parents[n];
    }

    return parents[n];
  }

  public void union(int a, int b, int[] parents, int[] sizes) {
    if (sizes[a] > sizes[b]) {
      parents[b] = a;
      sizes[a] += 1;
    } else {
      parents[a] = b;
      sizes[b] += 1;
    }
  }
}
