import java.util.Arrays;

public class Solution {

  public long solution(int n, int[] times) {
    long left = 1;
    long right = (long) n * Arrays.stream(times).max().orElse(1);
    long mid = 0;
    long answer = 0;

    while (left <= right) {
      mid = (left + right) / 2;
      long throughput = 0;
      for (int time : times) {
        throughput += mid / time;
      }
      if (throughput >= n) {
        answer = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return answer;
  }
}
