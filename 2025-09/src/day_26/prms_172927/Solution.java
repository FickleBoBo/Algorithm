package day_26.prms_172927;

import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        // 곡괭이 수 세기
        int pickCnt = 0;
        for (int pick : picks) {
            pickCnt += pick;
        }

        // 곡괭이로 캘 수 있는 광물의 수와 주어진 광물의 수를 비교해서 어디까지 캘 수 있는지 계산
        int len = Math.min(pickCnt * 5, minerals.length);

        // 5개 단위 구간에서 각 광물의 수를 저장하는 2차원 배열
        int[][] map = new int[len + 1][3];
        for (int i = 0; i < len; i++) {
            if (minerals[i].equals("diamond")) {
                map[i / 5][0]++;
            } else if (minerals[i].equals("iron")) {
                map[i / 5][1]++;
            } else {
                map[i / 5][2]++;
            }
        }

        // 다이아몬드가 많을수록, 철이 많을수록 우선순위가 높은 구간
        Arrays.sort(map, (o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o2[0], o1[0]);
            if (o1[1] != o2[1]) return Integer.compare(o2[1], o1[1]);
            return Integer.compare(o2[2], o1[2]);
        });

        // 우선순위가 높은 구간에 대해 피로도가 적게 드는 곡괭이부터 사용
        int answer = 0;
        for (int[] row : map) {
            if (picks[0] != 0) {
                answer += row[0] + row[1] + row[2];
                picks[0]--;
                continue;
            }

            if (picks[1] != 0) {
                answer += row[0] * 5 + row[1] + row[2];
                picks[1]--;
                continue;
            }

            if (picks[2] != 0) {
                answer += row[0] * 25 + row[1] * 5 + row[2];
                picks[2]--;
                continue;
            }

            break;
        }

        return answer;
    }
}
