import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // row - col + (n-1)
        boolean[] diag2 = new boolean[2 * n - 1]; // row + col

        int[] pos = new int[n];
        Arrays.fill(pos, -1);

        int row = 0;
        int answer = 0;

        while (row >= 0) {
            pos[row]++; // 다음 col 시도

            // 현재 row에서 놓을 수 있는 col 찾기
            while (pos[row] < n) {
                int c = pos[row];
                int d1 = row - c + (n - 1);
                int d2 = row + c;

                if (!col[c] && !diag1[d1] && !diag2[d2]) {
                    // 배치
                    col[c] = diag1[d1] = diag2[d2] = true;
                    break;
                }
                pos[row]++;
            }

            if (pos[row] < n) {
                // 성공적으로 배치
                if (row == n - 1) {
                    // 해 1개 완성
                    answer++;

                    // 되돌리기
                    int c = pos[row];
                    col[c] = diag1[row - c + (n - 1)] = diag2[row + c] = false;
                } else {
                    row++;
                    pos[row] = -1;
                    continue;
                }
            }

            // 이 row에서 더 이상 불가능 → backtrack
            pos[row] = -1;
            row--;
            if (row >= 0) {
                int c = pos[row];
                col[c] = diag1[row - c + (n - 1)] = diag2[row + c] = false;
            }
        }

        System.out.println(answer);
    }
}
