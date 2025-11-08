import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	boolean solution(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		char[] strings = s.toCharArray();

		for (char c : strings) {
			if (c == '(') {
				stack.offerLast(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peekLast() != '(') {
					return false;
				}
				stack.pollLast();
			}
		}

		return stack.isEmpty();
	}
}
