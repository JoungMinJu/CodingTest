package Algorithm_Two.CH10;

import java.util.Scanner;

public class FractionalKnapsack {
    // 물건 수
    int n;
    // 각 물건의 무게
    double[] weight;
    // 각 물건의 가치
    double[] value;
    // 배낭의 용량
    double W;
    // 단위 무게당 가치
    double[] unitValue;

    // 값 초기화
    public void inputData(){
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("물건들의 수를 입력하세요: ");
        n = sc.nextInt();
        weight = new double[n];
        value = new double[n];

        System.out.println("각 물건의 무게를 입력하세요: ");
        for(i=0;i<n;i++){
            weight[i] = sc.nextDouble();
        }
        System.out.println("각 물건의 가치를 입력하세요: ");
        for(i=0;i<n;i++){
            value[i] = sc.nextDouble();
        }
        System.out.println("배낭의 용량을 입력하세요: ");
        W = sc.nextDouble();
        sc.close();
    }

    // 배낭에 다음에 넣을 물건의 '지수' 찾기
    public int getNextItem(){
        double highest = 0;
        int index = -1;

        // 남아있는 물건들 중 단위 무게당 가치가 가장 높은 물건의 지수 찾기
        for(int i=0;i<value.length;i++){
            if(unitValue[i] > highest){
                highest = unitValue[i];
                index = i;
            }
        }
        return index;
    }

    // 배낭에 담긴 물건들, 물건들의 무게의 합과 물건들의 가치의 합을 계산한 후 출력하낟.
    public void fractionalKnapsack(){
        unitValue = new double[n];
        int i, item;

        // 각 물건의 단위 무게당 가치 계산
        for(i=0; i<n; i++){
            unitValue[i] = value[i] / weight[i];
        }
        System.out.println();

        // 배낭에 담긴 물건들의 무게의 합을 0으로 초기화
        double cW = 0;
        // 배낭에 담긴 물건들의 가치의 합을 0으로 초기화
        double cV = 0;

        // 단위 무게당 가치가 가장 큰 물건 찾기
        item = getNextItem();

        // 배낭에 채울 물건들이 남아있고 배낭이 채워지지 않는 동안 반복
        while((item!=-1) && (cW + weight[item] <= W)){
            // 배낭에 물건 item의 전부를 넣는다.
            cW += weight[item];
            cV += value[item];
            System.out.println("물건 "+(item+1)+"의 "+weight[item]+"을 배나에 넣는다.");
            unitValue[item] = 0; //넣을 물건들의 목록에서 제거
            item = getNextItem();
        }
    }

    public static void main(String[] args) {
        FractionalKnapsack fks = new FractionalKnapsack();

        fks.inputData();

        fks.fractionalKnapsack();
    }
}
