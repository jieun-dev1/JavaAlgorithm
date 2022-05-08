package Inflearn.DFS;

//10. Tree 말단 가장 짧은 경로.
import java.util.LinkedList;
import java.util.Queue;

class Node4{
    int data;
    Node4 lt, rt;
    public Node4(int val){
        data = val;
        lt=rt=null;
    }
}


public class RouteBPS {
    Node4 root;
    public int BFS(Node4 root){
        Queue<Node4> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                Node4 cur = Q.poll();
                if(cur.lt == null && cur.rt == null) return L; //말단 노드라는 뜻
                if(cur.lt != null) Q.offer(cur.lt);
                if(cur.rt != null) Q.offer(cur.rt);
            }

            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RouteBPS tree = new RouteBPS();
        tree.root = new Node4(1);
        tree.root.lt = new Node4(2);
        tree.root.rt = new Node4(3);
        tree.root.lt.lt = new Node4(4);
        tree.root.lt.rt = new Node4(5);
        System.out.println(tree.BFS(tree.root));
    }
}
