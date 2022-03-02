package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
    // 체스판 한 변의 길이
    static int len;
    // 체스판
    static int arr[][];
    // 체크
    static boolean check[][];
    // 움직이기 8번
    static int[][] moved = {{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1}};
    // 큐 구현
    static Queue<int[]> q ;
    // 시작 x,y
    static int startX, startY;
    // 끝 x,y
    static int endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 테스트 케이스의 개수
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            // 체스파 한 변의 길이
            len = Integer.parseInt(br.readLine());
            arr = new int[len][len];
            check = new boolean[len][len];
            // 시작점
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            // 끝점
            st  = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();
            q.offer(new int[]{startX, startY});
            check[startX][startY] = true;
//            // 정답
//            int answer = 0;

            while(!q.isEmpty()){
                int[] current = q.poll();
                int nowX = current[0];
                int nowY = current[1];
                if(nowX == endX && nowY == endY) {System.out.println(arr[nowX][nowY]); break;}
                for(int j=0;j<8;j++){
                    int nextX = current[0] + moved[j][0];
                    int nextY = current[1] + moved[j][1];
                    if( nextX < 0 || nextX >= len || nextY < 0 || nextY >= len || check[nextX][nextY] ) continue;
                    check[nextX][nextY] =true;
                    // 거쳐갔음을 표현하기 위한 방법
                    arr[nextX][nextY] = arr[nowX][nowY] +1;
                    q.add(new int[]{nextX,nextY});
                }
            }
        }
    }
}
