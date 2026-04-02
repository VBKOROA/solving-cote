public class Solution {
    public int solution(int n) {
        int total = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n -= 1;
                total++;
            }
        }
        return total;
    }
}