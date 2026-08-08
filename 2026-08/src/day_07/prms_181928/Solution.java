package day_07.prms_181928;

class Solution {
    public int solution(int[] num_list) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();

        for (int x : num_list) {
            if (x % 2 == 1) {
                odd.append(x);
            } else {
                even.append(x);
            }
        }

        return Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());
    }
}
