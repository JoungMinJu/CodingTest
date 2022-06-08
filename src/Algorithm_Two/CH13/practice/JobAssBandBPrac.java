package Algorithm_Two.CH13.practice;

import java.util.PriorityQueue;

public class JobAssBandBPrac {
    public int N; //사람의 수
    public int[][] costMatrix; // 비용 행렬
    public PriorityQueue<Node2> q; // 상태 공간 트리를 대신하는 우선 순위 큐

    // 생성자
    public JobAssBandBPrac(int n, int[][] costMatrix) {
        q= new PriorityQueue<>();
        N = n;
        this.costMatrix = costMatrix;
    }

    public static void main(String[] args) {
        // 일 배정 비용 저장 배열
       int[][] costMatrix = {{5, 3, 6, 7}, {4, 6, 2, 5}, {6, 3, 5, 4}, {9, 6, 8, 5}};
       JobAssBandBPrac jabb = new JobAssBandBPrac(4, costMatrix);
       // 분기 한정을 이용하여 일들의 최소 배정 비용을 계싼한 후 출력
        System.out.println(jabb.findMinCost());
    }

    private int findMinCost() {
        boolean[] assigned = new boolean[N];
        // 상태 공간 트리의 루트 노드의 값들을 초기화하면서 만든다.
        for(int i=0;i<N;i++){
            assigned[i] =false;
        }
        Node2 root = new Node2(N, -1, -1, assigned, null);
        root.sumAssignedCost  =0;

        // 루트 노드의 한계값을 계산
        root.bound = computeBound(-1, -1, root.assigned);

        // 루트를 큨에 넣음
        q.add(root);

        // 큐가 비어있지 않은 한 한계값이 최소인 살아 있는 노드를 찾아서 그 노드의 자식 노드들을 큐에 추가한다.
        while(!q.isEmpty()){
            Node2 minNode= q.remove();
            int i = minNode.personNumber +1; // i는 일을 배정할 다음 사람을 나타낸다.
            // 모든 사람에게 일이 배정되면 배정 결과를 출력하고 최소 배정 비용을 반환
            if(i==N){
                printAssignment(minNode);
                return minNode.sumAssignedCost;
            }
            // 사람 i에 배정 가능한 일을 배정하는 모든 자식 노드를 만들어 큐에 추가한다.
            for(int j=0;j<N;j++){
                if(!minNode.assigned[j]){
                    // 일 j가 배정되진 않았는지 확인하기 생성자통해서 계속 전해져 내려오는 assigned[] 배열
                    // 사람 i에 일 j를 배정하면서 자식 노드 만들기
                    Node2 child = new Node2(N, i, j, minNode.assigned, minNode); // 맨마지막은 parent 지정하는 것.
                    // 배정된 일들의 총 비용에 새로 배정된 일의 비용을 더한다.
                    child.sumAssignedCost = minNode.sumAssignedCost + costMatrix[i][j];
                    // 새 자식 노드의 한계값을 게산
                    child.bound = child.sumAssignedCost + computeBound(i, j, child.assigned);
                    // 새 자식 노드를 큐에 추가
                    q. add(child);
                }
            }
        }

        return 0;
    }

    private void printAssignment(Node2 minNode) {
        if(minNode  == null) return;
        printAssignment(minNode.parent);
        if(minNode.personNumber!=-1){
            System.out.println("사람 " + (minNode.personNumber + 1)
                    + "을 일 " + (minNode.jobNumber + 1) + "에 배정한다.");
        }
    }

    private int computeBound(int x, int y, boolean[] assigned) {
        // 사람 x를 일 y에 배정한 후 일들이 배정되지 않은 모든 사람들에게 남은 일들을 배정하는데 드는 총 비용의 하한을 계산
        int minCost; // 최소 비용
        int minIndex; // 최소 비용 일의 지수
        int bound = 0; // 총 비용의 하한

        // 일이 배정되지 않은 각 사람에게 일을 배정하는 최소 비용을 찾아서 하한에 더한다.
        for(int i=x+1;i<N;i++){
            minCost = Integer.MAX_VALUE;
            minIndex = -1;
            // 사람 i에 일을 배정하는 최소 비요응ㄹ 차즌다.
            for(int j=0;j<N;j++){
                if(!assigned[j] && j!=y && costMatrix[i][j] < minCost){
                    // 아직 일 배정이 되지 않았고, 부모의 일이 아니고, 개중에 비용 젤 작은 애 저장
                    minIndex = j;
                    minCost = costMatrix[i][j];
                }
            }
            bound = bound + minCost; // 다른 사람에게 배정 가능한 일의 최소 비용 더하기
        }
        return bound; // 앞의 내용은 메인 계산문에서 이미 더해주는 중
    }



}
