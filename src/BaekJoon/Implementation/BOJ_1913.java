package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// https://loosie.tistory.com/538 참조
// https://seeminglyjs.tistory.com/187 참조

public class BOJ_1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size= Integer.parseInt(br.readLine());
        int tsize = size ; // 크기 임시 저장할 변수
        int n = Integer.parseInt(br.readLine());
        int max = size*size;

        int[][] arr = new int[size][size];

        // 열 위치 변수
        int j = 0;
        // 행위치 변수
        int i = -1;
        // 행열에 더해 줄 변수
        int count  = 1;

        while(true){
            for(int t=1; t<=size;t++){
                i += count;
                arr[i][j] = max;
                max--;
                // 열 고정. 행 변화
            }
            // 행부터 하나씩 작아지면서 숫자를 넣어줌
            size --;
            if(size<=0) break;
            for(int t = 1; t<=size;t++){
                j+= count;
                arr[i][j]  = max;
                max --;
            }
            // 한 루프 다 돌면 행열이 감소하거나 증가하는 순서가 바뀜
            // 그래서 더해주는 값을 1 또는 -1로 변경해주어야한다.
            count *= -1;
        }
        int [] ans = new int[2];
        for(int x = 0;x<tsize;x++){
            for(int y=0;y<tsize;y++){
                if(n==arr[x][y]){
                    ans[0] =x+1;
                    ans[1] = y+1;
                }
                System.out.print(arr[x][y]+" ");
            }
            System.out.println();
        }
        System.out.println(ans[0]  + ans[1]);
    }
}
