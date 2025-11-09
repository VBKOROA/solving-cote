import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public int solution(String s) {
		char[] chars = s.toCharArray();
		Deque<Character> deque = new ArrayDeque<>();

		for (char c : chars) {
			if (!deque.isEmpty() && deque.peekLast() == c) {
				deque.pollLast();
				continue;
			}

			deque.add(c);
		}
		return deque.isEmpty() ? 1 : 0;
	}
}
