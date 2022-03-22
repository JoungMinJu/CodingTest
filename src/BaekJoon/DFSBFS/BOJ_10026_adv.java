package BaekJoon.DFSBFS;

import java.util.Scanner;

public class BOJ_10026_adv {
    static int n;
    static String s;
    static char map[][];
    static boolean visit[][];
    static int dx[] = {0,0,1,-1 };
    static int dy[] = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new char[n+1][n+1];
        visit = new boolean[n+1][n+1];

        for(int i=0;i<n;i++){
            s = sc.next();
            for(int j=0;j<n;j++){
                map[i][j] = s.charAt(j);
            }
        }

        // 일반
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        int normal_cnt = cnt;
        // 초기화
        cnt=0;
        visit = new boolean[n+1][n+1];

        // 색약인 경우
        // G를 그냥 R로 바꿈.
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] =='G'){
                    map[i][j] = 'R';
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    // 요것이 중요한 포인트
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        int abnormal_cnt = cnt;
        System.out.println(normal_cnt+" "+abnormal_cnt);

    }
    public static void dfs(int x, int y){
        visit[x][y] =true;
        char tmp_char = map[x][y];
        for(int i=0;i<4;i++){
            int newX = x+dx[i];
            int newY = y + dy[i];

            if(newX>=0 && newX <=n && newY >=0 && newY <=n){
                if(!visit[newX][newY] && map[newX][newY] ==tmp_char){
                    dfs(newX, newY);
                }
            }
        }
    }
}
