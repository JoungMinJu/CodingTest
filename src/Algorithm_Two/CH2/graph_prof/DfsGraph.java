package Algorithm_Two.CH2.graph_prof;

public class DfsGraph {
    // 인접행렬을 이용한 DFS 구현
    // 그래프(인접행렬) 클래스

    private int nV; // 정점의 개수
    private int[][] dfsGraph;
    private boolean[] visitArr;

    //그래프 초기화
    public DfsGraph(int nV){
        this.nV = nV;
        // 그래프 초기화
        // put(int x, int y) 에서 입력되는 정점의 값은 0 이상의 정수이나
        // 배열의 index는 0 부터 시작이므로
        // ArrayIndexOutOfBoundsException 방지를 위해
        // 정점을 담는 인접행렬의 행과 열 size는 1을 더하여 초기화해줌
        this.dfsGraph = new int[this.nV+1][this.nV+1];
        this.visitArr = new boolean[this.nV+1];
    }

    // 그래프 리턴
    public int[][] getDfsGraph() {return this.dfsGraph;}

    // 그래프 추가(양방향)
    public void put(int x, int y){
        this.dfsGraph[x][y] = this.dfsGraph[y][x] =1;
    }

    // 그래프 추가 (단방향)
    public void putSingle(int x, int y){
        this.dfsGraph[x][y] =1;
    }

    // 그래프 출력 (인접행렬)
    public void printGraphToAdjArr(){
        for(int i=0;i<this.dfsGraph.length;i++){
            for(int j=0;j<this.dfsGraph[i].length;j++){
                System.out.print(" "+this.dfsGraph[i][j]);
            }
            System.out.println();
        }
    }

    // 정점 방문 여부 확인 배열 초기화
    public void clearVisitArr(){
        for(int i=0;i<this.visitArr.length;i++){
            this.visitArr[i] = false;
        }
    }

    // 그래프 탐색 (재귀호출)
    public void dfs(int vIdx){
        this.visitArr[vIdx] = true;
        System.out.print(vIdx+" ");

        // 정점의 개수만틈 탐색
        for(int i=1;i<=this.nV;i++){
            if(dfsGraph[vIdx][i]==1 && visitArr[i] ==false){
                dfs(i);
            }
        }
    }
}
