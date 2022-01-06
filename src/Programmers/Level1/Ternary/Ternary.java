package Programmers.Level1.Ternary;

public class Ternary {
    public int solution(int n){
        String ans = "";
        int div = 0;
        while(n > 0){
            div = n%3;
            ans += Integer.toString(div);
            n = n/3;
        }
        int temp=0;
        int answer =0;
        for(int i= ans.length()-1;i>=0;i--){
            temp = ans.charAt(i)-'0';
            answer += (temp * Math.pow(3,ans.length()-1-i));
        }
        return answer;
    }
}
