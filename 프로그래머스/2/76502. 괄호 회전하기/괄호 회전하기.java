import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public int solution(String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			if (isValid(s)) {
				answer++;
			}

			s = rotate(s);
		}
		return answer;
	}

	private String rotate(String s) {
		return s.substring(1) + s.charAt(0);
	}

	private boolean isValid(String s) {
		Deque<Character> deque = new ArrayDeque<>();
		char[] chars = s.toCharArray();

		for (char c : chars) {
			switch (c) {
				case ')':
					if (deque.isEmpty()) {
						return false;
					}

					if (deque.peekLast() != '(') {
						return false;
					}

					deque.pollLast();
					break;
				case ']':
					if (deque.isEmpty()) {
						return false;
					}

					if (deque.peekLast() != '[') {
						return false;
					}

					deque.pollLast();
					break;
				case '}':
					if (deque.isEmpty()) {
						return false;
					}

					if (deque.peekLast() != '{') {
						return false;
					}

					deque.pollLast();
					break;
				default:
					deque.add(c);
			}
		}

		return deque.isEmpty();
	}
}
