package BaekJoon.Binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ_17266 {
    public static int n,m;
    public static int[] position;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 굴다리의 길이 n
        n = Integer.parseInt(br.readLine());
        // 가로등의 개수
        m = Integer.parseInt(br.readLine());
        // 설치할 수 있는 가로등의 위치 x
        position = new int[m];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            position[i] = Integer.parseInt(st.nextToken());
        }
        // 최소 비용을 위한 가로등의 최소 높이!
        // 가로등의 높이가 될 수 있는 범위 내에서 이분 탐색을 하면 된다.
        int start = 1;
        int end = n;
        int answer=0;

        while(start<=end){
            int mid =(start+end)/2;
            // 지금 mid의 길이로 모든 곳을 비출 수 있다면
            // mid 하나 줄여서 다시 돌려보기(해당 mid값은 answer에 보관)
            if(canLight(mid)){
                answer= mid;
                end= mid-1;
            }
            //  mid 길이로는 부족하다면
            // mid 하나 더 더해서 돌려보기
            else{
                start = mid+1;
            }
        }
        System.out.println(answer);
    }

    // 이게 어렵다
    // https://velog.io/@jms8732/17266.-%EC%96%B4%EB%91%90%EC%9A%B4-%EA%B5%B4%EB%8B%A4%EB%A6%AC
    // 참조했습니다ㅠ
    private static boolean canLight(int mid) {
        int start = 0;
        for(int i=0;i<m;i++){
            int left = position[i] - mid;
            int right = position[i] + mid;
            if(left > start) return false;
            start = right;
        }
        return n-start <=0;
    }
}
