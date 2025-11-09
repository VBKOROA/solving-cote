import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public int[] solution(int[] prices) {
		Deque<Position> deque = new ArrayDeque<>();
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			int currentPrice = prices[i];

			while (!deque.isEmpty()) {
				Position position = deque.peekLast();
				if (position.price() > currentPrice) {
					answer[position.index()] = i - position.index();
					deque.pollLast();
				} else {
					break;
				}
			}

			deque.offerLast(new Position(i, currentPrice));
		}

		int lastIndex = answer.length - 1;

		while (!deque.isEmpty()) {
			Position position = deque.pollLast();
			answer[position.index()] = lastIndex - position.index();
		}

		return answer;
	}

	static final class Position {
		private final int index;
		private final int price;

		Position(int index, int price) {
			this.index = index;
			this.price = price;
		}

		public int index() {
			return index;
		}

		public int price() {
			return price;
		}
	}
}
