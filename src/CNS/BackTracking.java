package CNS;

import java.util.*;

public class BackTracking {
    static int[][] problem;

    static class Node {
        int[] types;
        List<Integer> problems;

        public Node(int[] types, List<Integer> problems) {
            this.types = Arrays.copyOf(types, types.length);
            this.problems = new ArrayList<>(problems);
        }

        public String toString() {
            return Arrays.toString(types) + "    " + problems.toString();
        }
    }

    public static void main(String[] args) {
        int[][] problems1 = new int[][]{{1, 1, 0, 0, 1},
                {1, 0, 0, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1}};
        int[][] problems2 = new int[][]{{0, 0, 0, 1},
                {0, 1, 0, 1},
                {1, 0, 0, 1},
                {0, 0, 1, 0}};
        System.out.println(Arrays.toString(solution(problems1))); // -> [1, 3];
        System.out.println(Arrays.toString(solution(problems2))); // -> [1, 2, 4]
    }

    public static int[] solution(int[][] problems) {
        problem = problems;
        int problemSize = problems.length;
        int typeSize = problems[0].length;

        return bfs(new int[typeSize], -1);
    }

    private static int[] bfs(int[] types, int problemIdx) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(types, new ArrayList<>()));
        Node now;
        int[] nowTypes;
        List<Integer> nowProblems;

        while (!que.isEmpty()) {
            problemIdx++;
            if(problemIdx >= problem.length) {
                break;
            }
            int queSize = que.size();

            for (int size = 0; size < queSize; size++) {
                now = que.poll();
                if (isSuccess(now)) {
                    return now.problems.stream().mapToInt(i->i).toArray();
                }
                nowTypes = now.types;
                nowProblems = now.problems;
                que.add(new Node(nowTypes, nowProblems));
                update(nowTypes, problemIdx);
                Node newNode = new Node(nowTypes, nowProblems);
                newNode.problems.add(problemIdx+1);
                que.add(newNode);
            }

        }

        while(!que.isEmpty()) {
            now = que.poll();
            if (isSuccess(now)) {
                return now.problems.stream().mapToInt(i->i).toArray();
            }
        }

        return new int[]{0};
    }

    private static void update(int[] types, int problemIdx) {
        int[] p = problem[problemIdx];

        for (int i = 0; i < types.length; i++) {
            types[i] += p[i];
        }
    }

    private static boolean isSuccess(Node node) {
        int[] types = node.types;
        for (int type : types) {
            if (type < 1) {
                return false;
            }
        }
        return true;
    }
}
