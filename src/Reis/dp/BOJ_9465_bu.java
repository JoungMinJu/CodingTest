package Reis.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
이번 문제의 점화식은 이렇게 세울 수 있습니다. 이번엔 변수가 1개가 아니라 2개인 함수를 사용할 겁니다.
sticker(c, status)이 있을 때, c는 스티커 중 c번 열부터만 스티커를 떼어내서 얻을 수 있는 최대 가치를 구하겠다는 겁니다.
status는 0이면 바로 왼쪽 열에는 떼어낸 스티커가 없다는 뜻이고, 1이면 왼쪽 열의 위 스티커를, 2면 왼쪽 열의 아래 스티커를 방금 뗐다는 뜻입니다. 이건 c열 스티커를 뗄 수 있는지 판별하는데 중요하고, 없어서는 안 되는 정보입니다.
즉 맨 처음에 부르는 함수는 sticker(0, 0)입니다. 그리고 이건 ①위쪽 스티커를 떼는 걸 선택하여 그 스티커의 가치 + sticker(1, 1), ②아래쪽 스티커를 떼는 걸 선택하여 그 스티커의 가치 + sticker(1, 2), ③아무 스티커도 떼지 않는 걸 선택하여 sticker(1, 0) 이 3개 중 최댓값을 답으로 가질 겁니다. 자, 이제 패턴이 슬슬 보이시나요?
[출처] 동적 계획법(Dynamic Programming) (수정: 2019-02-07)|작성자 라이
 */
public class BOJ_9465_bu {
    public static int[][] value;
    public static int[][] dp;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        value = new int[2][100000];
        dp = new int[100000][3];
        // 가능한 경우의 수가 3개 이므로!

        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            for(int i = 0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++){
                    value[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dp 배열 초기화.value가 0일수도 있으니께
            for (int i= 0; i<N; i++){
                for(int j = 0; j<3; j++){
                    dp[i][j] = -1;
                }
            }

            System.out.println(sticker(0,0));
        }
    }

    private static int sticker(int c, int status) {
        if (c == N)
            return 0;
        if(dp[c][status] != -1)
            return dp[c][status];
        int result = sticker(c+1, 0); // 안한경우
        if (status != 1)
            result = Math.max(result, sticker(c+1, 1) + value[0][c]);
        if (status != 2)
            result = Math.max(result, sticker(c+1, 2) +value[1][c]);
        dp[c][status] = result;
        return result;
    }
}
