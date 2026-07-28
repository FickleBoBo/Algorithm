package day_28.leet_125;

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            if (!('0' <= l && l <= '9' || 'a' <= l && l <= 'z' || 'A' <= l && l <= 'Z')) {
                left++;
                continue;
            }

            char r = s.charAt(right);
            if (!('0' <= r && r <= '9' || 'a' <= r && r <= 'z' || 'A' <= r && r <= 'Z')) {
                right--;
                continue;
            }

            if (Character.toLowerCase(l) != Character.toLowerCase(r)) return false;
            left++;
            right--;
        }

        return true;
    }
}
