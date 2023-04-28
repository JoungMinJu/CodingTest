package Programmers.Level2;

public class triangle {
        public int solution(int[][] triangle) {
            int height = triangle.length;
            int[][] dp = new int[triangle.length][triangle[height-1].length];
            dp[0][0] = triangle[0][0];
            for(int len = 1; len < height; len++) {
                int width = triangle[len].length;
                for(int wid = 0; wid < width; wid++){
                    if (wid == 0) {
                        dp[len][wid] = dp[len-1][wid] + triangle[len][wid];
                    }
                    else if (wid == width-1) {
                        dp[len][wid] = dp[len-1][wid-1] + triangle[len][wid];
                    }
                    else {
                        dp[len][wid] = Math.max(dp[len-1][wid], dp[len-1][wid-1]) + triangle[len][wid];
                    }
                }
            }

            int width = triangle[height-1].length;
            int answer = 0;
            for(int wid = 0; wid < width; wid++) {
                if (answer < dp[height-1][wid]) {
                    answer = dp[height-1][wid];
                }
            }
            return answer;
        }
}
