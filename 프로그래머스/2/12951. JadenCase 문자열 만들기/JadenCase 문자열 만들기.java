public class Solution {
    public String solution(String s) {
        char[] charArr = s.toCharArray();
        boolean toUpper = true;

        for (int idx = 0; idx < charArr.length; idx++) {
            if (toUpper) {
                charArr[idx] = Character.toUpperCase(charArr[idx]);
                toUpper = false;
            } else {
                charArr[idx] = Character.toLowerCase(charArr[idx]);
            }

            if (charArr[idx] == ' ') {
                toUpper = true;
            }
        }

        return new String(charArr);
    }
}
