package BaekJoon.Implementation;
import java.util.Scanner;

public class BOJ_1652 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            String[] seat = new String[N];
            for(int i=0;i<N;i++){
                seat[i]=sc.next();}
            // 연속 개수
            int cnt = 0;
            //가로 앉을 수 있는
            int row = 0;
            // 세로 앉을 수 있는
            int col = 0;
            // 가로
            for(int i=0;i<N;i++){
                cnt = 0;
                for(int j=0;j<seat[i].length()-1;j++){
                    if(seat[i].charAt(j) == '.' & seat[i].charAt(j+1)=='.' ) { cnt ++; }
                    if(seat[i].charAt(j) =='X') { if(cnt>=1) {row++;} cnt=0;}
                }
                if(cnt >=1) row++;
            }
            // 세로
            for(int j=0;j<N;j++) {
                cnt = 0;
                for (int i = 0; i < N - 1; i++) {
                    if (seat[i].charAt(j) == '.' & seat[i + 1].charAt(j) == '.') { cnt ++;}
                    if(seat[i].charAt(j) == 'X') {
                        if(cnt>=1){col++;}
                        cnt=0;}
                }
                if(cnt>=1) col++;
            }

            System.out.println(row+" "+col);
        }

}
