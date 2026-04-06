using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(long n) {
        List<int> numbers = new List<int>();

        while (n != 0)
        {
            numbers.Add((int)(n % 10));
            n /= 10;
        }

        return numbers.ToArray();
    }
}