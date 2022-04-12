package Algorithm_Two.CH5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Topolog_Nojam {
    //https://codingnojam.tistory.com/66
//      1. 그래프의 각 노드들의 진입 차수 테이블 생성 및 진입차수 계산
//
//  2. 진입차수가 0인 노드 큐에 넣기 (이때 어떤 노드 먼저 시작하던지 관계없음)
//
//  3. 큐에서 노드를 하나 꺼낸 후 꺼낸 노드와 간선으로 연결된 노드들의 진입차수 감소 (진입차수테이블 갱신)
//
//  4. 진입차수 테이블을 갱신 후 진입차수의 값이 0인 노드가 있다면 큐에 넣기 (없으면 아무것도 안 함)
//
//  5. 3~4번의 순서를 큐에 더 이상 아무것도 없을 때까지 반복

//    큐가 비었을 때 모든 노드들의 진입차수 또한 0 이여야 합니다.
//
//    진입차수가 0이 아닌 노드가 존재한다면 그래프에 순환구조가 있다는 얘기이므로 위상 정렬을 사용할 수 없습니다.
//

    public static void main(String[] args) throws IOException {
        // 위상정렬 결과를 출력할 객체
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // d위상 정렬에 사용할 진입 차수 저장 배열
        // 길이가 9인 이유는 인덱스를 1부터 사용하기 위해서
        int[] edgeCount = new int[9];

        // 위상 정렬에 사용할 그래프 2차원 리스트로 구현
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<9;i++){
            graph.add(new ArrayList<Integer>());
        }

        //그래프 각 노드별 인접한 노드 정보 초기화
        graph.get(1).add(2);
        graph.get(1).add(4);

        graph.get(2).add(5);
        graph.get(2).add(6);

        graph.get(3).add(6);

        graph.get(4).add(2);
        graph.get(4).add(8);

        graph.get(7).add(3);

        graph.get(8).add(6);

        // 진입 차수 테이블 초기화
        edgeCount[2]=2;
        edgeCount[3]=1;
        edgeCount[4]=1;
        edgeCount[5]=1;
        edgeCount[6]=3;
        edgeCount[8]=1;

        // 위상정렬에 사용할 큐
        Queue<Integer> q = new LinkedList<>();

        // 진입차수가 0인 값 큐에 넣기
        for(int i=1;i<edgeCount.length;i++){
            if(edgeCount[i]==0) q.offer(i);
        }

        // 큐가 빌 떄까지 반복
        while(!q.isEmpty()){
            int nodeNo = q.poll();
            // 꺼낸 노드번호 정렬 결과값에 저장
            bw.write(String.valueOf(nodeNo)+" ");

            // 꺼낸 노드의 인접 노드들
            ArrayList<Integer> list = graph.get(nodeNo);

            // 인접한 노드의 개수만큼 반복문
            for(int i=0;i<list.size();i++){
                // 인접한 노드 진입 차수 갱신
                edgeCount[list.get(i)]--;
                // 갱신되 ㄴ노드의 진입차수가 0이면 큐에 노드 넣기
                if (edgeCount[list.get(i)] == 0) {
                    q.offer(list.get(i));
                }
            }
        }
        // 결과값 출력
        bw.flush();

    }

 }
