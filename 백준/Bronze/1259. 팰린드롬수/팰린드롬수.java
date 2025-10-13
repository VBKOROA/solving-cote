import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line;
        Deque<String> lines = new ArrayDeque<>();

        do {
            line = br.readLine();
            lines.offerLast(line);
        } while ("0".equals(line) == false);

        lines.pollLast();

        while(!lines.isEmpty()) {
            String number = lines.pollFirst();
            String reversed = new StringBuilder(number).reverse().toString();

            if (number.equals(reversed)) bw.write("yes");
            else bw.write("no");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
