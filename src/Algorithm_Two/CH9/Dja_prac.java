package Algorithm_Two.CH9;

public class Dja_prac {
    final static int INF = 9999;

    public static void main(String[] args) {
        // 주어지 ㄴ그ㅐㄹ프의 인접 행렬 표현
        int W[][] = new int[][]{{0, 2, INF, INF, 7},
                {2, 0, 5, INF, 1},
                {INF, 5, 0, 4, 3},
                {INF, INF, 4, 0, 6},
                {7, 1, 3, 6, 0}};
        // 출발 정점으로부터 모든 다른 정점까지 가는 최단 경로 찾아서 출력
        dijkstra(W, 0, 5); // (가중치 행렬, 출발 지점, 정점 개수)
    }

    // 출발 정점 최단 경로를 찾는 다익스트라 알고리즘
    // 주어진 그래프는 인접 행렬로 나타냄
    static void dijkstra(int W[][], int src, int n){
        int d[] = new int[n]; // d[i]는 출바 ㄹ정점으로부터 정점 i까지 최단 거리 저장
        boolean T[] = new boolean[n]; //T는 정점 i가 최단 경로 트리에 포함된다면 true
        int p[] = new int[n]; // p는 최단 경로 트리에서 정점 i의 부모 노드를 저장한다.

        // 초기화
        for(int i=0; i<n;i++){
            d[i] = Integer.MAX_VALUE;
            T[i] = false;
            p[i] = -1;
        }

        // 출발 정점 최단거리 0으로 바꿔줌
        d[src] = 0;

        // 모든 정점의 출발 정점으로부터 최단 경로 찾기
        for(int count = 0; count < n-1; count ++){
            // 최단 경로 트리에 아직 포함되지 않은 정점들의 집합에서 출발 정점으롭퉈 최소 거리에 있는 정점을 선택
            int u = findMinDistance(d,T,n); // 최단 거리배열 , 최단 경로 트리에 포함되는지 여부, 정점 개수
            // 선택된 정점 최단 경로 트리에 포함
            T[u] = true;
            // 선택된 정점의 인접 정점들의 출발 정점으로부터 최단 거리를 갱신
            for(int v=0; v<n;v++){
                if(!T[v] && W[u][v] !=0 && d[u] != Integer.MAX_VALUE && d[u] + W[u][v] <d[v]){
                    d[v] = d[u] + W[u][v];
                    p[v] = u; // 출력을 위한 부분
                }
            }
        }
        // 최단 경로를 길이와 함께 출력한다.
        printShortestPath(d, p, n);
    }
    static int findMinDistance(int d[], boolean T[], int  n){
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int v=0; v<n; v++){
            if(!T[v] && d[v] <= min) {
                min = d[v];
                min_index = v;
            }
        }
        return min_index;
    }
    // 모든 정점의 출발 정점으로부터 최단 경로를 길이와 함께 출력한다.
    static void printShortestPath(int d[], int p[], int n){
        String sp; // 최단 경로
        int v;
        System.out.println("정점\t거리\t최단 경로");
        // 각 정점의 src로부터 최단 경로를 최단 경로 트리에서 그 정점의 부모 노드를 거꾸로 따라가면서 찾아서 출력한다.
        for(int i=0; i<n;i++){
            v = i;
            sp = v+"";
            while(p[v] != -1){
                sp = p[v] + "-" + sp;
                v = p[v];
            }
            System.out.println(i + "\t" + d[i] + "\t" + sp);
        }
    }
}
