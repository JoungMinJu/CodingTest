package Programmers.Level1.MidLet;

public class MidLet {
    public String solution(String s){
        int half = 0;
        String answer = "";
        half = s.length()/2;
        if(s.length() % 2 == 0) return s.substring(half-1, half+1);
        return ""+s.charAt(half);
    }
}
