import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x+1];

        if (x % 3 == 0) {
            dp[x/3] = 1;
        } 

        if (x % 2 == 0) {
            dp[x/2] = 1;
        }

        dp[x-1] = 1;

        for (int i = x-1; i > 1; i--) {
            int time = dp[i];

            if (i % 3 == 0) {
                if (dp[i/3] == 0) {
                    dp[i/3] = time + 1;
                } else {
                    dp[i/3] = Math.min(time + 1, dp[i/3]);
                }
            } 

            if (i % 2 == 0) {
                if (dp[i/2] == 0) {
                    dp[i/2] = time + 1;
                } else {
                    dp[i/2] = Math.min(time + 1, dp[i/2]);
                }
            }

            if (dp[i-1] == 0) {
                dp[i-1] = time + 1;
            } else {
                dp[i-1] = Math.min(time + 1, dp[i-1]);
            }
        }

        bw.write(dp[1] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
