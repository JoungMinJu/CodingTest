package Programmers.Level1.Remainder;

public class Remainder_adv {
    public int solution(int n){
        // 걍 단순하게 풀면 되
        for(int i=2; i<n; i++){
            if(n%i ==1){
                return i;
            }
        }
        return 0;
    }
}
