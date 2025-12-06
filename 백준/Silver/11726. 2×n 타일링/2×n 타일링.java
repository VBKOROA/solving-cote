import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = readInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int a = 1; // dp[i-2]
        int b = 2; // dp[i-1]
        int sum;

        for (int i = 3; i <= n; i++) {
            sum = a + b;
            if (sum >= 10007) {
                sum -= 10007;
            }
            a = b;
            b = sum;
        }

        System.out.println(b);
    }

    static int readInt() throws IOException {
        int n = 0;
        int c = System.in.read();
        
        while (c <= 32) {
            c = System.in.read();
        }
        
        while (c > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
            c = System.in.read();
        }
        return n;
    }
}