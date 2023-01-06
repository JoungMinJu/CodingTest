package Programmers.RVD.Level0;

import java.util.stream.IntStream;

public class OddNumbers {
    public int[] solution(int n){
        //n 이하의 홀수 리스트
        return IntStream.rangeClosed(0,n)
                .filter(value -> value % 2 ==1)
                .toArray();
    }
}
