import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int INPUT_SIZE = 8;
    private static final int[] ASCENDING_PATTERN = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
    private static final int[] DESCENDING_PATTERN = new int[] {8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] notes = new int[INPUT_SIZE];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < INPUT_SIZE; i++) {
            notes[i] = Integer.parseInt(st.nextToken());
        }

        if (Arrays.equals(notes, ASCENDING_PATTERN)) {
            bw.write("ascending");
        } else if (Arrays.equals(notes, DESCENDING_PATTERN)) {
            bw.write("descending");
        } else {
            bw.write("mixed");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
