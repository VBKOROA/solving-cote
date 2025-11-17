import java.util.HashMap;
import java.util.Map;

public class Solution {
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> completionMap = new HashMap<>();
		for (String s : completion) {
			completionMap.merge(s, 1, Integer::sum);
		}

		for (String s : participant) {
			if (completionMap.containsKey(s) == false) {
				return s;
			}

			int count = completionMap.get(s);

			if (count == 1) {
				completionMap.remove(s);
			} else {
				completionMap.put(s, --count);
			}
		}
		String answer = "";
		return answer;
	}
}
