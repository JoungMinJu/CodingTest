package ssafy.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testSize = Integer.parseInt(br.readLine());

        for(int test=1; test<=testSize; test++){
            st= new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            int[] max = new int[(n - m + 1) * (n - m + 1)];
            int count = 0;

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<= (n-m); i++){
                for(int j=0; j<=(n-m); j++){
                    for(int k=0; k<m; k++){
                        for(int l=0; l<m; l++){
                            max[count] += map[i+k][j+l];
                        }
                    }
                    count++;
                }
            }

            Arrays.sort(max);
            sb.append("#").append(test).append(" ").append(max[max.length-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
