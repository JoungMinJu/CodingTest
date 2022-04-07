package BaekJoon.Binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 참조 https://kistone.tistory.com/39
public class BOJ_19637 {
    static class Name {
        private String name;
        private int max_power;

        // 칭호는 전투력 상한값의 내림차순이 아닌..

        public Name(String name, int max_power) {
            this.name = name;
            this.max_power = max_power;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMax_power() {
            return max_power;
        }

        public void setMax_power(int max_power) {
            this.max_power = max_power;
        }

    }
    // 칭호의 개수
    static int n;
    // 칭호를 출력해야하는 캐릭터들의 개수
    static int m;
    // 칭호 리스트
    static ArrayList<Name> name_list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String name =st.nextToken();
            int max_power = Integer.parseInt(st.nextToken());
            name_list.add(new Name(name, max_power));
        }

        // 시간 줄이기 위한 선택
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            int score = Integer.parseInt(br.readLine());
            // 이진탐색
            String str = BinarySearch(score);
            sb.append(str).append("\n");
        }
        // 출력
        System.out.println(sb.toString());
    }

    private static String BinarySearch(int score) {
        int start = 0;
        int end = name_list.size()-1;
        while(start<=end){
//            System.out.println("-----");
//            System.out.println("score = " + score);
//            System.out.println("start = " + start);
//            System.out.println("name_list.get(start) = " + name_list.get(start).getMax_power());
//            System.out.println("end = " + end);
//            System.out.println("end = " + name_list.get(end).getMax_power());
            int mid = (start+end)/2;
//            System.out.println("mid = " + mid);
//            System.out.println("name_list.get(mid) = " + name_list.get(mid).getMax_power());

            if(score > name_list.get(mid).getMax_power()) start = mid+1;
            else end = mid-1;
        }
//        System.out.println("end+1 = " + end+1);
//        System.out.println("name_list.get(end+1) = " + name_list.get(end + 1).getMax_power());
//        System.out.println("name_list.get(end+1).getName() = " + name_list.get(end+1).getName());
//        System.out.println();
        // else인 경우 end = mid-1을 해주기 떄문에..!
        return name_list.get(end+1).getName();
    }


}
