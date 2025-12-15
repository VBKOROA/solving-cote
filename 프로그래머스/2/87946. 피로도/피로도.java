import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

  public int solution(int k, int[][] dungeons) {
    int totalDungeons = dungeons.length;
    Deque<State> stack = new ArrayDeque<>();
    int maxExplored = 0;

    stack.push(new State(k, totalDungeons));

    while (!stack.isEmpty()) {
      State currentState = stack.pop();

      for (int i = 0; i < totalDungeons; i++) {
        if (currentState.visited[i]) {
          continue;
        }

        if (currentState.energy < dungeons[i][0]) {
          continue;
        }

        State nextState = new State(currentState);
        nextState.exploredCount++;
        maxExplored = Math.max(maxExplored, nextState.exploredCount);
        nextState.energy -= dungeons[i][1];
        nextState.visited[i] = true;
        
        stack.push(nextState);
      }
    }

    return maxExplored;
  }

  static class State {

    int exploredCount;
    int energy;
    boolean[] visited;

    public State(int energy, int totalDungeons) {
      this.energy = energy;
      this.exploredCount = 0;
      this.visited = new boolean[totalDungeons];
    }

    public State(State state) {
      this.exploredCount = state.exploredCount;
      this.energy = state.energy;
      this.visited = state.visited.clone();
    }
  }
}