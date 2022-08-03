package study.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1966 {
    static class Docs{
        int origin_idx;
        int price;

        public Docs(int origin_idx, int price) {
            this.origin_idx = origin_idx;
            this.price = price;
        }
    }
    // https://infodon.tistory.com/88
    // boolean check 쓰는 부분 참조
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        LinkedList<Docs> q ;

        for(int t=0; t<test; t++){
            q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());// 문서의 개수
            int target_idx = Integer.parseInt(st.nextToken()); // 몇 번째로 인쇄되었는지 궁금한 문서
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                q.add(new Docs(i, Integer.parseInt(st.nextToken())));

            // 처리 시작
            int count = 0;
            while(true){
                Docs now = q.poll();
                boolean now_max = true;
                for(int i=0; i<q.size(); i++){
                    // 맨 앞 보다 더 큰 값이 있으면
                    if(now.price < q.get(i).price){
                        q.add(now); // 지금 값 다시 넣고
                        for(int j=0; j<i; j++)
                            q.add(q.poll()); // 앞에 있는 값 다 다시 넣기
                        now_max = false;
                        break;
                    }
                }
                // 맨 앞보다 더 큰 값이 있어서 queue의 재배치가 이루어졌다면
                if(!now_max)
                    continue; // 아까 과정 반복
                // 멘 앞이 젤 크면
                count ++;
                // 그리고 그 맨 앞이 찾는 값이면
                if(now.origin_idx == target_idx)
                    break;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
