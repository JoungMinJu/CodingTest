package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    /*
    그리디는 안통하니? -> 무조건 뗄 수 있는만큼 떼지 않고 사이를 비워둬야 후에 큰 가치의 스티커를 뗄 수 있는 경우도 생기니까
    모든 경우를 다 살펴보며 답을 찾아야 한다.

    sticker(c, status)가 있을 때, c는 스티커 중 c번 열부터만 스티커를 떼어내서 얻을 수 있는 최대 가치를 구하겠다는 것.
    status = 0
    -> 바로 왼쪽 열에는 떼어낸 스티커가 없다는 뜻
    status = 1
    -> 왼쪽 열의 위 스티커를
    status = 2
    -> 왼쪽 열의 아래 스티커를 방금 뗐다는 뜻.

    그래서
    1. 위쪽 스티커를 떼는 것을 선택해서 그 스티커의 가치 + sticker(1,1)
    2. 아래쪽 스티커를 떼는 것을 선택해서 그 스티커의 가치 + sticker(1,2)
    3. 아무 스티커도 떼지 않는 것을 선택하여 sticker(1,0)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++){
            int N = Integer.parseInt(br.readLine());

            int[][] stickers = new int[2][N+1];
            int[][] dp = new int[2][N+1];

            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j<=N; j++){
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 첫번째 column은 자기 자신이 최대!
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for(int i = 2; i<=N; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + stickers[1][i];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
