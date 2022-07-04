package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int tmp = 0;
        for(int i=0; i<n; i++){
            tmp = Integer.parseInt(st.nextToken());
            if(!map.containsKey(tmp)) map.put(tmp, 0);
            map.put(tmp, map.get(tmp)+1);
        }
        int m =Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            tmp = Integer.parseInt(st.nextToken());
            if(map.containsKey(tmp)){
                sb.append(map.get(tmp)).append(" ");
            }
            else
                sb.append(0).append(" ");
        }
        System.out.println(sb.toString());
    }
}
