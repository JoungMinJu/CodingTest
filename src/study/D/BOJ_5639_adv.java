package study.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639_adv {
    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }

        void insert(int data){
            if(data < this.data){
                // root 보다 작으면
                if(this.left == null) this.left = new Node(data);
                else this.left.insert(data);
            }
            else { // root 보다 크면 (오른쪽 자식)
                if(this.right == null) this.right = new Node(data);
                else this.right.insert(data);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true){
            String input = br.readLine();
            if(input == null) break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    private static void postOrder(Node root){
        if(root.left != null) postOrder(root.left);
        if(root.right != null) postOrder(root.right);
        System.out.println(root.data);
    }
}
