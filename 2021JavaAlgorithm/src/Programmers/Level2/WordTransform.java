package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class WordTransform {
    public int solution(String begin, String target, String[] words) {
      int answer = 0;
      //���� target�� words�� ���� ���, ���� 0��.
      boolean flag = false;
      for(int i=0;i<words.length;i++){
        //==���� ���� ��, intelliJ�� 4�� ��ȯ��������, ���α׷��ӽ� �ڵ�� 0 ��ȯ.
        if(target.equals(words[i])){
          flag = true;
          break; //target�� �����ϴϱ� �ٷ� break ���ش�.
        }
      }
      if(flag==false){
        return 0;
      }
      int[] ch = new int[words.length+1];

      Queue<String> queue = new LinkedList<>();
      queue.offer(begin);

      while(!queue.isEmpty()){
        int len = queue.size();
        for(int i=0;i<len;i++){
          String temp = queue.poll();
          for(int j=0;j<words.length;j++){
            //��ǥ ���� ���� �ߴٸ�,
            if(temp.equals(target)){
              return answer;
            }
            if(ch[j]==0&&checkIfTarget(temp, words[j])){
              queue.offer(words[j]);
              ch[j]=1; //ch �迭��
            } //�� ����� temp�� ���� ��ȸ�ϴ� �ܾ�
          }
        }
        answer++;
      }
      return answer;
    }

    //�� ���ڸ� �ٸ� ���ڶ�� Target���� BFS�� �Ѿ�ϴ�.
    public boolean checkIfTarget(String temp, String compared){
      //��� �ܾ� ���̰� ���� �����̴�.
      //char�� ���� ��ȣ�� ��, Character�� ���� equals�� compare �� �� ����.
      int notEqual = 0;
      for(int i=0;i<temp.length();i++){
        if(temp.charAt(i)!=(compared.charAt(i))){
          notEqual++;
        }
      }
      if(notEqual==1){
        return true;
      }
      return false;
    }

  public static void main(String[] args) {
    WordTransform T = new WordTransform();
    System.out.println(T.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    System.out.println(T.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
  }
}
