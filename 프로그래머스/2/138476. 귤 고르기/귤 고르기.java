import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tangerineMap = new HashMap<>();
        for (int singleTangerine : tangerine) {
            tangerineMap.merge(singleTangerine, 1, Integer::sum);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        var it = tangerineMap.values().iterator();
        while (it.hasNext()) {
            int i = it.next();
            pq.offer(i);
        }

        int currentSize = 0;
        int result = 0;
        while (currentSize < k) {
            int i = pq.poll();
            currentSize += i;
            result++;
        }

        return result;
    }
}
