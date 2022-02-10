package Programmers.Level1.WeirdString;

import java.util.Locale;

public class WeiredString_adv2 {
    public String solution(String s){
        String answer = "";
        int cnt = 0;
        String[] array = s.split("");
        for(String ss: array){
            cnt = ss.contains(" ")? 0:cnt +1;
            answer += cnt%2==0?ss.toLowerCase():ss.toUpperCase();
        }
        return answer;
    }
}
