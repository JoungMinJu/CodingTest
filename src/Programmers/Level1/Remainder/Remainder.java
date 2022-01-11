package Programmers.Level1.Remainder;


// 테스트3, 4가 안되는 내 코드
public class Remainder {
    public int solution(int n){
        int answer = 0;
        // n-1의 약수 구하기
        int sqrt = (int) Math.sqrt(n);
        answer = n-1;

        for(int i =2;i<=sqrt;i++){
            if(n % i==1){
                answer = i;
            }
        }
        return answer;
    }
}
