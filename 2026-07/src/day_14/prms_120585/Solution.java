package day_14.prms_120585;

class Solution {
    public int solution(int[] array, int height) {
        int cnt = 0;

        for (int x : array) {
            if (x > height) cnt++;
        }

        return cnt;
    }
}
