package BaekJoon.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    // [ 인접행렬 ]
    // 배열로 구현아므로 이해가 쉬워서 구현률이 높다.
    // A[1][4]가 1인지만 알면 1번 꼭지점과 4번 꼭지점이 연결되어있는지 알 수 있다.
    // 하지만 꼭지점 개수가 적을때만 가능하다.
    // 대부분 시작점에서 도착점을 찾는 방식의 탐색을 많이 하는데
    // 그 개수는 v가 많아지면 v가 많아질수록 그만큼 탐색 시간이 오래걸리게 되고
    // 매번 연결지점을 찾으려면 v 크기만큼 돌아야하므로 시간초과에 걸릴 가능성이 높음
    // -> 따라서 인접행렬은 꼭지점이 적은 경우에만 사용하는 것

    // [ 인접 리스트 ]
    // 그저 자신의 노드에서 갈 수 있는 노드를 가지고 있다고 생각하면 쉽다.
    // 인접 리스트는 내가 어디로 갈지를 알려주기만 하면 되므로 내가 찾으면 됨.
    // 시간 복잡도가 주는데, A노드와 B노드가 연결되어 있는지를 알고 싶은 경우엔
    // 인접 리스트는 A에는 B가 있는지,B에는 A가 있는지를 파악해서
    // 연결되어 있는걸 확인해야하기 때문에


    // 인접행렬로 구현
    static int map[][];
    static boolean[] visit;
    static int n,m,v;

    // stack에 하나 넣고
    // 꺼내고 걔의 자식 노드들 다 스택에 넣고 출력
    // 그리고 스택에서 하나 꺼내고 걔의 자식노드 추가하고 꺼낸애 출력하고
   public static void dfs(int i){
        visit[i] = true;
        System.out.print(i+" ");
        for(int j=1; j<n+1; j++){
            if((map[i][j] == 1 && visit[j]) == false){
                dfs(j);
            }
        }
    }

    /// 밑에서 하나 꺼내고 그 노드의 자식들 큐에 추가하고 출력해주기

    public static void bsf(int i){
        Queue<Integer> que = new LinkedList<Integer>();
        // 추가하는데 이미 큐가 꽉 찬 경우 false를 반환한다.
        que.offer(i);
        visit[i] = true;
        while(!que.isEmpty()){
            // 삭제
            int temp = que.poll();
            System.out.print(temp+" ");
            for(int k=1;k<=n;k++){
                if(map[temp][k]==1 && visit[k]==false){
                    que.offer(k);
                    visit[k] = true;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        visit = new boolean[n];

        //초기화
        for(int j=0; j<n+1; j++){
            Arrays.fill(map[j],0);
        }
        Arrays.fill(visit,false);

        // 간선의 개수
        for(int i=0; i<m;i++){
            String edge = br.readLine();
            StringTokenizer st1 = new StringTokenizer(edge, " ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(v);
        System.out.println();
        Arrays.fill(visit,false);
        bsf(v);
    }
}
