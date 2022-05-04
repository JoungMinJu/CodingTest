package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {
    public static class Node{
        int index;
        ArrayList<Node> neighbors ;
        Node root;

        public Node(int index) {
            this.index = index;
            this.neighbors = new ArrayList<>();
            this.root = null;
        }

        public void setNeighbors(Node neighbor) {
            this.neighbors.add(neighbor);
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            Node[] nodeList = new Node[n+1];
            for(int i=1;i<=n;i++){
                nodeList[i] = new Node(i);
            }
            for(int i=0;i<n-1;i++){
                st= new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                nodeList[first].setNeighbors(nodeList[second]);
                nodeList[second].setNeighbors(nodeList[first]);
            }
            for(int i=1;i<=n;i++){
                setRoot(nodeList[i]);
            }

            for(int i=2;i<=n;i++){
                System.out.println(nodeList[i].root.index);
            }
        }

        private static void setRoot(Node node) {
            if(node.neighbors.size()==0) return;
            ArrayList<Node> neighbors = node.neighbors;
            for (Node neighbor : neighbors) {
                if(neighbor.root==null)
                {neighbor.root = node;
                setRoot(neighbor);}
            }
        }
    }
}
