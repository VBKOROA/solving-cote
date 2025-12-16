import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

  public int solution(int n) {
    int answer = 0;
    Deque<State> stack = new ArrayDeque<>();

    stack.push(new State(n));

    while (!stack.isEmpty()) {
      State currentState = stack.pop();

      if (currentState.totalQueens == n) {
        answer++;
        continue;
      }

      for (int j = 0; j < n; j++) {
        if (currentState.board[currentState.totalQueens][j]) {
          continue;
        }

        State nextState = new State(currentState);
        nextState.placeQueenOn(currentState.totalQueens, j);
        stack.push(nextState);
      }
    }

    return answer;
  }

  static class State {

    boolean[][] board; // true -> 퀸이 배치 되어 있음.
    int totalQueens;

    public State(int boardSize) {
      board = new boolean[boardSize][boardSize];
      totalQueens = 0;
    }

    public State(State state) {
      board = new boolean[state.board.length][];

      for (int i = 0; i < state.board.length; i++) {
        board[i] = state.board[i].clone();
      }

      totalQueens = state.totalQueens;
    }

    public void placeQueenOn(int y, int x) {
      board[y][x] = true;

      // 3 방향만 true로 fill 하면 됨.
      // 왜냐면 위의 열 부터 queen 이 배치되기 때문에
      // 굳이 위쪽은 board 배열을 업데이트 안해주어도 됨.

      // 왼쪽 밑 대각선
      for (int i = 1; i < board.length - y; i++) {
        int placeX = x - i;

        if (placeX < 0) {
          break;
        }

        board[y + i][placeX] = true;
      }

      // 밑
      for (int i = 1; i < board.length - y; i++) {
        board[y + i][x] = true;
      }

      // 오른쪽 밑 대각선
      for (int i = 1; i < board.length - y; i++) {
        int placeX = x + i;

        if (placeX >= board.length) {
          break;
        }

        board[y + i][placeX] = true;
      }

      totalQueens++;
    }
  }
}