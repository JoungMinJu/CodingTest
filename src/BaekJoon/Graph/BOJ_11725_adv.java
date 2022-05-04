package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_adv {

    //https://hongku.tistory.com/253

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i,j;

        ArrayList<Integer>[] lst = new ArrayList[n+1];
        //초기화
        for(i=1;i<=n;i++){
            lst[i] = new ArrayList<>();
        }
        // 연결
        for(i=0;i<n-1;i++){
            StringTokenizer st= new StringTokenizer(br.readLine(),"");
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            lst[a].add(b);
            lst[b].add(a);
        }
        // 결과 값 (부모값)
        // 예: parents[i] = j(i의 부모 : j)
        int[] parents = new int[n+1];
        dfs(lst, parents, n, 1, 0);
        // 결과 출력
        for(j=2;j<=n;j++) System.out.println(parents[j]);
    }

    private static void dfs(ArrayList<Integer>[] lst, int[] parents, int n, int start, int parent){
        parents[start] = parent;
        for (Integer item : lst[start]) {
            if(item!=parent) dfs(lst, parents, n, item, start);
        }
    }
}
