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
                if (c == ')' && stk.pop() != '(') return false;
                if (c == '}' && stk.pop() != '{') return false;
                if (c == ']' && stk.pop() != '[') return false;
            }
        }

        return stk.isEmpty();
    }
}
