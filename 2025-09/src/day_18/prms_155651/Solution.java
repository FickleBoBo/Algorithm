package day_18.prms_155651;

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 주어진 book_time을 변환하고 예약 시작 시간이 빠른 순서로 정렬
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = timeToInt(book_time[i][0]);
            times[i][1] = timeToInt(book_time[i][1]);
        }
        Arrays.sort(times, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        // 확정한 예약의 종료 시간을 담는 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;

        // 예약 하나를 미리 넣어서 peek() 과정에서 NPE 방지
        pq.offer(times[0][1]);
        cnt++;

        for (int i = 1; i < times.length; i++) {
            // 현재 예약의 시작 시간이 과거 예약 중 가장 빠른 종료 시간 + 10보다 크면 해당 방에 배치하면 된다.
            if (pq.peek() + 10 <= times[i][0]) {
                pq.poll();
            }
            // 아니면 새로운 방에 배치해야 한다.
            else {
                cnt++;
            }

            // 현재 예약 확정
            pq.offer(times[i][1]);
        }

        return cnt;
    }

    // "HH:MM" 꼴의 time을 00:00부터 지난 분으로 변환
    private static int timeToInt(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 +
                Integer.parseInt(splitTime[1]);
    }
}
