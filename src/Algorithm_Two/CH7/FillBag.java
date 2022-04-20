package Algorithm_Two.CH7;

public class FillBag {
    // 용량이 W인 배낭에 n개의 물건들을 넣엇 ㅓ어등ㄹ 수 있는 최대 가치를 계산한다.
    static int knapSack(int W, int weight[], int value[], int n){
        int i,j;
        int K[][] = new int[n+1][W+1];

        // 배낭의 용량이 0 일때 어떠 물건도 넣을 수 없다.
        for(i=0;i<=n;i++) K[i][0] = 0;
        // 배낭에 어떤 물건도 넣지 않을 때
        for(j=0;j<=W;j++) K[0][j] = 0;
        // K[i][j]를 행 순서대로, 같은 행에서는 열 순서대로 계산한다.
        for(i=1;i<=n;i++){
            for(j=1;j<=W;j++){
                if(weight[i-1]>j) K[i][j] = K[i-1][j];
                else K[i][j] = Math.max(value[i-1]+K[i-1][j-weight[i-1]],K[i-1][j]);
            }
        }
        return K[n][W];
    }

    public static void main(String[] args) {
        int value[] = {25,15,20,30};
        int weight[] = {3,1,2,4};

        int C = 7;

        int n= value.length;
        System.out.println("최대 가치="+knapSack(C, weight, value,n));
    }
}
