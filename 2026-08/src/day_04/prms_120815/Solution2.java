package day_04.prms_120815;

class Solution2 {
    public int solution(int n) {
        return n / gcd(6, n);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
