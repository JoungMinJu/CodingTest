package Programmers.RVD.Level0;

public class Combination2 {
    // 조합 (+팩토리얼) 크기 큰 경우 -> 수학적인..
    public long solution(int balls, int share){
        // balls 개 중에 share 개 뽑는 경우의 수
        long result;

        if (share ==0){
            return 1;
        }

        result = solution(balls -1, share -1);
        result *= balls;
        result /= share;

        return result;
    }
}
