package day_13.prms_42747;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            // i번 논문의 인용 횟수 x에 대해 인용 횟수가 x 이상인 논문이 x개 이상이면 x는 H-Index 후보
            // i번 논문의 인용 횟수 x에 대해 인용 횟수가 x 이상인 논문이 x개 이하(y)면 y는 H-Index 후보
            max = Math.max(max, Math.min(citations[i], citations.length - i));
        }

        return max;
    }
}
