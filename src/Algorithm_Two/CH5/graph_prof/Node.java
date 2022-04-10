package Algorithm_Two.CH5.graph_prof;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int info; // 정점에 대응된 데이터
    boolean visited; // 방문 여부
    List<Node> neighbors; // 정점에 인접한 정점들의 연결 목록

    // Node 객체를 생성한다.
    public Node(int info){
        this.info = info;
        this.visited = false;
        this.neighbors = new ArrayList<>();
    }

    // 정점에 인접한 정점들의 연결 목록에 새 정점을 추가한다.
    public void addNeighbors(Node neighborsNode){
        this.neighbors.add(neighborsNode);
    }
    // 정점에 인접한 정점들의 연결 목록을 반환한다.
    public List<Node> getNeighbors(){
        return neighbors;
    }
    // 정점에 인접한 정점들의 연결 목록을 주어진 연결 목록으로 변경한다.
    public void setNeighbors(List<Node> neighbors){
        this.neighbors = neighbors;
    }
    // 정점에 대응된 데이터를 반환한다
    public String toString(){
        return "" + info;
    }
}
