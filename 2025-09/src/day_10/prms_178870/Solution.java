package day_10.prms_178870;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int[] answer = {0, sequence.length};

        while (true) {
            if (sum < k) {
                sum += sequence[right++];  // 부분 수열의 합이 k 미만이면 오른쪽 포인터 이동 및 합 갱신
            } else if (sum > k) {
                sum -= sequence[left++];  // 부분 수열의 합이 k 초과면 왼쪽 포인터 이동 및 합 갱신
            } else {
                // 부분 수열의 합이 k면서 길이가 더 짧으면 갱신
                if (right - left - 1 < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right - 1;
                }

                // 왼쪽 포인터 이동 및 합 갱신으로 다시 탐색 준비
                sum -= sequence[left++];
            }

            // 오른쪽 포인터가 수열의 끝이면서 합이 k 미만이면 탐색 종료
            if (right == sequence.length && sum < k) break;
        }

        return answer;
    }
}
