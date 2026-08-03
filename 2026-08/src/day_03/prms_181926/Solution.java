package day_03.prms_181926;

class Solution {
    public int solution(int n, String control) {
        for (char c : control.toCharArray()) {
            if (c == 'w') {
                n += 1;
            } else if (c == 's') {
                n -= 1;
            } else if (c == 'd') {
                n += 10;
            } else {
                n -= 10;
            }
        }

        return n;
    }
}
