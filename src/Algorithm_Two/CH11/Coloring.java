package Algorithm_Two.CH11;

// 프로그램 9-3: 무방향그래프에서 m개의 색만을 사용하여 인접한 정점들이 다른 색이 되도록
// 모든 정점을 색칠하는 모든 방법을 출력한다.
public class Coloring {
    int N;  // 그래프의 정점들의 수
    int m;	// 색들의 수
    int[] vcolor; // 정점들에 칠해진 색들의 배열

    public static void main(String[] args) {
        Coloring col = new Coloring();

        col.vcolor = new int[10];

        // 그래프는 인접 행렬로 나타낸다
        int graph1[][] = {{0, 1, 0, 1, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1},
                {1, 0, 0, 1, 0}
        };

        col.N = 5;
        col.m = 3;

        // 무방향그래프의  정점들을 색칠하는 모든 방법을 출력한다
        col.m_coloring(graph1, 0);
    }

    // 무방향그래프 G의 정점들을 색칠하는 모든 방법을 출력한다
    public void m_coloring(int G[][], int i)
    {
        int color;

        if (valid(G, i))
            if (i == N) { // 정점들에 칠해진 색들의 배열 vcolor[1..N]을 출력한다
                System.out.print("색칠 하기: ");
                for (i = 1; i <= N; i++)
                    System.out.print("정점 " + i + "의 색 = " + vcolor[i] + " ");
                System.out.println();
                return;
            }
            else { // 다음 정점에 모든 색을 시도해 본다
                for (color = 1; color <= m ; color++) {
                    vcolor[i + 1] = color ;
                    m_coloring(G, i + 1) ;
                }
            }
    }

    // 정점 i에 칠해진 색이  유효한지 확인한다
    public boolean valid(int G[][], int i) {
        int j = 1;

        while (j < i) {
            // 정점 i의 색이 인접한 정점(들)의 색과 같은지를 확인한다
            if (G[i-1][j-1] == 1 && vcolor[i] == vcolor[j] )
                return false;
            j++;
        }

        return true;
    }
}