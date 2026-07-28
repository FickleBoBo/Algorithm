package day_27.prms_76502;

import java.util.*;

class Solution {
    public int solution(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            Deque<Character> stk = new ArrayDeque<>();
            boolean flag = true;

            for (int j = i; j < i + s.length(); j++) {
                char c = s.charAt(j % s.length());

                if (c == '(' || c == '{' || c == '[') {
                    stk.push(c);
                } else {
                    if (stk.isEmpty()) {
                        flag = false;
                        break;
                    } else if (c == ')') {
                        if (stk.peek() == '(') {
                            stk.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    } else if (c == '}') {
                        if (stk.peek() == '{') {
                            stk.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    } else if (c == ']') {
                        if (stk.peek() == '[') {
                            stk.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if (!stk.isEmpty()) {
                flag = false;
            }

            if (flag) {
                ans++;
            }
        }

        return ans;
    }
}
