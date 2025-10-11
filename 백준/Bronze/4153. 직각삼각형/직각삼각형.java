import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean loop = true;

        while (loop) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int hypnotenuse = 0;
            int sum = 0;

            while (st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp == 0) {
                    loop = false;
                    break;
                }

                temp *= temp;
                sum += temp;

                if (hypnotenuse < temp) {
                    hypnotenuse = temp;
                }
            }

            if (loop == false) {
                break;
            }

            if (sum / 2 == hypnotenuse) {
                bw.write("right");
            } else {
                bw.write("wrong");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
