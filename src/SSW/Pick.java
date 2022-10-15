package SSW;

import java.util.*;

class Pick {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        List<Stack<Integer>> stackList = new ArrayList<>();

        for(int col = 0; col < board[0].length; col++){
            Stack<Integer> tmpStack = new Stack<>();
            for(int row = board.length-1; row >= 0; row--){
                if(board[row][col] == 0) break;
                tmpStack.add(board[row][col]);
            }
            stackList.add(tmpStack);
        }

        for(int move : moves){
            // 각 스택에서 뽑아오기
            Stack<Integer> st  = stackList.get(move-1);
            if(stack.size() > 0 && st.size() > 0){
                if(stack.peek() == st.peek()){
                    st.pop();
                    stack.pop();
                    answer +=2;
                }
                else stack.push(st.pop());
            }
            else if(st.size()>0){
                stack.push(st.pop());
            }
        }
        return answer;
    }


}