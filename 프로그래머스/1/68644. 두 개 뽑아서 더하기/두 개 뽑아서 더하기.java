import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int[] solution(int[] numbers) {
		List<Integer> sums = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				sums.add(numbers[i]+numbers[j]);
			}
		}

		return sums.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
	}
}
