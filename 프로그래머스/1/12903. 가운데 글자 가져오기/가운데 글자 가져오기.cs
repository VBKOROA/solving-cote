public class Solution {
    public string solution(string s) {
        int center = s.Length / 2;

        if (s.Length % 2 == 0)
        {
            return s.Substring(center - 1, 2);
        }
        else
        {
            return s.Substring(center, 1);
        }
    }
}