package Programmers.Level2.Chat;

import java.util.ArrayList;
import java.util.HashMap;

public class Chat {
    // 닉네임 변경하는 방법
    // 1. 채팅방 나간 후 새로운 닉네임으로 다시 들어간다
    // 2. 채팅방에서 닉네임을 변경한다.
    // => 기존에 채팅방에 출력되어있던 메세지의 닉네임도 모두 변경된다.
    public static String[] solution(String[] record){
        StringBuilder sb;
        String answer[];
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String[]> lst = new ArrayList<>();
//        ArrayList<String> temp = new ArrayList<>();
        for (String r : record) {
            String[] input = r.split(" ");
            if(input[0].equals("Enter")){
                map.put(input[1],input[2]);
            }
            if(!input[0].equals("Change")){
                lst.add(new String[]{input[0], input[1]});
            }
            else if(input[0].equals("Change")){
                map.replace(input[1], input[2]);
            }
        }

        answer = new String[lst.size()];
        for(int i=0;i<lst.size();i++){
            sb = new StringBuilder();
            sb.append(map.get(lst.get(i)[1]));
            sb.append("님이 ");
            String order = lst.get(i)[0];
            if(order.equals("Enter")){
                sb.append("들어왔습니다.");
            }
            else if(order.equals("Leave")){
                sb.append("나갔습니다.");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] solution = solution(record);

    }
}
