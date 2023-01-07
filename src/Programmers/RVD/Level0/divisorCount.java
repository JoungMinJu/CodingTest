package Programmers.RVD.Level0;

import java.util.stream.IntStream;

public class divisorCount {
    // 약수 개수 구하기
    public int solution(int n){
        return (int) IntStream.rangeClosed(1, n)
                .filter(i -> n%i==0)
                .count();
    }
}
