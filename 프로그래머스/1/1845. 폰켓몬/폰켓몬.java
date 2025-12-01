import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int solution(int[] nums) {
    Set<Integer> monsterType = new HashSet<>();
    Arrays.stream(nums).forEach(monsterType::add);
    int available = nums.length / 2;

    if (monsterType.size() >= available) {
      return available;
    } else {
      return monsterType.size();
    }
  }
}
