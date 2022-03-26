package BaekJoon.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11060 {
    static int map[];
    static int n;
    static boolean check[];
    static Stack<Integer> stk;
    static int count ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n];
        check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        count = Integer.MAX_VALUE;
        bfs(0,0);
        if(count == Integer.MAX_VALUE){
            count = -1;
        }
        System.out.println(count);

    }
    private static void bfs(int a, int cnt) {
        if(a < 0 || a>=n){return;}
        if(a == (n-1)) {
            if(cnt < count ) count = cnt;
            return;
        }
        int tmp = map[a];
        cnt++;
        for(int i=tmp; i>=1; i--){
//            System.out.println("a+1 = " + (a + 1));
//            System.out.println("cnt++ = " + ++cnt);
            bfs(a+i, cnt);
        }
    }
}
