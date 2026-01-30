package day_30.prms_118667;

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = arrToQueue(queue1);
        Queue<Integer> q2 = arrToQueue(queue2);

        long sum1 = addition(queue1);
        long sum2 = addition(queue2);

        int cnt = 0;
        int max = (q1.size() + q2.size()) * 2;

        while (cnt < max) {
            if (sum1 < sum2) {
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.offer(q2.poll());
            } else if (sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.offer(q1.poll());
            } else {
                return cnt;
            }

            cnt++;
        }

        return -1;
    }

    static Queue<Integer> arrToQueue(int[] arr) {
        Queue<Integer> q = new ArrayDeque<>();

        for (int n : arr) {
            q.offer(n);
        }

        return q;
    }

    static long addition(int[] arr) {
        long sum = 0;

        for (int n : arr) {
            sum += n;
        }

        return sum;
    }
}
