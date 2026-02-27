public class Solution {
    public int[] solution(String s) {
        int turn = 0;
        int deletedZeros = 0;

        while (!s.equals("1")) {
            int len = s.length();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    len -= 1;
                    deletedZeros += 1;
                } 
            }

            s = Integer.toBinaryString(len);
            turn += 1;
        }

        return new int[]{turn, deletedZeros};
    }
}
