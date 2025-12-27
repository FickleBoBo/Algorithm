class Solution {
   public:
    bool isPalindrome(int x) {
        if (x < 0) return false;

        vector<int> v;
        while (x > 0) {
            v.push_back(x % 10);
            x /= 10;
        }

        int len = v.size();
        for (int i = 0; i < len / 2; i++) {
            if (v[i] != v[len - 1 - i]) return false;
        }

        return true;
    }
};
