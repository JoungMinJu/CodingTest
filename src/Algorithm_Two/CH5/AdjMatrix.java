package Algorithm_Two.CH5;

import java.util.Scanner;

public class AdjMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //vertex 개수
        int vCnt = Integer.parseInt(sc.next());
        // edge 개수
        int eCnt = Integer.parseInt(sc.next());

        // 리스트 인덱스'1'로 하기에 크기를 한 개 늘려서 할당
        int[][] adMatrix = new int[vCnt+1][eCnt+1];

        for(int i=0;i<vCnt;i++){
            int v1= sc.nextInt();
            int v2= sc.nextInt();
            adMatrix[v1][v2]=1;
            adMatrix[v2][v2]=1;
        }

        for(int i=1;i<=vCnt;i++){
            for(int j=1;j<=vCnt;j++){
                System.out.print(adMatrix[j][i]+" ");
            }
            System.out.println();
        }
    }
}
