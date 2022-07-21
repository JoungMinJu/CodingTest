package study.second;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int direct[][] = new int[n][m];

        // 배열
        int map[][] = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j <m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 도는 위치
//        char d[] = {'d','r','u','l', 'n'};
        int d[] = {1,2,3,4};
        // 내려가는 방향
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        int index = 0;

        int i=0;
        int j=0;
        direct[i][j] = d[index];
        // 해당 위치에서 움직여야하는 방향이 저장되어있는 direct 배열 만들기
        while(true){
            // i와 j가 채워지기 전 중에서 이동의 맨 끝이어야만한다.
            i += dx[index];
            j += dy[index];

            if(i== -1 || j == -1 || i==n || j==m || direct[i][j]!=0){
                i -= dx[index];
                j -= dy[index];
                index = (index+1)%4;
                if(direct[i][j] != 0 && index == 0){
                    i+=1;
                    index = 0;
                    if(direct[i][j] != 0) {
                        // 이미 차있으면
                        // 이전 위치의 값을 4로 바꿔주고 // 이게 아직 구현 안됨
                        direct[i-1][j] = 4;
                        break;
                    }
                    direct[i][j] = d[index];
                    if(isFull(direct))
                        direct[i][j] = 5; // 움직이지 않는다는 의미
                    continue;
                }
            }
            direct[i][j] = d[index];
            if(isFull(direct))
                break;
        }

        for(int x = 0; x<n; x++){
            for(int y=0; y<m; y++)
                System.out.print(direct[x][y] + " ");
            System.out.println();
        }

        int[][] answer = new int[n][m];

        for(int t=0; t<r; t++){
            for(int x=0; x<n; x++){
                for(int y=0; y<m; y++){
                    int now = map[x][y];
                    int nX = x+dx[direct[x][y]-1];
                    int nY = y+dy[direct[x][y]-1];
                    answer[nX][nY] = now;
                }
            }
        }
        for(int x=0; x<n; x++){
            for(int y=0; y<m; y++)
                System.out.print(answer[x][y] + " ");
            System.out.println();
        }


    }

    private static boolean isFull(int[][] direct) {
        for(int i=0; i<direct.length;i++){
            for(int j=0; j<direct[0].length; j++){
                if(direct[i][j] == 0) // 빈 칸이 있으면
                    return false;
            }
        }
        return true;
    }
}
