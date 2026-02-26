import java.util.Arrays;

public class Solution {
    public int solution(int []A, int []B)
    {
        int sum = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int minPos = 0;
        int maxPos = A.length - 1;

        for (int i = 0; i < A.length; i++) {
            sum += A[minPos] * B[maxPos];
            minPos += 1;
            maxPos -= 1;
        }

        return sum;
    }
}
