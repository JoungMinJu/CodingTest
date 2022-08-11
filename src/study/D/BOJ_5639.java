package study.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
    static class Node{
        Node left, right, root;
        int data;

        public Node(int data){
            this.data = data;
        }
    }

    static class Tree{
        Node root;

        public Tree(Node root){
            this.root = root;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Node root_node = new Node(Integer.parseInt(input));
        Tree tree = new Tree(root_node);

        // root 채우고
        // 왼쪽으로 쭉 채우다가
        // 그 다음 값이 나보다 크면
        // 나의 root의 오른쪽에 넣어주기

        while(true){
            input = br.readLine();
            if(input == null ) break;
            int now_data = Integer.parseInt(input);
            Node now_node = new Node(now_data);
            if(now_data < root_node.data && root_node.left == null){
                now_node.root = root_node;
                root_node.left = now_node;
                root_node = root_node.left;
            }
            else if(now_data > root_node.data ){
                root_node = root_node.root;
                while(root_node.right != null){
                    root_node = root_node.root;
                }
                now_node.root = root_node;
                root_node.right = now_node;
                root_node = root_node.right;
            }


        }
    }
}
