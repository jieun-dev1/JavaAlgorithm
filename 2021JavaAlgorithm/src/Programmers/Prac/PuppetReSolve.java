package Programmers.Prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


//EmptyStackException �ذ�.

public class PuppetReSolve {
  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    Stack<Integer> bucket = new Stack<>();
    for(int i=0;i<moves.length;i++) {
      int currentOrder = moves[i]-1; //1-5�� ������ �־������� �迭�� 0-4�� ����.
      for(int j=0;j< board.length;j++){
        if(board[j][currentOrder]!=0){
          int temp = board[j][currentOrder];
          //stackempty exception
          if(bucket.isEmpty()) {
            bucket.push(temp);
          }
          else if(bucket.peek()!=temp){
            bucket.push(temp); //��Ŷ�� ��������� ������ �ֱ� or ��Ŷ�� �� �� ���ڰ� ���� ���ڿ� ��ġ x �־��ֱ�.
          }
          //������ ���ڿ� temp ���ڰ� ��ġ�ϰ�, bucket �� ������� ���� ��.
          else {
            bucket.pop();
            answer+=2;
            break; //�� �� �Ͷ߸��� ����, �������� �Ѿ���Ѵ�.
          }
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    PuppetReSolve T = new PuppetReSolve();
    System.out.println(T.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
  }
}
