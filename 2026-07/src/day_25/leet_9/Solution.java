package day_25.leet_9;

class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        String rev = new StringBuilder(str).reverse().toString();

        return str.equals(rev);
    }
}
