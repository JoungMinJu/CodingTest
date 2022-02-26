package BaekJoon.Shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 유저의 수
        int n = Integer.parseInt(st.nextToken());
        // 친구 관계의 수
        int m = Integer.parseInt(st.nextToken());

        // 인접행렬
        int[][] arr = new int[n+1][n+1];

        // 초기화
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==j) {arr[i][j] = 0; continue;}
                arr[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] =1;
        }

        // 거쳐가는 노드 중심!
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(arr[i][k]!=Integer.MAX_VALUE && arr[k][j] !=Integer.MAX_VALUE){
                        arr[i][j] = Math.min(arr[i][k]+arr[k][j], arr[i][j]);
                    }
                }
            }
        }

        // 케빈베이컨 수가 가장 적은 사람 출력하기
        int answer = n;
        int result = 0;
        // 맨 마지막 노드부터 검증
        for(int i=1;i<n+1;i++){
            result += arr[n][i];
        }

        for(int i=n-1;i>=1;i--){
            int tmp = 0;
            for(int j=1;j<n+1;j++){
                tmp += arr[i][j];
            }
            if(tmp <= result){
                result = tmp;
                answer = i;
            }
        }


        System.out.println(answer);
//        System.out.println();
//
//        for(int i=1;i<n+1;i++){
//            for(int j=1;j<n+1;j++){
//                System.out.println(i+" "+j+" = "+arr[i][j]);
//            }
//            System.out.println();
//        }
    }
}
