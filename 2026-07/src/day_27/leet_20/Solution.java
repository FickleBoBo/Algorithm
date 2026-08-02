package day_27.leet_20;

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stk.push(c);
            } else {
                if (stk.isEmpty()) return false;

                char x = stk.pop();
                if (c == ')' && x != '(') return false;
                if (c == '}' && x != '{') return false;
                if (c == ']' && x != '[') return false;
            }
        }

        return stk.isEmpty();
    }
}
