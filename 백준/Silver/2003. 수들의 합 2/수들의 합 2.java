import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numbers = br.readLine().split(" ");
		int n = Integer.parseInt(numbers[0]);
		int m = Integer.parseInt(numbers[1]);
		numbers = br.readLine().split(" ");
		int sum = 0;
		int[] sums = new int[n];
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(numbers[i]);
			sums[i] = sum;
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int minus = i > 0 ? sums[i - 1] : 0;
				if (sums[j] - minus == m) {
					cnt++;
				}
			}
		}

		System.out.print(cnt);
	}
}