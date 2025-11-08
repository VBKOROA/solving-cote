import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		char[] chars = line.toCharArray();
		Deque<Character> deque = new ArrayDeque<>();
		boolean tagMode = false;

		for (char c : chars) {
			if (c == '>') {
				tagMode = false;
				while (!deque.isEmpty()) {
					sb.append(deque.pollFirst());
				}
				sb.append(c);
				continue;
			}

			if (!tagMode && c == ' ') {
				while (!deque.isEmpty()) {
					sb.append(deque.pollLast());
				}
				sb.append(c);
				continue;
			}

			if (c == '<') {
				tagMode = true;
				while (!deque.isEmpty()) {
					sb.append(deque.pollLast());
				}
			}

			deque.offerLast(c);
		}

		if (!deque.isEmpty()) {
			while (!deque.isEmpty()) {
				sb.append(deque.pollLast());
			}
		}

		System.out.println(sb);
	}
}
