using System.Linq;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        var ret = arr.Where(num => num % divisor == 0).OrderBy(num => num).ToArray();
        return ret.Length == 0 ? new int[] {-1} : ret;
    }
}