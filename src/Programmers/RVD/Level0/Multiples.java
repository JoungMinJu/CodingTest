package Programmers.RVD.Level0;

import java.util.Arrays;

public class Multiples {
    // n의 배수만 넣은 리스트 만들기
    public int[] solution(int n, int[] numList){
        return Arrays.stream(numList)
                .filter(value -> value % n ==0)
                .toArray();
    }
}
