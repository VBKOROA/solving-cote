import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static final char WRONG = 'X';
    private static final char CORRECT = 'O';
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int totalCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < totalCase; i++) {
            bw.write(solution(br.readLine()) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int solution(String line) {
        int streak = 0;
        int sum = 0;
        char[] results = line.toCharArray();

        for (char result : results) {

            if (WRONG == result) {
                streak = 0;
                continue;
            }

            streak++;
            sum += streak;
        }

        return sum;
    }
}
