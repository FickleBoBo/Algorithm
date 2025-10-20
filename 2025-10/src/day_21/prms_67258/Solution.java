package day_21.prms_67258;

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = -1;
        int totalCnt = getGemsCnt(gems);
        int[] answer = {1, gems.length};

        while (true) {
            // 현재 구간의 보석의 종류가 전체 보석의 종류보다 적으면 오른쪽 포인터를 이동하며 보석을 담음
            if (map.size() < totalCnt) {
                right++;
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            } else {
                // 전체 보석을 담으면서 구간의 길이가 더 짧으면 갱신
                if ((right - left) < (answer[1] - answer[0])) {
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }

                // 왼쪽 포인터의 보석을 빼며 왼쪽 포인터 이동
                if (map.get(gems[left]) == 1) {
                    map.remove(gems[left]);
                } else {
                    map.put(gems[left], map.get(gems[left]) - 1);
                }
                left++;
            }

            // 오른쪽 포인터가 구간의 끝이면서 담은 보석의 종류가 전체 보석의 종류보다 적으면 종료
            if (right == gems.length - 1 && map.size() < totalCnt) {
                break;
            }
        }

        return answer;
    }

    // 보석의 종류의 수를 반환하는 메서드
    private static int getGemsCnt(String[] gems) {
        Set<String> set = new HashSet<>();

        for (String gem : gems) {
            set.add(gem);
        }

        return set.size();
    }
}
