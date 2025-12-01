import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int[] solution(int n, String[] words) {
    Set<String> set = new HashSet<>();
    String prev = null;

    for (int i = 0; i < words.length; i++) {
      int[] wrongResult = {(i % n) + 1, (i / n) + 1};
      String word = words[i];

      if (word.length() == 1) {
        return wrongResult;
      }

      if (set.contains(word)) {
        return wrongResult;
      }

      if (prev != null && !wordStartWithPrevsEnd(word, prev)) {
        return wrongResult;
      }

      set.add(word);
      prev = word;
    }

    return new int[]{0, 0};
  }

  private boolean wordStartWithPrevsEnd(String word, String prev) {
    return word.charAt(0) == prev.charAt(prev.length() - 1);
  }
}
