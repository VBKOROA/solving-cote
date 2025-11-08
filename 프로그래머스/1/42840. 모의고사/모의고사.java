import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
	private static final int[] PATTERN_ONE = {1, 2, 3, 4, 5};
	private static final int[] PATTERN_TWO = {2, 1, 2, 3, 2, 4, 2, 5};
	private static final int[] PATTERN_THREE = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

	public int[] solution(int[] answers) {
		List<Integer> scores = new ArrayList<>();

		scores.add(evaluate(PATTERN_ONE, answers));
		scores.add(evaluate(PATTERN_TWO, answers));
		scores.add(evaluate(PATTERN_THREE, answers));

		int maxScore = scores.stream().max(Comparator.naturalOrder()).orElse(0);
		List<Integer> result = new ArrayList<>();

		for (int i = 1; i <= 3; i++) {
			if (scores.get(i - 1) == maxScore) {
				result.add(i);
			}
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	public int evaluate(int[] pattern, int[] answers) {
		int score = 0;

		for (int i = 0; i < answers.length; i++) {
			int patternIdx = i % pattern.length;
			if (pattern[patternIdx] == answers[i]) {
				score++;
			}
		}

		return score;
	}
}
