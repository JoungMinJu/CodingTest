package study.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960 {
    static int n,k;
    static boolean[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n  = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new boolean[n+1];
        int index = 2;
        int answer = 0;

        Loop1 : while(true){
            for(int i=index, mult=2; i<=n; i=(index * mult++)){
                if(! map[i]){
                    map[i] = true;
                    answer ++;
                    if(answer == k) {
                        System.out.println(i);
                        break Loop1;
                    }
                }
            }
            while(map[index]){
                index++;
            }
        }
    }
}
