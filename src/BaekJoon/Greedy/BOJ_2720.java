package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2720 {
    static int t;
    static int[] c;
    static int[] money = {25,10,5,1};
    static String get_change(int change) {
        String tmp = "";
        for(int i=0;i<4;i++) {
            tmp+=(change/money[i])+" ";
            change%=money[i];
        }
        return tmp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        c = new int[t];
        for(int i=0;i<t;i++)
            c[i] = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
            sb.append(get_change(c[i])+"\n");

        System.out.println(sb);
    }
}
