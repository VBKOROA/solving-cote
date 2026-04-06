public class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                int pair = n / i;

                answer += i;

                if (pair != i)
                {
                    answer += n / i;
                }
            }
        }

        return answer;
    }
}