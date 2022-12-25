package BaekJoon.Greedy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 실버 4문제
 *
 */


class Node{
  int x;
  int y;
  int time;

  Node(int x,int y,int time){
    this.x = x;
    this.y = y;
    this.time = time;
  }
}

class BJ1459 {
  public int solution(int targetX,int targetY,int w,int s) {
    int answer = 0;
    Queue<Node> queue = new LinkedList<>();
    int[][] ch = new int[10001][10001];
    queue.offer(new Node(0, 0, 0));
    ch[0][0] = 1;
    while (!queue.isEmpty()) {
      int len = queue.size();
      for (int i = 0; i < len; i++) {
        Node cur = queue.poll();
        for (int j = 0; j < 3; j++) {
          int nx;
          int ny;
          int time;
          if (j == 0) {
            nx = cur.x + 1;
            ny = cur.y;
            time = cur.time + w;
          } else if (j == 1) {
            nx = cur.x;
            ny = cur.y + 1;
            time = cur.time + w;
          } else {
            nx = cur.x + 1;
            ny = cur.y + 1;
            time = cur.time + s;
          }
          //여기까지 갈까?
          if (nx == targetX && ny == targetY) {
            if(answer==0){
              answer = time;
            } else {
              answer = Math.min(time, answer);
            }
          }
            queue.offer(new Node(nx, ny, time));
        }
      }
      if(answer!=0){
        return answer;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    BJ1459 T = new BJ1459();
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();
    int w = sc.nextInt();
    int s = sc.nextInt();
    System.out.println(T.solution(x,y,w,s));
  }
}
