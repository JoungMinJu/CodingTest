package Algorithm_Two.CH9;

import java.util.Arrays;
import java.util.Comparator;

public class Test_Kruscal {

    // 합치기
    // index 작은 애 쪽으로 합칠게용
    public static void union(int[] parent, int a, int b) {
        int a_parent = find(parent, a);
        int b_parent = find(parent, b);

        if(a_parent < b_parent) parent[b_parent] = a_parent;
        else parent[a_parent] = b_parent;
    }

    // 부모 찾기
    public static int find(int[] parent, int i){
        if(parent[i] == i) return i;
        return find(parent, parent[i]);
    }

    public static void main(String[] args) {
        // (src, dst, weight)
        int [][]graph = {{1, 2, 6},
                        {1, 3, 3},
                        {1, 4, 1},
                        {2, 5, 4},
                        {3, 4, 2},
                        {3, 5, 5},
                        {4, 5, 7}};
        // 정점 5개지만 1부터 시작하기 위해서 +1
        int parent[] = new int[6];
        // 최소 신장 트리의 가중치 총! 합
        int total = 0;

        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }

        // 가중치 기준으로 오름차순 정렬
        Arrays.sort(graph, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for(int i=0;i<graph.length;i++){
            if(find(parent, graph[i][0]) != find(parent, graph[i][1])){
                // 출발지와 도착지가 사이클이 아니면
                total += graph[i][2]; // 가중치 더하고
                union(parent, graph[i][0], graph[i][1]); // 합침.
            }
        }
        System.out.println("최소 비용 신장 트리 가중치의 합은 "+total);
    }

}
