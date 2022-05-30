package Algorithm_Two.CH10;// 프로그램 7-4: Dijkstra의 알고리즘
// 출발 정점으로부터 모든 다른 정점까지 가는 최단 경로를 찾는다

public class SingleSourceShortestPath
{
    final static int INF = 9999; // 무한대 대신 사용

    // 최단 경로 트리에 아직 포함되지 않는 정점들의 집합에서 출발 정점으로부터 최소 거리에 있는 정점을 찾는다
    // d = 출발정점으로부터 i 정점까지의 경로
    // 최단경로에 포함되었는지 판단하는 T
    static int findMinDistance(int d[], boolean T[], int n) {
        // min 값을 가장 큰 정수로 초기화한다
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < n; v++)
            if (T[v] == false && d[v] <= min) {
                min = d[v];
                min_index = v;
            }
        return min_index;
    }

    // 모든 정점의 출발 정점으로부터 최단 경로를 길이와 함께 출력한다
    static void printShortestPath(int d[], int p[], int n) {
        String sp;	// 최단 경로
        int v;

        System.out.println("정점\t거리\t최단 경로");

        // 각 정점의 출발 정점으로부터  최단 경로를 최단 경로 트리에서
        // 그 정점의 부모 노드를 거꾸로 따라가면서 찾아서 출력한다
        for (int i = 0; i < n; i++) {
            v = i;
            sp = v + "";
            while (p[v] != -1) {
                sp = p[v] + " - " + sp;
                v = p[v];
            }
            System.out.println(i + "\t" + d[i] + "\t" + sp);
        }
    }

    // 출발 정점 최단 경로를 찾는 Dijkstra 알고리즘
    // 주어진 그래프는 인접 행렬로 나타낸다
    static void dijkstra(int W[][], int src, int n) {
        int d[] = new int[n]; // d[i]는 출발 정점으로부터 정점 i까지 최단 거리를 저장한다

        // T[i]는  정점 i가 최단 경로 트리에 포함된다면 true이다
        boolean T[] = new boolean[n];

        // p[i]는 최단 경로 트리에서 정점 i의 부모 노드를 저장한다
        int p[] = new int[n];

        // 모든 정점의 출발 정점으로부터 최단 거리를  가장 큰 정수로 초기화하고
        // 모든 정점이  최단 경로 트리에 포함되지 않게 하고
        // 모든 정점의  최단 경로 트리에서 부모 노드를 -1로 초기화한다
        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE;
            T[i] = false;
            p[i] = -1;
        }

        // 출발 정점의 최단 거리를  0으로 한다.
        d[src] = 0;

        // 모든 정점의 출발 정점으로부터 최단 경로를 찾는다
        for (int count = 0; count < n - 1; count++) {
            // 최단 경로 트리에 아직 포함되지 않는 정점들의 집합에서  출발 정점으로부터 최소 거리에 있는 정점을
            // 선택한다. 첫 반복시 정점 u는 출발 정점이다.
            int u = findMinDistance(d, T, n);

            // 선택된 정점을 최단 경로 트리에 포함시킨다
            T[u] = true;

            // 선택된 정점의 인접 정점들의 출발 정점으로부터 최단 거리를 갱신한다
            for (int v = 0; v < n; v++)
                // 정점 v가 최단 경로 트리에 포함되지 않고 정점 u와 정점 v사이에 간선이 있고
                // 출발 정점부터 u를 거쳐 v까지 가는 경로의 거리가 d[v]의 현재 값보다 작다면
                // d[v]를 갱신한다
                if (!T[v] && W[u][v] != 0 &&
                        d[u] != Integer.MAX_VALUE &&
                        d[u] + W[u][v] < d[v]) {
                    d[v] = d[u] + W[u][v];
                    p[v] = u;
                }
        }

        // 최단 경로를 길이와 함께 출력한다
        printShortestPath(d, p, n);
    }

    // 시작 메소드 main
    public static void main (String[] args) {
        // 각 정점은 0이상의 정수로 표현한다
        // 출발 정점은 0이다
        // W[][]: 주어진 그래프의 인접 행렬 표현
        int W[][] = new int[][] {{0, 2, INF, INF, 7},
                {2, 0, 5, INF, 1},
                {INF, 5, 0, 4, 3},
                {INF, INF, 4, 0, 6},
                {7, 1, 3, 6, 0},
        };

        // 출발 정점으로부터 모든 다른 정점까지 가는 최단 경로를 찾아 출력한다
        dijkstra(W, 0, 5);
    }
}
