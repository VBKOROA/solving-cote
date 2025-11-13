import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int curIdx = 0;
		int beforeTaking = 0;
		List<Integer> result = new ArrayList<>();
		int resultIdx = 0;

		beforeTaking = ceilDiv(100 - progresses[curIdx], speeds[curIdx]);
		result.add(1);
		curIdx++;

		for (; curIdx < progresses.length; curIdx++) {
			int curTaking = ceilDiv(100 - progresses[curIdx], speeds[curIdx]);
			if (beforeTaking >= curTaking) {
				result.set(resultIdx, result.get(resultIdx) + 1);
			} else {
				result.add(1);
				resultIdx++;
				beforeTaking = curTaking;
			}
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	private int ceilDiv(int a, int b) {
		return (int)Math.ceil((double)a / b);
	}
}
