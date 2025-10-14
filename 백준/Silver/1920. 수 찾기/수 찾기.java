import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] nNumberStrings = br.readLine().split(" ");
        Set<Integer> numberSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            numberSet.add(Integer.parseInt(nNumberStrings[i]));
        }

        int m = Integer.parseInt(br.readLine());
        String[] mNumberStrings = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            if (numberSet.contains(Integer.parseInt(mNumberStrings[i]))) {
                bw.write("1");
            } else {
                bw.write("0");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
