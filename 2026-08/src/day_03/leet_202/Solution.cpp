#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int func(int x) {
        int sum = 0;
        while (x > 0) {
            int r = x % 10;
            sum += r * r;
            x /= 10;
        }
        return sum;
    }

    bool isHappy(int n) {
        unordered_set<int> st;

        int res = func(n);
        while (true) {
            if (res == 1) {
                return true;
            } else if (st.count(res)) {
                return false;
            } else {
                st.insert(res);
                res = func(res);
            }
        }
    }
};
