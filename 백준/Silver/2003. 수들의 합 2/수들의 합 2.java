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
		int[] nums = new int[n];
		int sum = 0;
		int cnt = 0;
		int left = 0;
		int right = 0;

		for (; right < n; right++) {
			int number = Integer.parseInt(numbers[right]);
			nums[right] = number;
			sum += number;
			while (sum >= m && left <= right) {
				if (sum == m) {
					cnt++;
				}
				sum -= nums[left];
				left++;
			}
		}
		
		System.out.print(cnt);
	}
}