public class Solution {
    public int solution(int[] numbers) {
        bool[] flags = new bool[10];
        int answer = 45;


        foreach (int item in numbers)
        {
            if (flags[item] == false)
            {
                answer -= item;
                flags[item] = true;
            }
        }

        return answer;
    }
}