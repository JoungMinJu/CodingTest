package Programmers.Level1.Change;

public class Change {
    public int solution(String s) {
        int answer = 0;
        int sign = s.charAt(0) == '-' ? -1 : 1;
        int index = s.charAt(0) == '-' ? 1 : (s.charAt(0) == '+' ? 1 : 0);
        int len = s.length() - 1;

        for (int i = index; i < s.length(); i++) {
            answer += (s.charAt(i) - '0') * Math.pow(10, len - i);
        }
        return answer * sign;
    }

}
