import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] numbers = br.readLine().split(" ");
        bw.write(String.format("%.1f", Integer.parseInt(numbers[0]) * (float)Integer.parseInt(numbers[1]) / 2));

        bw.flush();
        bw.close();
        br.close();
    }
}
