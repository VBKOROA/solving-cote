import java.math.BigInteger;

public class Solution {
    public long solution(int n) {
        if (n <= 2) {
            return n;
        }

        BigInteger[] dp = new BigInteger[n+1];

        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("2");

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        return dp[n].remainder(new BigInteger("1234567")).longValue();
    }
}