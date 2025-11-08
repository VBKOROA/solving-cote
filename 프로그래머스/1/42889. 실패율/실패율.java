import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] solution(int N, int[] stages) {
		Map<Integer, Integer> onStageMap = new HashMap<>();
		Map<Integer, Double> failRateMap = new HashMap<>();

		for (int stage : stages) {
			if (stage > N) {
				continue;
			}
			onStageMap.merge(stage, 1, Integer::sum);
		}

		int totalPlayer = stages.length;

		for (int i = 1; i <= N; i++) {
			if (totalPlayer == 0) {
				failRateMap.put(i, 0.0);
				continue;
			}
			int stuck = onStageMap.getOrDefault(i, 0);
			failRateMap.put(i, stuck / (double)totalPlayer);
			totalPlayer -= stuck;
		}

		return failRateMap.entrySet()
			.stream()
			.sorted(Comparator.comparingDouble(Map.Entry<Integer, Double>::getValue)
				.reversed()
				.thenComparing(Comparator.comparingInt(Map.Entry<Integer, Double>::getKey)))
			.mapToInt(Map.Entry::getKey)
			.toArray();
	}
}
