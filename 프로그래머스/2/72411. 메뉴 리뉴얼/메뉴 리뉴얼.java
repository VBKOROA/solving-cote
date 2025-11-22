import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Solution {
	Map<Integer, Map<String, Integer>> combsByCourse = new HashMap<>();
	Map<Integer, Integer> maxCountByCourse = new HashMap<>();

	public void combination(char[] source, char[] comb, int start, int depth, int r) {
		if (depth == r) {
			int mergedCount = combsByCourse.computeIfAbsent(r, (key) -> new HashMap<>())
				.merge(new String(comb), 1, Integer::sum);
			maxCountByCourse.compute(r, (k, v) -> v == null ? mergedCount : Math.max(v, mergedCount));
			return;
		}

		for (int i = start; i <= source.length - (r - depth); i++) {
			comb[depth] = source[i];
			combination(source, comb, i + 1, depth + 1, r);
		}
	}

	public String[] solution(String[] orders, int[] courses) {

		for (String order : orders) {
			char[] orderDetail = order.toCharArray();
			Arrays.sort(orderDetail);

			for (int r : courses) {
				combination(orderDetail, new char[r], 0, 0, r);
			}
		}

		List<String> answer = new ArrayList<>();

		for (int course : courses) {
			Optional.ofNullable(maxCountByCourse.get(course))
				.filter(max -> max >= 2)
				.ifPresent(max -> {
					combsByCourse.get(course).entrySet().stream()
						.filter(entry -> Objects.equals(entry.getValue(), max))
						.forEach(entry -> answer.add(entry.getKey()));
				});
		}

		return answer.stream().sorted(Comparator.naturalOrder()).toArray(String[]::new);
	}
}
