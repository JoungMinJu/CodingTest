package Programmers.Level1.Runner;
import java.util.HashMap;
public class Runner_advanced {
    //해시를 사용해야하는 문제
    public String solution(String[] participant, String[] completion){
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        //getOrDefalut(Object key, V DefaultValue)
        // key는 값을 가져와야하는 요소의 키
        // 지정된 키로 매핑된 값이 없는 경우 반환되어야하는 긔본 값
        for(String player : participant) hm.put(player, hm.getOrDefault(player,0)+1);
        for(String player : completion) hm.put(player, hm.get(player)-1);

        for(String key : hm.keySet()){
            if(hm.get(key)!=0){
                answer = key;
            }
        }
        return answer;
    }
}
