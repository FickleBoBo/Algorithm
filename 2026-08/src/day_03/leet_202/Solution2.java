package day_03.leet_202;

class Solution2 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = func(slow);
            fast = func(func(fast));
        } while (slow != fast);

        return slow == 1;
    }

    static int func(int x) {
        int sum = 0;
        while (x > 0) {
            int r = x % 10;
            sum += r * r;
            x /= 10;
        }
        return sum;
    }
}
