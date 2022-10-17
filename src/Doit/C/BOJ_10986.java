package DoIt.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10986 {
    static int[][] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] sum = new int[n];
        int[] count = new int[m];
        ch = new int[n+1][n+1];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++) sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++)
            sum[i] = sum[i] % m;

        for(int i=0; i<n; i++)
            count[sum[i]] ++;

        answer += count[0];

        // 조합구하기 v1
//        for(int i=0; i<m; i++){
//            if(count[i] > 0){
//                answer += dfsMemo(count[i],2);
//            }
//        }

        // 조합구하기 v2
        for(int i=0; i<m; i++){
            if(count[i] > 1)
                answer += (count[i] * (count[i]-1)/2);
        }
        System.out.println(answer);
    }
    // 조합 nCr = n-1Cr-1 + c-1Cr
    // nCn == 1
    // nC0 == 1
    // 메모이제이션 방법 사용
    static int dfsMemo(int n, int r){
        if(n == r || r == 0 ) return 1;
        if(ch[n][r] > 0 ) return ch[n][r];
        ch[n][r] = dfsMemo(n-1, r-1) + dfsMemo(n-1, r);
        return ch[n][r];
    }
}
