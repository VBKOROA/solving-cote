public class Solution {
	public int solution(int n, int a, int b) {
		int answer = 0;

		for (; a != b; answer++) {
			a = (a + 1) / 2;
			b = (b + 1) / 2;
		}

		return answer;
	}
}
