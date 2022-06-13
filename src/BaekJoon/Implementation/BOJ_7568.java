package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_7568 {
    static class Person{
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 키, 몸무게로 표현해서 등수 매겨보기
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> person_lst = new ArrayList<>();
        int weight, height;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            person_lst.add(new Person(weight, height));
        }
        for(int i=0; i<n; i++){
            int rank = 1;
            Person now = person_lst.get(i);
            for(int j=0; j<n ;j++){
                Person next = person_lst.get(j);
                if(now.height < next.height && now.weight < next.weight){
                    rank++;
                }
            }
            System.out.println(rank);
        }
    }
}
