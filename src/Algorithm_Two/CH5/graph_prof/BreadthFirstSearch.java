package Algorithm_Two.CH5.graph_prof;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    private Queue<Node> queue; // 방문할 정점들을 저장하는 큐
    public BreadthFirstSearch(){
        queue = new LinkedList<Node>();
    }

    public void bfs(Node v){
        v.visited = true;
        // v를 큐에 ㅊ가
        queue.add(v);
        while(!queue.isEmpty()){
            // 큐의 맨 앞에 있는 정점을 끄집어내어 element에 저장
            Node element = queue.remove();
            System.out.print(element.info+" ");

            // element에 인접한 정점들의 연결 목록을 끄집어 낸다.
            List<Node> neighbors = element.getNeighbors();

            // element에 인접한 방문하지 않은 모든 정점들에 대해 너비 우선 탐색을 수행
            for(int i=0;i<neighbors.size();i++){
                Node w= neighbors.get(i); // w는 element에 인접한 정점
                if(w!=null && !w.visited){
                    w.visited=true;
                    queue.add(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 주어진 무방향 그래프를 연결 목록으로 표현한다.
        // 정점들을 표현한다
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        // 간선들을 표현한다
        node1.addNeighbors(node2);
        node1.addNeighbors(node3);
        node1.addNeighbors(node5);
        node2.addNeighbors(node1);
        node2.addNeighbors(node3);
        node3.addNeighbors(node1);
        node3.addNeighbors(node2);
        node3.addNeighbors(node4);
        node3.addNeighbors(node5);
        node4.addNeighbors(node3);
        node4.addNeighbors(node6);
        node5.addNeighbors(node1);
        node5.addNeighbors(node3);
        node6.addNeighbors(node3);
        node6.addNeighbors(node4);


        BreadthFirstSearch bfsExample = new BreadthFirstSearch();

        // 주어진 무 방향 그래프를 너비 우선 탐색으로 순회한다.
        System.out.println("너비 우선 탐색 실행 결과");
        bfsExample.bfs(node1);
    }
}
