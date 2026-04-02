import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] elements) {
        Set<Integer> hashSet = new HashSet<>();

        for (int idx = 0; idx < elements.length; idx++) {
            int sum = 0;
            for (int n = 0; n < elements.length; n++) {
                sum += elements[(idx + n) % elements.length];
                hashSet.add(sum);
            }
        }

        return hashSet.size();
    }

    // private int sum(int[] elements, int startIdx, int count) {
    //     int ret = 0;

    //     for (int i = 0; i < count; i++) {
    //         ret += elements[startIdx];
    //         startIdx = (startIdx + 1) % elements.length; 
    //     }
        
    //     return ret;
    // }
}