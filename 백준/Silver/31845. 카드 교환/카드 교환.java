import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cards = Integer.parseInt(st.nextToken());
        int maxTurn = Integer.parseInt(st.nextToken());

        int possibleTurn = Math.min(maxTurn, (int) Math.ceil(cards / 2.0));
        
        List<Integer> scores = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int finalScore = 0;

        for (int i = 0; i < possibleTurn; i++) {
            if (scores.get(i) > 0) {
                finalScore += scores.get(i);
            }
        }

        System.out.print(finalScore);
    }
}
