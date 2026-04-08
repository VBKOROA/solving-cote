using System.Linq;

public class Solution {
    public int[] solution(int[] arr) {
        if (arr.Length == 1)
        {
            return new int[] {-1};
        }

        int min = arr.Min();
        int[] answer = arr.Where(num => num != min).ToArray();
        return answer;
    }
}