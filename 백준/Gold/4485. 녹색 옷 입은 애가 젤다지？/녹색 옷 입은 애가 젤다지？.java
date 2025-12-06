import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

  static final int[][] MOVEMENTS = new int[][]{
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
  };

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Map> maps = new ArrayList<>();

    while (true) {
      String size = br.readLine();

      if (size.equals("0")) {
        break;
      }

      List<String> mapStrings = new ArrayList<>();

      for (int i = 0; i < Integer.parseInt(size); i++) {
        mapStrings.add(br.readLine());
      }

      maps.add(new Map(mapStrings));
    }

    List<Integer> result = new ArrayList<>();

    for (Map map : maps) {
      result.add(findMaxCost(map));
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= result.size(); i++) {
      sb.append("Problem ")
          .append(i)
          .append(": ")
          .append(result.get(i - 1))
          .append("\n");
    }

    System.out.print(sb);
  }

  private static Integer findMaxCost(Map map) {
    int height = map.map.length;
    int width = map.map[0].length;
    PriorityQueue<DijkstraState> dijkstraQueue = new PriorityQueue<>(
        Comparator.comparingInt(state -> state.cost));
    int[][] minCosts = new int[height][width];

    for (int i = 0; i < height; i++) {
      Arrays.fill(minCosts[i], Integer.MAX_VALUE);
    }

    minCosts[0][0] = map.map[0][0];

    dijkstraQueue.offer(new DijkstraState(new int[]{0, 0}, map.map[0][0]));

    while (!dijkstraQueue.isEmpty()) {
      var curState = dijkstraQueue.poll();
      int curY = curState.dest[0];
      int curX = curState.dest[1];

      if (curState.cost > minCosts[curY][curX]) {
        continue;
      }

      for (int i = 0; i < MOVEMENTS.length; i++) {
        int newY = curY + MOVEMENTS[i][0];
        int newX = curX + MOVEMENTS[i][1];
        boolean isInHeight = 0 <= newY && newY < height;
        boolean isInWidth = 0 <= newX && newX < width;

        if (!(isInHeight && isInWidth)) {
          continue;
        }

        int newCost = minCosts[curY][curX] + map.map[newY][newX];

        if (newCost < minCosts[newY][newX]) {
          minCosts[newY][newX] = newCost;
          dijkstraQueue.offer(new DijkstraState(new int[]{newY, newX}, newCost));
        }
      }
    }

    return minCosts[height - 1][width - 1];
  }

  static class DijkstraState {

    int[] dest;
    int cost;

    public DijkstraState(int[] dest, int cost) {
      this.dest = dest;
      this.cost = cost;
    }

  }

  static class Map {

    int[][] map;

    public Map(List<String> mapStrings) {
      map = new int[mapStrings.size()][];

      for (int i = 0; i < mapStrings.size(); i++) {
        int[] mapInt = Arrays.stream(mapStrings.get(i).split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        map[i] = mapInt;
      }
    }
  }
}