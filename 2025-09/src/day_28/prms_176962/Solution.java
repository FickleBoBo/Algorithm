package day_28.prms_176962;

import java.util.*;

class Solution {

    // 과제 클래스로 과제의 시작 시각과 과제를 마치는데 걸리는 시간을 int형으로 처리
    private static class Plan {
        String name;
        int start;
        int playtime;

        public Plan(String[] plan) {
            this.name = plan[0];
            this.start = parseTime(plan[1].split(":"));
            this.playtime = Integer.parseInt(plan[2]);
        }

        private static int parseTime(String[] time) {
            return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
    }

    public String[] solution(String[][] plans) {
        // 과제를 리스트에 담아 과제의 시작 시각을 기준으로 정렬
        List<Plan> list = new ArrayList<>();
        for (String[] plan : plans) {
            list.add(new Plan(plan));
        }
        list.sort((o1, o2) -> Integer.compare(o1.start, o2.start));

        String[] answer = new String[plans.length];
        int ansIdx = 0;

        // 최근에 과제 계산에 사용한 시각
        int standard = list.get(0).start;

        // 최근에 멈춘 과제가 우선이 되므로 스택 자료구조 활용
        Deque<Plan> stack = new ArrayDeque<>();
        for (Plan plan : list) {
            // 멈춰둔 과제가 없으면 새로운 과제를 스택에 적재
            if (stack.isEmpty()) {
                stack.push(plan);
                continue;
            }

            // 멈춰둔 과제를 완료할 수 없는 경우
            if (standard + stack.peek().playtime > plan.start) {
                stack.peek().playtime -= plan.start - standard;  // 멈춰둔 과제를 마치는데 걸리는 시간 갱신
                stack.push(plan);  // 스택에 새로운 과제 적재
                standard = plan.start;  // 과제 계산에 사용한 시각 갱신
                continue;
            }

            // 멈춰둔 과제를 완료할 수 있는 경우
            int left = plan.start - standard;  // 여유 시간을 먼저 계산
            while (!stack.isEmpty() && left >= stack.peek().playtime) {  // 여유 시간 동안 처리가능한 모든 과제 처리
                answer[ansIdx++] = stack.peek().name;
                left -= stack.peek().playtime;
                stack.pop();
            }
            standard = plan.start;  // 과제 계산에 사용한 시각 갱신

            // 스택이 비어있지 않으면 멈춰둔 과제의 남은 시간 갱신
            if (!stack.isEmpty()) {
                stack.peek().playtime -= left;
            }

            // 새로운 과제 적재
            stack.push(plan);
        }

        // 멈춰둔 남은 과제들은 역순으로 완료
        while (!stack.isEmpty()) {
            answer[ansIdx++] = stack.pop().name;
        }

        return answer;
    }
}
