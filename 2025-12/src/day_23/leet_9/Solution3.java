package day_23.leet_9;

class Solution3 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int[] arr = new int[32];
        int len = 0;
        while (x > 0) {
            arr[len++] = x % 10;
            x /= 10;
        }

        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - 1 - i]) return false;
        }

        return true;
    }
}
