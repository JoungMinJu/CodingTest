package study.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_21608 {
    static int n ;
    static int[][] map; // 누구 앉았는지
    static int[][] like; // 좋아하는 사람 인접한 칸에 몇 명 있는지
    static int[][] empty; // 빈칸 몇 개 있는지
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] score = {0, 1, 10,100,1000};

    static class Student{
        int x,y; // 위치
        int number;
        ArrayList<Integer> friends_number;

        public Student(int number) {
            this.number = number;
            this.friends_number = new ArrayList<>();
            this.x = -1;
            this.y = -1;
        }

        public void add_friends(int friend_number){
            this.friends_number.add(friend_number);
        }

        public void set_pos(int x,int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer, Student> student_map = new HashMap<>();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n]; // 누가 앉았는가
        empty = new int[n][n]; // 비어있는 칸이 몇 개인가는 모든 학생에게 static

        // 빈칸 업데이트
        find_empty();

        for(int i=0; i<n*n; i++){
            st = new StringTokenizer(br.readLine());
            Student new_student = new Student(Integer.parseInt(st.nextToken()));
            for(int j=0; j<4; j++)
                new_student.add_friends(Integer.parseInt(st.nextToken()));

            // 이거 순서대로 앉힐 것이므로 student_lst에 있는지가 포인트
            like = new int[n][n];
            for (Integer integer : new_student.friends_number) {
                if(student_map.containsKey(integer)){ // 이미 좋아하는 학생이 앉아 있으면
                    Student like_friend = student_map.get(integer);
                    for(int j=0; j<4; j++){
                        int nextX = like_friend.x + dx[j];
                        int nextY = like_friend.y + dy[j];
                        if(nextX >=0 && nextX<n && nextY >=0 && nextY <n){
                            if(map[nextX][nextY] == 0) // 인접 칸이 비어있으면
                                like[nextX][nextY] ++; // like 수 증가시키기.
                        }
                    }
                }
            }

            int empty_cnt = Integer.MIN_VALUE;
            int like_cnt = Integer.MIN_VALUE;
            int posX = -1;
            int posY = -1;

            for(int nowX = 0; nowX < n; nowX++){
                for(int nowY =0; nowY <n; nowY++){
                    if(map[nowX][nowY] != 0) continue; // 자리 차지 되어있는애는 넘기고
                    if(like_cnt < like[nowX][nowY]){
                        posX = nowX;
                        posY = nowY;
                        like_cnt = like[nowX][nowY];
                        empty_cnt = empty[nowX][nowY];
                    }
                    else if(like_cnt == like[nowX][nowY] && empty_cnt < empty[nowX][nowY]){
                        posX = nowX;
                        posY = nowY;
                        empty_cnt = empty[nowX][nowY];
                    }
                }
            }
            // 앉히면 -> empty 업데이트 + studentmap에서 꺼내서 pos.x, pos.y 업데이트
            new_student.x = posX;
            new_student.y = posY;
            map[posX][posY] = new_student.number;
            for(int p = 0; p<4; p++){
                int nX = posX + dx[p];
                int nY = posY + dy[p];
                if(nX>=0 && nX<n && nY>=0 && nY<n){
                    empty[nX][nY]--;
                }
            }
            student_map.put(new_student.number, new_student);
        }
        // 점수 계산
        int answer =0;
        for (Integer key : student_map.keySet()) {
            Student now_student = student_map.get(key);
            int count = 0;
            for(int i=0; i<4; i++){
                int nX = now_student.x + dx[i];
                int nY = now_student.y + dy[i];
                if(nX >=0 && nX<n && nY>=0 && nY <n){
                    if(now_student.friends_number.contains(map[nX][nY])){
                      count++;
                    }
                }
            }
            answer += score[count];
        }
        System.out.println(answer);

    }

    private static void find_empty() {
        for(int nowX=0; nowX<n; nowX++){
            for(int nowY=0; nowY<n; nowY++){
                int count = 0;
                for(int k=0; k<4; k++){
                    if((nowX+dx[k])>=0 && (nowX+dx[k])<n && (nowY+dy[k])>=0 && (nowY+dy[k])<n){
                        if(map[nowX+dx[k]][nowY+dy[k]]==0)
                            count++;
                    }
                }
                empty[nowX][nowY] = count;
            }
        }
    }


}
