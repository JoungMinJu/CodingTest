package Algorithm_Two.CH12.practice;

import java.util.Iterator;
import java.util.LinkedList;

// 주어진 무방향 그래프의 정점 커버 찾은 후 출력한다.
// 연결 목록을 ㅏㅅ용하여 무방향 그프를 나타내는 클래스
public class App_Vet_Cover {
    private  int n; // 그래프 내 정점들의 수
    private LinkedList<Integer> adj[]; // 그래프의 연결을 나타낼 연결 목록들의 배열
    // 그러니까 링크드 리스트의 배열!!

    public App_Vet_Cover(int n) {
        this.n = n;
        adj = new LinkedList[n];
        for(int i=0;i<n;i++){ // 각 정점의 연결 목록들 초기화
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        App_Vet_Cover g = new App_Vet_Cover(6); // 정점 6개
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(4, 5);

        // 정점 커버를 구한다.
        LinkedList vc = g.vertexCover();
        Iterator<Integer> i = vc.iterator(); // 정점 터버 출력
        System.out.print("정점 커버 = { ");
        while (i.hasNext()){
            int v = i.next();
            System.out.print(v + " ");
        }
        System.out.println("}");
    }

    private LinkedList vertexCover() {
        // 그래프의 정점 커버 찾은 후 반환
        boolean visited[] = new boolean[n]; // 모든 정점들의 방문 여부 체크
        // 그래프의 정점 커버를 초기화
        LinkedList vertexCover = new LinkedList();
        // 모든 정점 방문 안함으로 초기화
        for(int i=0; i<n;i++){
            visited[i] = false;
        }

        // 각 정점에 인접한 정점들을 나타내는 연결 목록 내의 노드들을 차례대로 처리하기 위한 iterator 변수
        Iterator<Integer> i;
        // 모든 간선들을 한 번에 하나씩 고려
        for(int u=0; u<n; u++){
            // 그래프에 남아 있는 간선들 중 한 간선 (u,v)를 임의로 선택
            // 선택시 정점 u와 v는 방문안함이어야함.
            if(visited[u] == false){
                // 정점 u에 인접한 정점들 중 처리할 정점이 있는동안 반복
                i = adj[u].iterator();
                while(i.hasNext()){
                    int v = i.next(); // 다음 정점
                    if(visited[v] == false){
                        vertexCover.add(u);
                        vertexCover.add(v);
                        visited[u] = true;
                        visited[v] = true;
                        break;
                    }
                }
            }
        }
        return vertexCover;
    }

    private void addEdge(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);
    }
}
