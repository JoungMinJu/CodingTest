package Programmers.Level3;
public class pulse
{
    public long solution(int[] sequence) {
        long dp[][] = new long[sequence.length][2];
        dp[0][0] = sequence[0] * -1;
        dp[0][1] = sequence[0];

        long answer = Math.max(dp[0][0], dp[0][1]);
        for (int i = 1; i < sequence.length; i++) {
            long now_num = sequence[i];
            dp[i][0] = Math.max(dp[i-1][1] - now_num, -now_num);
            dp[i][1] = Math.max(dp[i-1][0] + now_num, now_num);
            answer = Math.max(answer, dp[i][0]);
            answer = Math.max(answer, dp[i][1]);
        }
        return answer;
    }
}
