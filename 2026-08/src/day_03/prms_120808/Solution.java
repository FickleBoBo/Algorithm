package day_03.prms_120808;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int g = gcd(numer1 * denom2 + numer2 * denom1, denom1 * denom2);
        return new int[]{(numer1 * denom2 + numer2 * denom1) / g, (denom1 * denom2) / g};
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
