package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_10814 {

    static class Member implements Comparable<Member>{
        int id;
        int age;
        String name;

        Member(int id, int age, String name){
            this.id = id;
            this.age = age;
            this.name = name;
        }
        @Override
        public int compareTo(Member m){
            // 현재 객체 < 파라미터로 넘어온 객체 == return 음수
            // 현재 객체 == 파라미터로 넘어온 객체 == return 0
            // 현재 객체 > 파라미터로 넘어온 객체 == return 양수
            if(this.age == m.age){
                return this.id - m.id;
            }
            return this.age - m.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        // 회원 수
        int n = Integer.parseInt(br.readLine());
        // 회원 리스트
        ArrayList<Member> lst = new ArrayList<Member>();

        for(int i =0;i<n;i++){
            //회원의 나이와 이름
            String[] temp  = br.readLine().split(" ");
            lst.add(new Member(i, Integer.parseInt(temp[0]), temp[1]));
        }
        Collections.sort(lst);
        for(int i=0;i<n;i++){
            if(lst.get(i) != null){
                System.out.println(lst.get(i).age + " "+lst.get(i).name);
            }
        }


    }
}
