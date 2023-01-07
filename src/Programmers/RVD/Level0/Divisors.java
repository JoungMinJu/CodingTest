package Programmers.RVD.Level0;

import java.util.stream.IntStream;

public class Divisors {
    public static void main(String[] args) {
        System.out.println(solution(24));
    }
    public static int[] solution(int n){
        return IntStream.rangeClosed(1, n)
                .filter(i -> n%i==0)
                .sorted()
                .toArray();
    }
}
