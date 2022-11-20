package ssafy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
    public static int[] arr;
    public static int N;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testSize = Integer.parseInt(br.readLine());
        for(int test = 1; test <= testSize; test++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            count = 0;
            nQueen(0);
            sb.append("#").append(test).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());

    }

    public static void nQueen(int col){
        if(col == N){
            count++;
            return;
        }
        for(int row=0; row<N; row++){
            arr[col] = row;
            if(isPossible(col)){
                nQueen(col+1);
            }
        }
    }

    public static boolean isPossible(int col){
        for(int i=0; i<col; i++){
            if(arr[col] == arr[i]){
                return false;
            }
            // 대각선 판별
            else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i])){
                return false;
            }
        }
        return true;
    }
}
