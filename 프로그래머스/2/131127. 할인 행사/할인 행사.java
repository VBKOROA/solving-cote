import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		Map<String, Integer> totalDiscountMap = new HashMap<>();
		Map<String, Integer> wantMap = new HashMap<>();

		for (int i = 0; i < number.length; i++) {
			wantMap.put(want[i], number[i]);
		}

		// 10일간 회원
		int start = 0;
		int end = 9;

		for (int i = 0; i <= end; i++) {
			totalDiscountMap.merge(discount[i], 1, Integer::sum);
		}

		while (end < discount.length) {

			if (totalDiscountMap.equals(wantMap)) {
				answer++;
			}

			if (end == discount.length - 1) {
				break;
			}

			totalDiscountMap.computeIfPresent(discount[start], (k, v) -> (v > 1) ? v - 1 : null);
			start++;
			totalDiscountMap.merge(discount[++end], 1, Integer::sum);
		}

		return answer;
	}
}
