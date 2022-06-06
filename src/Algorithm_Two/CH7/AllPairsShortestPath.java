package Algorithm_Two.CH7;

public class AllPairsShortestPath {
    // 모든 쌍 최단 경로 찾기 프로이드 알고리즘
    final static int INF = 9999;

    void findAllPairShortestPath(float[][] graph, int n){
        float dist[][] = new float[n][n];
        int i,j,k;

        // 행렬 D를 가중치 행렬 graph로 초기화한다.
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                dist[i][j] = graph[i][j];
            }}
        // 모든 정점들은 한 번에 하나씩 중간 정점들의 집합에 추가한다.
        // 반복 전에는 최단 경로들은 {0,1,2...k-1}에 있는정점들만을 경유한다.
        // 반복 후에는 정점 K가 중간 정점들의 집합에 추가되고
        // 최단 경로들은 {0, 1, 2,...k} 에 있는 정점(들)만을 경유한다.
        for(k=0;k<n;k++){
            // 모든 정점들을 한 번에 하나씩 시작 정점으로 선택한다.
            for(i=0;i<n;i++){
                // 모든 정점들을 위에서 선택된 시작 종점에 대한 목적지 정점으로 선택한다.
                for(j=0;j<n;j++){
                    // 정점 k가 정점 i에서 정점 j로 가는 최다 ㄴ경로상에 있으면 dist[i][j] 값을 그 경로의 거리로 갱신한다.
                    dist[i][j] = Math.min(dist[i][j],
                                            dist[i][k]+dist[k][j] );
                }
            }
        }
        printSolution(dist, n);
    }
    // 최단 거리 행렬 dist[0..n-1, 0..n-1]을 출력한다.
    void printSolution(float dist[][], int n){
        int i,j;
        System.out.println("모든 두 정점들 쌍 사이의 최단 거리 행렬");
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(dist[i][j] == INF) System.out.print("INF: ");
                else System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        int[][] graph = {{0, INF, 2, INF},
//                        {1, 0, INF, INF},
//                        {INF, 8, 0, 3},
//                        {6, 4, INF, 0}};
//
//        int n = 4;
//
//        AllPairsShortestPath a = new AllPairsShortestPath();
//        // 최단 거리 행렬을 계산한 후 출력한다.
//        a.findAllPairShortestPath(graph, n);
//    }

    public static void main(String[] args) {
        float[][] graph = {{0,1,INF, INF, 5},
                {INF,0, (float) 1.1,INF,INF},
                {2, INF,0, INF, 2},
                {3, 3, (float)1.4, 0, INF},
                {INF, (float)1.2, INF, (float)1.3, 0}};
        int n =5 ;
        AllPairsShortestPath a = new AllPairsShortestPath();
        a.findAllPairShortestPath(graph,n);
    }
}
