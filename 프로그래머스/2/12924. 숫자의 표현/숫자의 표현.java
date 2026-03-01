public class Solution {
    public int solution(int n) {
        int start = 1;
        int end = 0;
        int sum = 0;

        int answer = 0;

        while (end < n) {
            if (sum < n) {
                end += 1;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start += 1;
            } else {
                answer += 1;
                sum -= start;
                start += 1;
            }
        }

        return answer+1;
    }
}