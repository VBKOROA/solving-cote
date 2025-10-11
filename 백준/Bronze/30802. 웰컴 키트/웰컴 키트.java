import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int participant = Integer.parseInt(br.readLine());
        int[] tSzie = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < tSzie.length; i++) {
            tSzie[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int shirtPackage = Integer.parseInt(st.nextToken());
        int penPackage = Integer.parseInt(st.nextToken());

        int minShirtPackage = 0;

        for (int i : tSzie) {
            minShirtPackage += (i + shirtPackage - 1) / shirtPackage;
        }

        int minPenPackage = participant / penPackage;
        int minPen = participant % penPackage;

        bw.write(minShirtPackage + "\n");
        bw.write(minPenPackage + " " + minPen);

        bw.flush();
        bw.close();
        br.close();
    }
}
