package Programmers.RVD.Level0;

public class Combination {
    public int solution(int balls, int share) {
        // 서로 다른 n개 중 m개를 뽑는 경우의 수 (n!/(n-m)!*m!)
        return factorial(balls) / (factorial(balls-share) * factorial(share));
    }

    private int factorial(int n){
        if(n<=1){
            return n;
        }
        return n * factorial(n-1);
    }
}