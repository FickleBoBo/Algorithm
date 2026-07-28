#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    bool isPalindrome(string s) {
        int left = 0;
        int right = s.size() - 1;

        while (left < right) {
            char l = s[left];
            if (!('0' <= l && l <= '9' || 'a' <= l && l <= 'z' || 'A' <= l && l <= 'Z')) {
                left++;
                continue;
            }

            char r = s[right];
            if (!('0' <= r && r <= '9' || 'a' <= r && r <= 'z' || 'A' <= r && r <= 'Z')) {
                right--;
                continue;
            }

            if (tolower(l) != tolower(r)) return false;
            left++;
            right--;
        }

        return true;
    }
};
