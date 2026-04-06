public class Solution {
    public long solution(long n) {
        for (long i = 1; i * i <= n; i++)
        {
            if (i * i == n)
            {
                long temp = i + 1;

                return temp * temp;
            }
        }

        return -1;
    }
}