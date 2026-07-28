#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    bool isValid(string s) {
        stack<char> stk;

        for (char c : s) {
            if (c == '(' || c == '[' || c == '{') {
                stk.push(c);
            } else {
                if (stk.empty()) return false;

                char x = stk.top();
                stk.pop();

                if (c == ')' && x != '(') return false;
                if (c == '}' && x != '{') return false;
                if (c == ']' && x != '[') return false;
            }
        }

        return stk.empty();
    }
};
