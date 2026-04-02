import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int minIdx = 0;
        int maxIdx = people.length - 1;

        while (minIdx < maxIdx) {
            if (people[minIdx] + people[maxIdx] <= limit) {
                answer++;
                minIdx++;
                maxIdx--;
            } else {
                answer++;
                maxIdx--;
            }
        }

        if (minIdx == maxIdx) {
            answer++;
        }

        return answer;
    }
}