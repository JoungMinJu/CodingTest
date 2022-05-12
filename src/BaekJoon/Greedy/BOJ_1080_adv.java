package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1080_adv {
    // 어려워요
    // -> A와 B를 비교해가면서 다를 때 뒤집는 것이 최선 (0,0) -> (N-1, M-1)로 탐색해가면서

    /**
     * 문제의 조건을 보면 행렬A의 부분 행렬(3 by 3)을 변환해 행렬B를 만들 수 있는지 확인해야 하기 때문에 어려워보일 수 있습니다.
     * 하지만 문제를 조금 간단하게 생각한다면 행렬의 가장 왼쪽 위 부분 (0,0)부터 오른쪽 아래로 내려가며 비교를 한다면 문제에 접근하는게 쉬워집니다.
     * 왜냐하면 부분행렬을 변환해야 하는데 부분행렬의 가장 왼쪽 위 원소는 비교하는 그 순간만 변환할 수 있기 때문입니다. 말로 풀어쓰기가 조금 힘들지만 그림을 그려보면 쉽게 이해하실 수 있습니다.
     * 행렬A의 (0, 0)을 시작으로 행렬A와 행렬B의 (i, j)원소가 다를 경우 (i, j)를 부분 행렬의 왼쪽 위로 기준을 잡고 3 by 3행렬을 변환 시킵니다. 표를 그려보면 아래와 같습니다.
     */

    static int height, width;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);

        boolean[][] A = getMatrix();
        boolean[][] B = getMatrix();

        System.out.println(solve(A,B));

    }

    private static int solve(boolean[][] A, boolean[][] B) {
        int ans = 0;
        if(width <3 || height < 3){
            return isSameMatrix(A, B)? ans: -1;
        }
        for(int i=0;i<height-2;i++){
            for(int j=0;j<width-2;j++){
                if(A[i][j] ^ B[i][j]){
                    ans += togglePartialMatrix(A, i, j);
                }
            }
        }
        return isSameMatrix(A, B)? ans:-1;
    }

    private static boolean isSameMatrix(boolean[][] A, boolean[][] B) {
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }

    private static int togglePartialMatrix(boolean[][] A, int row, int col) {
        for(int i=row;i<row+3;i++){
            for(int j=col; j<col+3;j++){
                A[i][j] = !A[i][j];
            }
        }
        return 1;
    }



    private static boolean[][] getMatrix() throws IOException{
        boolean[][] matrix = new boolean[height][width];
        for(int i=0;i<height;i++){
            String row= br.readLine();
            for(int j=0;j<width;j++){
                if(row.charAt(j) =='1'){
                    matrix[i][j] = true;
                }else{
                    matrix[i][j] = false;
                }
            }
        }
        return matrix;
    }
}
