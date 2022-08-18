package study.F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // n+1개의 집합을 이루고 있다.
        int m = Integer.parseInt(st.nextToken()); // 입력으로 주어지는 연산의 개수
        parent = new int[n+1];

        // 부모 배열 초기화
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        for (int test = 0; test < m; test++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (command) {
                case 0:
                    union(a,b);
                    break;
                case 1:
                    sb.append(isSameParent(a,b)?"YES\n":"NO\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        // 작은 쪽으로 합친다.
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x<y) parent[y] = x;
            else parent[x] = y;
        }
    }

    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        return x==y;
    }
}
