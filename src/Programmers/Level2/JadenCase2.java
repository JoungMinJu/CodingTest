package Programmers.Level2;

//https://school.programmers.co.kr/learn/courses/30/lessons/12951

public class JadenCase2 {
    public String solution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");// sp에는 소문자 하나씩이 저장됨
        boolean flag = true;

        for (String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }
        return answer;
    }
}
