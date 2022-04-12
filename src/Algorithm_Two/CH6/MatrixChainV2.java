package Algorithm_Two.CH6;

import java.io.IOException;
import java.util.Scanner;

public class MatrixChainV2 {
    static class Matrix{
        // 행렬 정보 저장 클래스
        private int x;
        private int y;

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N; // 행렬 개수
    static Matrix[] M; // 행렬 저장 배열
    static int[][] D; // i~j번째 행렬까지 최소 연산 횟수를 저장하는 배열

    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        N = sc.nextInt();
        // 지수 1 부터 시작
        M  = new Matrix[N+1];
        D = new int[N+1][N+1];

        // 초기화
        for(int i=0;i<N+1;i++){
            for(int j=0;j<N+1;j++){
                D[i][j] = -1;
            }
        }

        //
        for(int i=1;i<=N;i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            // Mi = (y) x (x) 행렬
            M[i] = new Matrix(y, x);
        }
        System.out.println(excute(1,N));

    }
    // 탑 다운 방식 점화식 함수 구현
    static int excute(int start, int end){
        int result = Integer.MAX_VALUE;

        if(D[start][end]!= -1)return D[start][end]; // 이미 계산한 적 있으며 ㄴ그거 그냥 return
        if(start == end) return 0; // 행렬 한 개의 곱셈 연산의 수
        if(start+1 == end) {
            // 행렬 두 개의 곱셈 연산의 수
            return M[start].y*M[start].x*M[end].x;
        }
        // 행렬이 세 개 이상일 경우 곱셈 연산의 수
        for(int i=start; i<end; i++){
            result = Math.min(result, (excute(start,i))+(excute(i+1, end))+(M[start].y*M[i].x*M[end].x));
        }
        return D[start][end] = result;
    }
}
