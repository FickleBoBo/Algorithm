package day_13.prms_42748;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int start = command[0] - 1;  // array에서 구간 시작 인덱스(포함)
            int end = command[1];  // array에서 구간 끝 인덱스(미포함)
            int k = command[2] - 1;
            int len = end - start;  // 구간의 길이

            int[] tmp = new int[len];

            // 임시 배열에 고속 복사
            System.arraycopy(array, start, tmp, 0, len);
            Arrays.sort(tmp);

            answer[i] = tmp[k];
        }

        return answer;
    }
}
