package Algorithm_Two.CH6;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        // M1= 10x20
        // M2 = 20x50
        // M3 = 50x1
        // M4 = 1x100

        int arr[] = {10,20,50,1,100};
        int size = arr.length;

        System.out.println("분할 정복 이용한 최소 곱셈 횟수:"+
                            +MatrixMult_DC(arr, 1, size-1));
        System.out.println("동적 계획 이용한 최소 곱셈 횟수:"+
                            +MatrixMult_DP(arr, size));
    }
    // 분할 정복 이용
    static int MatrixMult_DC(int r[], int i, int j){
        // 마지막 번쨰의 행렬이 j이니까! size-1한다.
        int k;

        if(i==j) return 0;
        else{
            int min_val = Integer.MAX_VALUE;
            for(k = i;k<j;k++){
                min_val = Math.min(min_val, MatrixMult_DC(r, i, k)+MatrixMult_DC(r, k+1,j)+(r[i-1]*r[k]*r[j]));
            }
            return min_val;
        }
    }
    // 동적 계획법 이용
    static int MatrixMult_DP(int r[], int n){
        // 프로그램을 단순화하기 위해 m의 첫 번째 행과 열은 사용하지 않는다.
        int m[][]=new int[n][n];
        int i, j, k, len, q;

        // 행렬이 하나만 있으며 ㄴ곱할 필요 없음
        for(i=1;i<n;i++) m[i][i] = 0;

        // len은 행렬 곱셈들의 수
        // n은 4면 len = 1 2
        for(len = 1;len<n-1;len++){
            for(i=1; i<n-len;i++){
                j = i+len;
                // Mix .. xMj까지의 최소 곱셈 횟수
                m[i][j] = Integer.MAX_VALUE;
                for(k=i;k<j;k++){
                    // q= 두개의 행렬 곱으로 분할 한 후 곱하는 경우의 최소 곱셈 횟수
                    q=m[i][k]+m[k+1][j]+(r[i-1]*r[k]*r[j]);
                    if(q<m[i][j]) m[i][j] = q;
                }
            }
        }
        return m[1][n-1];
    }

}
