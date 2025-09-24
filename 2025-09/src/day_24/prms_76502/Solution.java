package day_24.prms_76502;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        // 0칸부터 (s의 길이 - 1)칸까지 반복문으로 계산
        for (int i = 0; i < s.length(); i++) {
            if (isRight(s, i)) answer++;
        }

        return answer;
    }

    // 스택 자료구조로 올바른 괄호 문자열인지 판단
    private static boolean isRight(String str, int jump) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            // 시작 인덱스를 한 칸씩 옮기는 방식으로 회전 계산
            char c = str.charAt((i + jump) % str.length());

            // 열린 괄호면 스택에 푸시하고 닫힌 괄호면 최근에 스택에 푸시한 괄호와 대칭인지 비교
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        // 스택이 비어있지 않으면 괄호 짝이 안맞아서 남는 경우
        if (!stack.isEmpty()) return false;

        return true;
    }
}
