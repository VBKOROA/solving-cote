import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	public int[] solution(String[] id_list, String[] reports, int k) {
		Map<String, Set<String>> reportsByUser = new HashMap<>();
		Map<String, Integer> reportedCountByUser = new HashMap<>();
		Set<String> blockedUser = new HashSet<>();

		for (String report : reports) {
			String[] reportDetail = report.split(" ");

			boolean added = reportsByUser.computeIfAbsent(reportDetail[0], (key) -> new HashSet<>())
				.add(reportDetail[1]);

			if (added) {
				int mergedCount = reportedCountByUser.merge(reportDetail[1], 1, Integer::sum);

				if (mergedCount >= k) {
					blockedUser.add(reportDetail[1]);
				}
			}
		}

		int[] answer = new int[id_list.length];

		for (int i = 0; i < id_list.length; i++) {
			Set<String> reportSet = reportsByUser.get(id_list[i]);
			if (reportSet != null) {
				answer[i] = (int)reportSet.stream().filter(blockedUser::contains).count();
			}
		}

		return answer;
	}
}
