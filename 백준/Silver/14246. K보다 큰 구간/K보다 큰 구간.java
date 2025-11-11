import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] numbers = br.readLine().split(" ");
		long k = Integer.parseInt(br.readLine());
		long[] sums = new long[n];
		long sum = 0;
		long cnt = 0;

		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(numbers[i]);
			sums[i] = sum;
		}

		if (sum <= k) {
			System.out.print(0);
			return;
		}

		for (int i = 0; i < n; i++) {
			long minus = i > 0 ? sums[i - 1] : 0L;

			for (int j = i; j < n; j++) {
				if (sums[j] - minus > k) {
					cnt += n - j;
					break;
				}
			}
		}

		System.out.print(cnt);
	}
}