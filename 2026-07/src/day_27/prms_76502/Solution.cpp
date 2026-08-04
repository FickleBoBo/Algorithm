#include <bits/stdc++.h>
using namespace std;

int solution(string s) {
    int ans = 0;

    for (int i = 0; i < s.size(); i++) {
        stack<char> stk;
        bool flag = true;

        for (int j = i; j < i + s.size(); j++) {
            char c = s[j % s.size()];

            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else {
                if (stk.empty()) {
                    flag = false;
                    break;
                } else if (c == ')') {
                    if (stk.top() == '(') {
                        stk.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else if (c == '}') {
                    if (stk.top() == '{') {
                        stk.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stk.top() == '[') {
                        stk.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
        }

        if (!stk.empty()) {
            flag = false;
        }

        if (flag) {
            ans++;
        }
    }

    return ans;
}
