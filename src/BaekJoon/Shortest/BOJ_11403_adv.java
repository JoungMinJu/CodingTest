package BaekJoon.Shortest;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403_adv {

    static int[][] matrix;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 정점 개수
        int n= Integer.parseInt(br.readLine());
        // 인접행렬
        // = 그래프의 연결관계를 이차원 배열로 나타내는 것.
        matrix = new int[n][n];
        int tmp;

        // 입력
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // 갈 수 있는 길들을 큐에 추가
                if(matrix[i][j] ==1){
                    queue.add(j);
                }
            }
            while(!queue.isEmpty()){
                // 큐의 값(= 갈 수 있는 길) 꺼내서
                tmp = queue.poll();
                // BFS에 입력
                BFS(i, tmp);
            }
        }

        // 출력
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                bw.write(matrix[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void BFS(int i, int tmp){
        // 시작한 지점 i, 갈 수 있는 길 tmp
        for(int j=0; j<matrix.length; j++){
            if(matrix[tmp][j] == 1 && matrix[i][j]!=1){
                // 거쳐서 갈 수 있는 길이 있으면 찾는 것.
                queue.add(j);
            }
        }
    }
}
