package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/12951

public class JadenCase {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> que = new LinkedList<>();

        for (int i =0; i < s.length(); i++) {
            if ( i == 0) {
                que.add(Character.toUpperCase(s.charAt(i)));
            }
            else {
                que.add(Character.toLowerCase(s.charAt(i)));
            }
        }


        while (!que.isEmpty()) {
            char now  = que.poll();
            sb.append(now);
            if (now == ' ' && que.size() >= 1) {
                if (Character.isAlphabetic(que.peek())) {
                    sb.append(Character.toUpperCase(que.poll()));
                }
            }
        }
        return sb.toString();
    }
}
