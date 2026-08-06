package day_06.prms_120905;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int cnt = 0;
        for (int x : numlist) {
            if (x % n == 0) cnt++;
        }

        int[] ans = new int[cnt];
        int idx = 0;
        for (int x : numlist) {
            if (x % n == 0) ans[idx++] = x;
        }

        return ans;
    }
}
