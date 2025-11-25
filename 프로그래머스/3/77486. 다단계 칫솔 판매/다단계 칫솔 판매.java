import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] solution(String[] enroll, String[] referral, String[] sellers, int[] amounts) {
		Map<String, Integer> profits = new HashMap<>();
		Map<String, String> tree = new HashMap<>();

		for (int i = 0; i < enroll.length; i++) {
			profits.put(enroll[i], 0);

			if (!referral[i].equals("-")) {
				tree.put(enroll[i], referral[i]);
			}
		}

		for (int i = 0; i < sellers.length; i++) {
			String seller = sellers[i];
			int profit = amounts[i] * 100;
			updateProfits(seller, profit, profits, tree);
		}

		int[] result = new int[enroll.length];

		for (int i = 0; i < result.length; i++) {
			result[i] = profits.get(enroll[i]);
		}

		return result;
	}

	private void updateProfits(String seller, int profit, Map<String, Integer> profits, Map<String, String> tree) {
		String curr = seller;

		while (curr != null) {
			String parent = tree.get(curr);

			int fee = profit / 10;

			if (fee == 0) {
				profits.merge(curr, profit, Integer::sum);
				break;
			} else {
				profits.merge(curr, profit - fee, Integer::sum);
				profit = fee;
				curr = parent;
			}
		}
	}
}
