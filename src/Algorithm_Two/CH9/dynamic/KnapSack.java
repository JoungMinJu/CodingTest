package Algorithm_Two.CH9.dynamic;

public class KnapSack {
    // 용량이 W인 배장에 n개의 물건을 넣어서 얻을 수 있는 최대 가치를 계산
    static int knapSack(int W, int weight[], int value[], int n){
        int K[][] = new int[n+1][W+1];
        // W = 배낭의 용량, n = 물건의 개수

        // 배낭의 용량이 0일때 어떤 물건도 넣을 수 없다.
        for(int i=0; i<=n; i++) K[i][0] = 0;
        // 배낭에 어떤 물건도 넣지 않을 때
        for(int i=0; i<=W; i++) K[0][i] = 0;
        // K[i][j]를 행 순서대로 같은 행에서는 열 순서대로 계산한다.
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(weight[i-1] > j) // 물건 i의 무게가 임시 배낭의 무게를 초과하는 경우
                    K[i][j] = K[i-1][j];
                else // 물건 i를 넣은 경우와 넣지 않을 경ㅇ우를 고려
                    K[i][j] = Math.max(value[i-1] + K[i-1][j-weight[i-1]], K[i-1][j]);
            }
        }
        return K[n][W];
    }
    // 시작 메소드
    public static void main(String[] args) {
        int value[] = {70, 50, 120};
        int weight[] = {1, 1, 2};
        int C = 30; // 배낭의 용량
        int n = value.length;
        System.out.println("최대가치 = "+knapSack(C, weight, value, n));
    }
}
