package Algorithm_Two.CH13;

public class Node2 implements Comparable<Node2>{
    int personNumber; // 사람의 번호
    int jobNumber; // 일의 번호
    int bound; // 한계값
    int sumAssignedCost; // 현재까지 배정된 일들의 비용들의 합
    Node2 parent;
    boolean[] assigned =new boolean[10]; // 사람들의 일 배정 여부 저장 배열

    // 상태 공간 트리의 노드를 사람 x에 일 y를 배정하면서 만든다.
    public Node2(int N, int x, int y, boolean[] assigned, Node2 parent){
        this.personNumber = x;
        this.jobNumber = y;
        this.parent = parent;

        // 부모 노드의 일 배정 결과를 저장
        for(int i=0;i<N;i++){
            this.assigned[i] = assigned[i];
        }
        // 루트 노드가 아니면 일 y를 배정한다.
        if(y>=0) this.assigned[y] = true;
    }

    @Override
    public int compareTo(Node2 o) {
        if(bound > o.bound){
            return 1;
        } else if(bound<o.bound){
            return -1;
        }else{
            return 0;
        }
    }
}
