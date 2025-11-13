package day_13.prms_42746;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 정수 이어 붙이기를 위해 String 배열 활용
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) ->
                Integer.compare(Integer.parseInt(o2 + o1), Integer.parseInt(o1 + o2)));

        // 정수 이어 붙이기
        String answer = String.join("", arr);

        if (answer.charAt(0) == '0') {
            return "0";
        } else {
            return answer;
        }
    }
}
