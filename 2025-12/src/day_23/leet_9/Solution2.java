package day_23.leet_9;

class Solution2 {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }

        return true;
    }
}
