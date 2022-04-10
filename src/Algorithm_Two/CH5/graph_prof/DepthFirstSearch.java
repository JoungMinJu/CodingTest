package Algorithm_Two.CH5.graph_prof;

import java.util.List;

// 주어진 무방향 그래프를 깊이 우선 탐색으로 순회한다.
public class DepthFirstSearch {
    // 정점 v에 연결된 방문하지 않은 정점들을 깊이 우선 탐색을 이용하여
    // 재귀적으로 방문한다.
    public static void dfs(Node v){
        // 정점 v에 대응된 데이터를 출력하낟.
        System.out.print(v.info+" ");
        // 정점 v를 방문함으로 표기하낟.
        v.visited=true;
        // 정점 v에 인접한 정점들의 연결 목록을 끄집어 낸다.
        List<Node> neighbors = v.getNeighbors();
        // 정점 v에 인접한 망문하지 않은 모든 정점들에 대해 깊이 우선 탐색을 수행한다.
        for(int i=0;i<neighbors.size();i++){
            Node w = neighbors.get(i);
            if(w!=null && !w.visited) dfs(w);
        }
    }

    public static void main(String[] args) {
        // 주어진 무방향 그래프를 연결 목록으로 표현한다.
        // 정점들을 표현한다..
        Node[] node = new Node[6];
        for(int i=0;i<6;i++){
            node[i] = new Node(i+1);
            System.out.println(node[i]);
        }
        // 간선들을 표현한다
        node[0].addNeighbors(node[1]);
        node[0].addNeighbors(node[2]);
        node[0].addNeighbors(node[4]);
        node[1].addNeighbors(node[0]);
        node[1].addNeighbors(node[2]);
        node[2].addNeighbors(node[0]);
        node[2].addNeighbors(node[1]);
        node[2].addNeighbors(node[3]);
        node[2].addNeighbors(node[4]);
        node[3].addNeighbors(node[2]);
        node[3].addNeighbors(node[5]);
        node[4].addNeighbors(node[0]);
        node[4].addNeighbors(node[2]);
        node[5].addNeighbors(node[2]);
        node[5].addNeighbors(node[3]);

        // 주어진 무방향 그래프르 ㄹ깊이 우선 탐색으로 순회한다.
        System.out.println("재귀를 사용한 깊이 우선 탐색 실행결과");
        dfs(node[0]);
    }
}
