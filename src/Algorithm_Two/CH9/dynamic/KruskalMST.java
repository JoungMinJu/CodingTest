package Algorithm_Two.CH9.dynamic;

import java.util.*;

public class KruskalMST {
    // 그래프의 한 간선을 나타내는 클래스
    private class Edge implements Comparable<Edge> {
        int src, dest, weight;

        // 간선들을 가중치에 기초하여 정렬하기 위해 사용되는 비교 메소드
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };

    // union-find를 위한 서로소 부분집합(disjoint subset)을 나타내는 클래스
    private class subset {
        int parent;	// 대표
        int rank;	// 순위
    };

    int V;	// 정점들의 수
    int E; 	// 간선들의 수
    Edge edge_lst[]; // 모든 간선들의 배열

    // V 개의 정점들과 E 개의 간선들을 가진 그래프를 만든다
    KruskalMST(int v, int e) {
        V = v;
        E = e;
        edge_lst = new Edge[E];

        for (int i = 0; i < E; ++i)
            edge_lst[i] = new Edge();
    }

    // 결로 압축 기법을 사용하여 요소 i가 속한 부분집합을 찾는 메소드
    int find(subset subsets[], int i) {
        // 찾은 뿌리 노드를 요소 i의 부모로 만든다
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // x가 속한 집합과 y가 속한 집합의 합집합을 순위를 이용하여 구하는 메소드
    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // 순위가 낮은 트리를 순위가 높은 트리의 뿌리 노드의 바로 아래에 놓는다
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

            // 두 트리의 순위가 같다면 한 트리를 뿌리 노드로 만들고 그 트리의 순위를 1만큼 증가시킨다
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // 크루스칼 알고리즘을 이용하여 최소 비용 신장 트리를 찾는 메소드
    void KruskalMST() {
        // 찾은 최소 비용 신장 트리에 포함되는 간선들의 배열
        Edge result[] = new Edge[V];
        int e = 0;  // 최소 비용 신장 트리에 포함되는 간선들의 배열 지수
        int i = 0;  // 정렬된 간선들의 배열의 지수를 저장하는 변수

        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        // 단계 1: 모든 간선들을 가중치 순서로 오름차순으로 정렬한다
        Arrays.sort(edge_lst);
        for(i=0;i<E;++i) {
            System.out.println(edge_lst[i].weight);
        }
        // V 개의 부분집합들을 위한 배열을 만든다
        subset subsets[] = new subset[V];

        // 각 부분집합을 초기화한다
        for(i = 0; i < V; ++i)
            subsets[i] = new subset();

        // 한 개의 요소를 갖는 V 개의 부분집합들을 생성한다
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;  // 다음 간선을 선택하기 위해 사용되는 지수

        // 트리에 추가된 간선들의 수가 (V - 1)이 될 때까지 반복한다
        while (e < V - 1) {
            // 가중치가 가장 작은 간선을 선택한다.
            // 다음 반복을 위해 지수를 1만큼 증가시킨다
            Edge next_edge = new Edge();
            next_edge = edge_lst[i];
            i++;

            // 선택된 간선의 정점들이 속한 부분집합을 찾는다
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // 찾은 부분집합들이 서로 다르다면 간선을 트리에 추가하고
            // 다음에 추가할 간선을 위해 지수를 1만큼 증가시킨다.
            // 찾은 부분집합들이 같다면 선택된 간선을 버린다
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }

        // 최소 비용 신장 트리에 포함된 간선들을 가중치와 같이 출력한다
        System.out.println("\n찾은 최소 비용 신장 트리\n");
        System.out.println("간선\t가중치");

        for (i = 0; i < e; ++i)
            System.out.println("(" + result[i].src + ", " +
                    result[i].dest + ")\t  " + result[i].weight);
    }

    // main 메소드
    public static void main (String[] args) {
        int V = 5;  // 그래프내의 정점들의 수
        int E = 7;  // 그래프내의 간선들의 수

        Scanner scan = new Scanner(System.in);

        // 주어진 연결된 가중치가 있는 무방향 그래프를 만든다
        KruskalMST graph = new KruskalMST(V, E);

        // 그래프내의 간선의 두 정점들과 가중치를 키보드릉 통해 입력받는다
        System.out.println("간선의 두 정점들과 가중치를 차례대로 입력하세요");

        for (int i = 0;  i < E; i++) {
            graph.edge_lst[i].src = scan.nextInt();
            graph.edge_lst[i].dest = scan.nextInt();
            graph.edge_lst[i].weight = scan.nextInt();
        }

        // 크루스칼 알고리즘을 이용하여 최소 비용 신장 트리를 찾는다
        graph.KruskalMST();
    }
}
/**
 * 0 1 2
 * 0 4 4
 * 1 2 8
 * 1 4 4
 * 2 3 7
 * 2 4 6
 * 3 4 3
 *
 * output
 *
 * 찾은 최소 비용 신장 트리
 *
 * 간선	가중치
 * (0, 1)	  2
 * (3, 4)	  3
 * (0, 4)	  4
 * (2, 4)	  6
 */
