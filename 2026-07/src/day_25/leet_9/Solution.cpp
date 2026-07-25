#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    bool isPalindrome(int x) {
        string str = to_string(x);
        string rev(str.rbegin(), str.rend());

        return str == rev;
    }
};
