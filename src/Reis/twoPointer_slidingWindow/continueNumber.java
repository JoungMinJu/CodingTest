package Reis.twoPointer_slidingWindow;

public class continueNumber {
    public int solution(int n) {
        int answer = 0, sum = 0, lt = 1;
        for (int rt = 1; rt <= n; rt++){
            sum += rt;
            if (sum == n) {
                answer++;
            }
            while(sum >= n) {
                sum -= lt;
                lt++;
                if(sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
