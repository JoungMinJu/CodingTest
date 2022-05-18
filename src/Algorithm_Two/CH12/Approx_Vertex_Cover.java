package Algorithm_Two.CH12;

import java.util.Iterator;
import java.util.LinkedList;

// 주어진 무방향 그래프의 정점 커버를 찾은 후 출력한다.
// 연결 목록을 사용하여 무방향 그래프를 나타내는 클래스
public class Approx_Vertex_Cover {
    private int n; // 그래프 내의 정점들의수
    private LinkedList<Integer> adj[] ; // 그래프 나타내는 연결 목록들의 배열

    public Approx_Vertex_Cover(int n) {
        this.n = n;
        adj = new LinkedList[n]; // n개의 연결 목록 객체들 생성
        for(int i=0;i<n;i++){ // 각 정점의 연결 목록들 비어 있게 하기
            adj[i]  = new LinkedList<>();
        }
    }

    // 그래프에 간선을 추가
    public void addEdge(int a, int b){
        adj[a].add(b); // 정점 a의 연결 목록에 정점 b를 추가
        adj[b].add(a);
    }

    // 그래프의 정점 커버 찾은 후 반환
    public LinkedList vertexCover(){
        boolean visited[] = new boolean[n]; // 모든 정점들의 방문 여부 체크
        // 그래프의 정점 커버를 비어 있는 연결 목록으로 초기화
        LinkedList vertexCover = new LinkedList();
        // 모든 정점 방문안함으로 초기화
        for(int i=0;i<n;i++){
            visited[i] = false;
        }
        // 각 정점에 인접한 정점들을 나타내는 연결 목록 내의 노드들을 차례대로 처리하기 위한 iterator 변수
        Iterator<Integer> i;
        // 모든 간선들을 한 번에 하나씩 고려
        for(int u = 0; u<n; u++){
            //그래프에 남아 있는 간선들 중 한 간선 (u,v)를 임의로 선택
            // 선택시 정점u와 v는 모드 '방문안함'ㅇ어야함
            if(visited[u] = false){
                // 정점 u에 인접한 정점들 중 처리할 정점이 남아있는 동안 반복
                i = adj[u].iterator();
                while(i.hasNext()){
                    int v = i.next(); // 다음 정점
                    // 정점u와v는 모두 방문안함이면 간선 (u,v)꺼낸다.
                    if(visited[v] =false){
                        vertexCover.add(u); // 정점u,v를 각각 정접 커버에 추가
                        vertexCover.add(v);
                        visited[u] = true; // 방문함으로 표시
                        visited[v] = true;
                        break;
                    }
                }
            }
        }
        return vertexCover;
    }

     // 시작 메소드
     public static void main(String[] args) {
         // 주어진 그래프를 생성한다
         Approx_Vertex_Cover g = new Approx_Vertex_Cover(6);
         g.addEdge(0, 1);
         g.addEdge(1, 2);
         g.addEdge(1, 3);
         g.addEdge(1, 4);
         g.addEdge(2, 4);
         g.addEdge(2, 5);
         g.addEdge(4, 5);
         LinkedList vc = g.vertexCover(); // 정점 커버를 구한다
         Iterator<Integer> i = vc.iterator(); // 정점 커버를 출력한다
         System.out.print("정점 커버 = { ");
         while (i.hasNext()){
             int v = i.next();
             System.out.print(v + " ");
         }
         System.out.println("}");
     }
}
