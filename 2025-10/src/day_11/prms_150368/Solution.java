package day_11.prms_150368;

class Solution {

    private static int[] discountArr;  // 할인율 중복 순열 배열
    private static final int[] answer = new int[2];

    public int[] solution(int[][] users, int[] emoticons) {
        discountArr = new int[emoticons.length];

        permutation(0, discountArr.length, users, emoticons);

        return answer;
    }

    // 중복 순열
    private static void permutation(int selIdx, int len, int[][] users, int[] emoticons) {
        if (selIdx == len) {
            // 중복 순열 완성시 계산 수행
            calculate(len, users, emoticons);
            return;
        }

        for (int discount = 10; discount <= 40; discount += 10) {
            discountArr[selIdx] = discount;
            permutation(selIdx + 1, len, users, emoticons);
        }
    }

    private static void calculate(int len, int[][] users, int[] emoticons) {
        int cnt = 0;
        int totalSum = 0;

        for (int[] user : users) {
            int sum = 0;

            // 특정 할인율 이상인 이모티콘 구매 비용 계산
            for (int i = 0; i < len; i++) {
                if (discountArr[i] >= user[0]) {
                    sum += emoticons[i] * (100 - discountArr[i]) / 100;
                }
            }

            // 이모티콘 구매비용이 특정 금액 이상이면 이모티콘 플러스 서비스에 가입하고 아니면 할인된 이모티콘 구매
            if (sum >= user[1]) {
                cnt++;
            } else {
                totalSum += sum;
            }
        }

        // 이모티콘 플러스 서비스 가입자를 최대한 늘리도록, 이모티콘 판매액이 최대가 되도록 갱신
        if (cnt > answer[0]) {
            answer[0] = cnt;
            answer[1] = totalSum;
        } else if (cnt == answer[0] && totalSum > answer[1]) {
            answer[1] = totalSum;
        }
    }
}
