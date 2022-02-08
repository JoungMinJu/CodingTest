package Programmers.Level1.DivisoAdd;

public class DivisorAdd_adv {
    // 약수의 합이니까 ~.. 다 돌릴 필요가 없었구만

    public int solution(int num){
        int answer = 0;
        for(int i=1; i<=num/2;i++){
            if(num%i==0) answer +=i;
        }
        return answer +=num;
    }
}
