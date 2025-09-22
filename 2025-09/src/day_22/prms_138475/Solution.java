package day_22.prms_138475;

class Solution {
    public int[] solution(int e, int[] starts) {
        // 약수의 수를 저장하는 카운팅 배열
        int[] cntArr = new int[1 + e];

        // i를 약수로 갖는 e 이하의 수들에 대해 카운팅
        for (int i = 1; i <= e; i++) {
            for (int j = 1; j * i <= e; j++) {
                cntArr[j * i]++;
            }
        }

        // 해당 인덱스 수 ~ e 사이의 수 중 가장 약수가 많은 수를 저장하는 dp
        int[] dp = new int[1 + e];
        int cnt = 0;

        for (int i = e; i >= 1; i--) {
            // 약수의 수가 같거나 더 많은 수를 발견하면 갱신
            if (cntArr[i] > cnt) {
                dp[i] = i;
                cnt = cntArr[i];
            } else if (cntArr[i] == cnt) {
                dp[i] = i;
            } else {
                dp[i] = dp[i + 1];
            }
        }

        int[] answer = new int[starts.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dp[starts[i]];
        }

        return answer;
    }
}
