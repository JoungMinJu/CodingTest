package Programmers.SKT_2022;

public class Second {
    // 연간 납부 금액 = 이번 달을 포함한 최근 12개월간의 납부 금액 총합
    // 납부 내역 + 납부 예정 금액 분석
    // -> 이번달 VIP x -> 다음달 VIP
    // -> 이번달 VIP -> 다음달 VIPx

    public int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int sum_payments = 0; // 납부 금액 합계
        int[] answer = new int[2];

        for(int i=0; i<periods.length; i++){// i+1 번째 고객 대상
            // 총 납부 금액 계산
            sum_payments = 0;
            for(int j=0; j<payments[i].length;j++) sum_payments += payments[i][j];

            // VIP 여부 계산
            boolean now_vip = isVIP(periods[i], sum_payments);
            boolean next_vip = isVIP(periods[i]+1, sum_payments-payments[i][0]+estimates[i]);

            // 이번달 VIP 아닌데 -> 다음달 VIP된다면
            if(!now_vip && next_vip) answer[0] ++;
            // 이번달 VIP인데 -> 다음달 VIP 아니라면
            else if(now_vip && !next_vip) answer[1]++;}
        return answer;
    }

    private boolean isVIP(int period, int payment) {
        if(period >= (12*5)) {
            if(payment >= 600000) return true;
        }
        else if(period >= (12*2)){
            if(payment >= 900000) return true;
        }
        return false;
    }

}
