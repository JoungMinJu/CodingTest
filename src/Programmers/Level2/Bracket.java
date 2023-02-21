package Programmers.Level2;

import java.util.Stack;

public class Bracket {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char now, before;

        for (int  i = 0; i < s.length(); i++){
            now = s.charAt(i);
            if (now == '(') {
                stack.push(now);
            }
            else if (now == ')') {
                if (stack.size() < 1) {
                    return false;
                }
                before = stack.pop();
                if (before != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
