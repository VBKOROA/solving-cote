import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

  public int solution(int N, int[][] roads, int K) {

    Map<Integer, List<Edge>> edges = new HashMap<>();
    int[] minCosts = new int[N + 1];
    PriorityQueue<DijkstraState> dijkstraQueue = new PriorityQueue<>(
        Comparator.comparingInt(state -> state.minCost));

    Arrays.fill(minCosts, Integer.MAX_VALUE);
    dijkstraQueue.offer(new DijkstraState(1, 0));

    minCosts[1] = 0;

    for (int i = 1; i <= N; i++) {
      edges.put(i, new ArrayList<>());
    }

    for (int[] road : roads) {
      edges.get(road[0]).add(new Edge(road[1], road[2]));
      edges.get(road[1]).add(new Edge(road[0], road[2]));
    }

    while (!dijkstraQueue.isEmpty()) {
      DijkstraState state = dijkstraQueue.poll();

      int curIdx = state.dest;
      int curMinCost = state.minCost;

      if (curMinCost > minCosts[curIdx]) {
        continue;
      }

      for (Edge edge : edges.get(curIdx)) {
        int dest = edge.to;
        int newCost = minCosts[curIdx] + edge.cost;

        if (newCost < minCosts[dest]) {
          minCosts[dest] = newCost;
          dijkstraQueue.offer(new DijkstraState(dest, newCost));
        }
      }
    }

    return Math.toIntExact(Arrays.stream(minCosts).filter(cost -> cost <= K).count());
  }

  static class Edge {

    int to;
    int cost;

    public Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }

  static class DijkstraState {

    int dest;
    int minCost;

    public DijkstraState(int dest, int minCost) {
      this.dest = dest;
      this.minCost = minCost;
    }
  }
}
