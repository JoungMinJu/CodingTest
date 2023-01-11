package Programmers.RVD.Level0;

import java.util.stream.IntStream;

public class CompositeNumber {
    public int solution(int n){
        return (int) IntStream.rangeClosed(1, n)
                .filter(i -> (int) IntStream.rangeClosed(1, i)
                        .filter(i2 -> i % i2 ==0)
                        .count()>2)
                .count();
    }
}
