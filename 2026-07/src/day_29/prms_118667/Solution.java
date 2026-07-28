package day_29.prms_118667;

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int x : queue1) {
            q1.offer(x);
            sum1 += x;
        }
        for (int x : queue2) {
            q2.offer(x);
            sum2 += x;
        }

        int cnt = 0;
        int max = 2 * (q1.size() + q2.size());
        while (cnt <= max) {
            if (sum1 > sum2) {
                sum2 += q1.peek();
                sum1 -= q1.peek();
                q2.offer(q1.poll());
                cnt++;
            } else if (sum1 < sum2) {
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.offer(q2.poll());
                cnt++;
            } else {
                return cnt;
            }
        }

        return -1;
    }
}
