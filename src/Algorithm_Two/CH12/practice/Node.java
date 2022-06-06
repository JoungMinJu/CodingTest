package Algorithm_Two.CH12.practice;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int info; // 정점에 대응된 데이터
    boolean visited; // 방문 여부
    List<Node> neighbors; // 정점에 인접한 정점들의 연결 목록

    public Node(int info) {
        this.info = info;
        this.visited = false;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbors(Node neighborsNode){
        this.neighbors.add(neighborsNode);
    }

    // 정점에 인접한 정점드의 연결 목록을 반환
    public List<Node> getNeighbors(){
        return neighbors;
    }
    // 정점에 인접한 정점들의 연결 목록을 ㅜ정지 ㄴ연결 목록으로 변경한다.
    public void setNeighbors(List<Node> neighbors){
        this.neighbors = neighbors;
    }
    public String toString(){
        return ""+info;
    }
}
