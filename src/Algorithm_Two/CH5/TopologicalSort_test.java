package Algorithm_Two.CH5;

import Algorithm_Two.CH5.graph_prof.Node;

import java.util.List;
import java.util.Stack;

public class TopologicalSort_test {
    Stack<Node> stack; // 정점들을 방문한 역순으로 저장하는 스택
    // 비어 있는 스택을 생성한다.
    public TopologicalSort_test(){ stack = new Stack<>();}
    // 위상 정렬을 v에서 시작한다.
    public void topologicalSort(Node v){
        // 정점 v에 인접한 정점들의 연결 목록을 끄집어 낸다.
        List<Node> neighbors = v.getNeighbors();
        // 정점 v에 인접한 모든 정점에 대해 깊이 우선 탐색을 한다.
        for(int i=0;i<neighbors.size();i++){
            Node w = neighbors.get(i);
            if(w!=null&&!w.visited){
                w.visited=true;
                topologicalSort(w);
            }
        }
        // v를 스택에 밀어 넣는다.
        stack.push(v);
    }

    public static void main(String[] args) {
        TopologicalSort_test topologicalSort = new TopologicalSort_test();
        // 주어진 방향 그래프를 연결 목록으로 표현한다.
        // 그래프에 깊이 우선 탐색을 시작하는 정점 0을 추가한다.
        Node node0 = new Node(0);

        // 그래프에 있는 정점들을 생성한다.
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);


        // 간선들을 추가한다.
        // 정점 0에서 진입 간선이 없는 정점 1로 가는 간선을 추가한다.
        node0.addNeighbors(node1);

        // 그래프의 간선들 나타내기
        node1.addNeighbors(node2);
        node1.addNeighbors(node6);
        node2.addNeighbors(node6);
        node2.addNeighbors(node5);
        node2.addNeighbors(node3);
        node3.addNeighbors(node6);
        node3.addNeighbors(node5);
        node3.addNeighbors(node4);
        node5.addNeighbors(node4);
        node6.addNeighbors(node5);

        System.out.println("위상 정렬 순서:");

        // 시작 정점 node0을 방문함으로 표시
        node0.visited = true;

        // node0에서 위상 정렬을 시작
        topologicalSort.topologicalSort(node0);
        // 스택을 가져온다
        Stack<Node> resultStack = topologicalSort.stack;
        // 스택에 있는 노드들을 출력한다.
        while(resultStack.empty()==false){
            System.out.print(resultStack.pop()+" ");
        }
    }
}
