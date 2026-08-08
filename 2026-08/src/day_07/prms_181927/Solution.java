package day_07.prms_181927;

class Solution {
    public int[] solution(int[] num_list) {
        int[] ans = new int[num_list.length + 1];
        for (int i = 0; i < num_list.length; i++) {
            ans[i] = num_list[i];
        }

        int a = num_list[num_list.length - 2];
        int b = num_list[num_list.length - 1];

        if (b > a) {
            ans[ans.length - 1] = b - a;
        } else {
            ans[ans.length - 1] = b * 2;
        }

        return ans;
    }
}
