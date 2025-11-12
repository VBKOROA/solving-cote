import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		int maxLine = board[0].length;
		Deque<Integer>[] deques = new Deque[maxLine];
		Deque<Integer> myStack = new ArrayDeque<>();

		for (int i = 0; i < maxLine; i++) {
			deques[i] = new ArrayDeque<>();
		}

		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 0) {
					continue;
				}
				deques[j].offerLast(board[i][j]);
			}
		}

		for (int move : moves) {
			move = move - 1;

			if (deques[move].isEmpty()) {
				continue;
			}

			int top = Objects.requireNonNull(deques[move].pollLast());

			if (!myStack.isEmpty() && myStack.peekLast() == top) {
				myStack.pollLast();
				answer++;
				continue;
			}

			myStack.offerLast(top);
		}

		return answer * 2;
	}
}
