package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13305 {
    static class City{
        public int price;
        public int next_road;

        public City(int price, int next_road) {
            this.price = price;
            this.next_road = next_road;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 1km -> 1리터의 기름
        // 각 도시에 단 하나의 주유소. 주유소의 리터당 가격 다름
        // 도시의 개수
        int n = Integer.parseInt(br.readLine());
        // 도시 배열
        ArrayList<City> cityList = new ArrayList<City>();
        // 도로의 길이
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++){
            cityList.add(new City(0, Integer.parseInt(st.nextToken())));
        }
        // 주유소 가격
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            if(i==n-1){
                cityList.add(new City(Integer.parseInt(st.nextToken()), 0));
            }
            else {
                cityList.get(i).setPrice(Integer.parseInt(st.nextToken()));
            } }
        // 계산
        int oil_price = Integer.MAX_VALUE;
        int answer = 0;
        for(int i=0;i<n;i++){
            int now = cityList.get(i).price;
            oil_price = oil_price > now ? now : oil_price;
            answer += oil_price*cityList.get(i).next_road;
        }
        System.out.println(answer);
    }
}
