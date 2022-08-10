package study.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1991 {
    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
        }
    }

    static class Tree{
        Node root;

        public void createNode(char data, char left, char right){
            if(root==null) {
                root = new Node(data);
                if(left != '.') root.left = new Node(left);
                if(right != '.') root.right = new Node(right);
            }// 이미 루트 있으면
            else
                searchNode(root, data, left, right);

        }

        public void searchNode(Node root, char data, char left, char right){
            // root는 현재 tree의 루트를 의미
            if(root == null) return;
            else if(root.data == data) {// 들어갈 위치를 찾았다면
                if(left != '.')
                    root.left = new Node(left);
                if(right != '.')
                    root.right = new Node(right);
            }
            else{
                searchNode(root.left, data, left, right); // 왼쪽 재귀 탐색
                searchNode(root.right, data, left, right);
            }

        }


        // 전위순회
        public void preorder(Node root){
            System.out.print(root.data);
            if(root.left != null) preorder(root.left);
            if(root.right != null) preorder(root.right);
        }

        // 중위순회
        public void inorder(Node root){
            if(root.left != null) inorder(root.left);
            System.out.print(root.data);
            if(root.right != null) inorder(root.right);
        }

        // 후위순회
        public void postorder(Node root){
            if(root.left != null) postorder(root.left);
            if(root.right != null) postorder(root.right);
            System.out.print(root.data);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 이진 트리 노드의 개수

        Tree tree = new Tree();
        for(int i=0; i<n; i++){
            char[] data;
            data = br.readLine().replaceAll(" ", "").toCharArray();
            tree.createNode(data[0], data[1], data[2]);
        }

        tree.preorder(tree.root);
        System.out.println();

        tree.inorder(tree.root);
        System.out.println();

        tree.postorder(tree.root);
        System.out.println();
    }
}
