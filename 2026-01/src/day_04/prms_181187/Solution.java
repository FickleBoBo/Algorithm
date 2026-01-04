package day_04.prms_181187;

class Solution {
    public long solution(int r1, int r2) {
        long ans = 0;

        for (long x = 1; x <= r2; x++) {
            int max = (int) Math.sqrt((long) r2 * r2 - x * x);
            int min = (int) Math.ceil(Math.sqrt((long) r1 * r1 - x * x));
            ans += max - min + 1;
        }

        return ans * 4;
    }
}
