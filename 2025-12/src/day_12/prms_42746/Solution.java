package day_12.prms_42746;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        String answer = String.join("", arr);

        if (answer.charAt(0) == '0') {
            return "0";
        } else {
            return answer;
        }
    }
}
