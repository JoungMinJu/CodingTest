package Programmers.Level1.Ternary;

public class Ternary_adv {
    public int solution(int n){
        String a ="";
        while(n>0){
            a = a+(n%3);
            n/=3;
        }

        // 3진법으로 그냥 바꿔주네
        return Integer.parseInt(a, 3);
    }
}
