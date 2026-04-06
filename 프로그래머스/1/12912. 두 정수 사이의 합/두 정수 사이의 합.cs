public class Solution
{
    public long solution(int a, int b) {
        long from, to = 0;
        if (a > b)
        {
            from = b;
            to = a;
        } 
        else
        {
            from = a;
            to = b;    
        }
        return (from + to) * (to - from + 1) / 2;
    }
}