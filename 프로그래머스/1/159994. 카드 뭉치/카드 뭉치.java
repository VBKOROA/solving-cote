import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public String solution(String[] cards1, String[] cards2, String[] goal) {
		Deque<String> cards1Queue = new ArrayDeque<>();
		Deque<String> cards2Queue = new ArrayDeque<>();

		for (String card : cards1) {
			cards1Queue.addLast(card);
		}

		for (String card : cards2) {
			cards2Queue.addLast(card);
		}

		int idx;

		for (idx = 0; idx < goal.length; idx++) {
			if (isBothEmpty(cards1Queue, cards2Queue)) {
				return "No";
			}

			if (isFirstMatches(cards1Queue, goal[idx])) {
				cards1Queue.pollFirst();
			} else if (isFirstMatches(cards2Queue, goal[idx])) {
				cards2Queue.pollFirst();
			} else {
				return "No";
			}
		}

		return idx == goal.length ? "Yes" : "No";
	}

	private boolean isBothEmpty(Deque<?> a, Deque<?> b) {
		return a.isEmpty() && b.isEmpty();
	}

	private boolean isFirstMatches(Deque<String> queue, String str) {
		return !queue.isEmpty() && queue.peekFirst().equals(str);
	}
}
