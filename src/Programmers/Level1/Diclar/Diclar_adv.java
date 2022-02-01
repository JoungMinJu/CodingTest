package Programmers.Level1.Diclar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Diclar_adv {
    // reporter = 신고를 한 유저
    // singo = 신고를 당한 유저
    // reporterArr = 신고를 한 사람을 저장하는 HashMap
    //      key = 신고를 한 유저(String)
    //      value = key가 신고한 유저들의 집합
    // singoArr =  신고 당한 사람을 저장하는 HashMap
    //      key = 신고 당한 유저
    //      value = key가 신고 당한 횟수
    // answer = 결과값
    public int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        HashMap<String, Set<String>> reporterArr = new HashMap<>();
        HashMap<String, Integer> singoArr = new HashMap<String, Integer>();

        // 초기화
        for(String id: id_list){
            singoArr.put(id,0);
            reporterArr.put(id, new HashSet<String>());
        }
        // 신고된 사람들
        for(String cur : report){
            StringTokenizer st = new StringTokenizer(cur, " ");
            String reporter = st.nextToken();
            String singo = st.nextToken();
            if(reporterArr.get(reporter).add(singo)){
                singoArr.put(singo, singoArr.get(singo)+1);
            }
        }
        // 신고한 사람
        for(String cur : report){
            StringTokenizer st =new StringTokenizer(cur, " ");
            String reporter = st.nextToken();
            String singo = st.nextToken();
            // 본인이 신고한 사람의 신고 당한 횟수가 K 이상일 경우
            if(singoArr.get(singo)<k){
                reporterArr.get(reporter).remove(singo);
            }
            for(int i=0;i<id_list.length;i++){
                answer[i] = reporterArr.get(id_list[i]).size();
            }
        }
        return answer;
    }
}
