import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmString = br.readLine().split(" ");
        int n = Integer.parseInt(nmString[0]);
        int m = Integer.parseInt(nmString[1]);
        int[] card = new int[n];
        String[] cardString = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(cardString[i]);
        }

        int closest = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int total = card[i] + card[j] + card[k];

                    if (closest < total && total <= m) {
                        closest = total;
                    }
                }
            }
        }

        bw.write(closest+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
