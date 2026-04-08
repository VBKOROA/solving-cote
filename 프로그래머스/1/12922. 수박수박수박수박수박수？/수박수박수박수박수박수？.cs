using System.Text;

public class Solution {
    public string solution(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++)
        {
            sb.Append(i % 2 == 0 ? "수" : "박");
        }

        return sb.ToString();
    }
}