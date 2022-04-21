package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int xy[][] = new int[n][2];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xy[i][1] = Integer.parseInt(st.nextToken());
            xy[i][0] = Integer.parseInt(st.nextToken());
        }
        // https://st-lab.tistory.com/111
        Arrays.sort(xy, (xy1, xy2)->{
            if(xy1[0] == xy2[0]) return xy1[1]-xy2[1];
            else return xy1[0] -xy2[0];
        });
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(xy[i][1]+" "+xy[i][0]).append('\n');
        }
        System.out.println(sb);
    }
}
