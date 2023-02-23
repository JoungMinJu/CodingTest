package Programmers.Level2;

//https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.Stack;

public class RemovingPair {
    public int solution(String s)
    {
        char now;

        Stack<Character> stack = new Stack<>();
        for (int i =0; i<s.length(); i++){
            now = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != now) {
                stack.push(now);
            } else {
                stack.pop();
            }
        }

        return (stack.isEmpty()) ? 1 : 0;
    }
}
