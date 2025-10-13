import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        String[] numberString = br.readLine().split(" ");
        int primeCount = 0;

        for (String s : numberString) {
            int number = Integer.parseInt(s);
            if(isPrime(number)) primeCount++;
        }

        bw.write(primeCount+"");

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPrime(int number) {
        if (number == 1) return false;

        for (int i = 2; i*i <= number; i++) {
            if(number % i == 0) return false;
        } 
        return true;
    }
}
