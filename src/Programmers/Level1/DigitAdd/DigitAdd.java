package Programmers.Level1.DigitAdd;

public class DigitAdd {
    public int solution(int n){
        int answer = 0 ;
        String tmp = String.valueOf(n);
        for(int i=0;i<tmp.length();i++){
            answer += tmp.charAt(i) - '0';
        }
        return answer;
    }
}
