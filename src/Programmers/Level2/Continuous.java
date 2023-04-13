package Programmers.Level2;

public class Continuous {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int answer_start = Integer.MAX_VALUE-1;
        int answer_end = -1;
        int start = 0;
        int end = 0;

        int sum = sequence[end];
        while (start <= end && start < sequence.length && end < sequence.length) {
            // System.out.println("start : "+ start);
            // System.out.println("end : " + end) ;
            // System.out.println("sum : " + sum) ;
            // System.out.println();
            if (sum == k) {
                if (Math.abs(end-start) < Math.abs(answer_end-answer_start)) {
                    answer_start = start;
                    answer_end = end;
                }
                else if ((end - start) == (answer_end - answer_start)) {
                    if (start < answer_start) {
                        answer_start = start;
                        answer_end = end;
                    }
                }
                sum -= sequence[start];
                start += 1;
            }
            else if (sum < k && end +1 < sequence.length) {
                end += 1;
                sum += sequence[end];

            }
            else {
                sum -= sequence[start];
                start += 1;
            }
        }

        answer[0] = answer_start;
        answer[1] = answer_end;
        return answer;
    }
}
