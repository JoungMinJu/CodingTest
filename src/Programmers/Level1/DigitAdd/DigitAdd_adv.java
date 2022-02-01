package Programmers.Level1.DigitAdd;

public class DigitAdd_adv {
    public int solution(int n){
        int answer = 0 ;
        while(true){
            answer += n%10;
            if(n<10) break;
            n = n/10;
        }
        return answer;
    }
}
