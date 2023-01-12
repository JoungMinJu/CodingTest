package Programmers.RVD.Level0;

import java.util.HashSet;
import java.util.Set;

public class Factorization {
    // 소인수분해
    public int[] solution(int n) {
        Set<Integer> answer = new HashSet<>();

        for(int i=2; i<=n; i++){
            while(n%i == 0){
                answer.add(i);
                n /= i;
            }
        }


        return answer.stream()
                .mapToInt(i->i)
                .sorted()
                .toArray();

    }
}
