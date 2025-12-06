import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int solution(String numbers) {
        String[] numberString = numbers.split("");

        // 최대값 계산
        Integer[] numberArray = Arrays.stream(numberString).map(Integer::valueOf).sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
        int max = Arrays.stream(numberArray).reduce(0, (a, b) -> Integer.parseInt(String.valueOf(a)+String.valueOf(b)));

        // 사용된 수 해싱
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : numberArray) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }

        // 총 소수 개수
        int cnt = 0;

        // 소수 구하기
        for(int i = 2; i <= max; i++) {
            // 사용된 수 해싱
            int temp = i;
            HashMap<Integer, Integer> forMap = new HashMap<>();
            while(temp > 0) {
                int last = temp % 10;
                if(forMap.containsKey(last)) {
                    forMap.put(last, forMap.get(last)+1);
                } else {
                    forMap.put(last, 1);
                }
                temp = temp / 10;
            }

            // forMap이 map에 포함되는 관계인지 체크
            boolean checked = true;
            for(Entry<Integer, Integer> entry : forMap.entrySet()) {
                if(map.containsKey(entry.getKey())) {
                    if(map.get(entry.getKey()).compareTo(entry.getValue()) < 0) {
                        checked = false;
                        break;
                    }
                } else {
                    checked = false;
                    break;
                }
            }

            if(!checked) {
                continue;
            }

            boolean primeCheck = isPrime(i);

            if(primeCheck) cnt++;
        }

        return cnt;
    }

    private boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }
        for(int i = 2; i*i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}