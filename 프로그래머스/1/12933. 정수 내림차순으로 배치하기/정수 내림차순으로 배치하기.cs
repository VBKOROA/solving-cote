using System.Collections.Generic;

public class Solution {
    public long solution(long n) {
        List<int> numbers = new List<int>();

        while (n != 0)
        {
            numbers.Add((int)(n % 10));
            n /= 10;
        }

        numbers.Sort((a, b) => b.CompareTo(a));

        return long.Parse(string.Join("", numbers));
    }
}