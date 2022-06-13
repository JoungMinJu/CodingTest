package Programmers.SKT_2022;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Third {
    class Plan{
        int give_data;
        ArrayList<Integer> give_service =new ArrayList<>();

        public Plan(String[] input) {
            give_data = Integer.parseInt(input[0]);
            for(int i=1;i<input.length;i++){
                give_service.add(Integer.parseInt(input[i]));
            }
        }

        public void add_service(ArrayList<Integer> prev_service) {
            give_service.addAll(prev_service);
        }
    }

    class Client{
        int use_data;
        ArrayList<Integer> use_service = new ArrayList<>();

        Client(String[] input){
            use_data = Integer.parseInt(input[0]);
            for(int i=1;i<input.length; i++){
                use_service.add(Integer.parseInt(input[i]));}
        }
    }

    public int[] solution(int n, String[] plans, String[] clients) {
        int[] answer = new int[clients.length];
        ArrayList<Plan> plan_lst = new ArrayList<>();
        ArrayList<Client> client_lst = new ArrayList<>();

        // Plan 배열 초기화
        for(int i=0; i<plans.length; i++){
            if(plan_lst.isEmpty())
                plan_lst.add(new Plan(plans[i].split(" ")));
            else{ // 비어있지 않다면
                // 이전 plan이 제공하던 서비스 가져옴
                ArrayList<Integer> prev_service = plan_lst.get(plan_lst.size()-1).give_service;
                Plan new_plan = new Plan(plans[i].split(" "));
                new_plan.add_service(prev_service); // 이전 서비스 더해주고
                plan_lst.add(new_plan);
            }}
        // Client 배열 초기화
        for(int j=0; j<clients.length; j++)
            client_lst.add(new Client(clients[j].split(" ")));

        // 각 고객마다 찾아보기
        for(int i=0; i<client_lst.size();i++){
            int result = 0;
            for(int j=0; j<plan_lst.size(); j++) {
                if (client_lst.get(i).use_data <= plan_lst.get(j).give_data) {
                    // 클라이언트가 원하는 서비스
                    ArrayList<Integer> use_service = client_lst.get(i).use_service;
                    // 플랜이 제공하는 서비스
                    ArrayList<Integer> give_service = plan_lst.get(j).give_service;
                    if (isContain(use_service, give_service)) {
                        Arrays.toString(new ArrayList[]{use_service});
                        result = j;
                        break;
                    }
                }
            }
            answer[i] = result;
        }
        return answer;
    }

    private boolean isContain(ArrayList<Integer> use_service, ArrayList<Integer> give_service) {
        for(int i=0; i<use_service.size();i++){
            if(!give_service.contains(use_service.get(i))){
                return false;
            }
        }
        return true;
    }


}
