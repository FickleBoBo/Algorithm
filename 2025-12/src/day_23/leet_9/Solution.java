package day_23.leet_9;

class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        String revStr = new StringBuilder(str).reverse().toString();

        return str.equals(revStr);
    }
}
