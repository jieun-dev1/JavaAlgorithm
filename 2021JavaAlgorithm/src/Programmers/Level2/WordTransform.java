package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class WordTransform {
    public int solution(String begin, String target, String[] words) {
      int answer = 0;
      //만약 target이 words에 없을 경우, 답은 0임.
      boolean flag = false;
      for(int i=0;i<words.length;i++){
        //==으로 했을 때, intelliJ는 4를 반환해주지만, 프로그래머스 코드는 0 변환.
        if(target.equals(words[i])){
          flag = true;
          break; //target이 존재하니까 바로 break 해준다.
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
            //목표 점에 도달 했다면,
            if(temp.equals(target)){
              return answer;
            }
            if(ch[j]==0&&checkIfTarget(temp, words[j])){
              queue.offer(words[j]);
              ch[j]=1; //ch 배열이
            } //비교 대상인 temp와 현재 조회하는 단어
          }
        }
        answer++;
      }
      return answer;
    }

    //한 글자만 다른 문자라면 Target으로 BFS가 넘어갑니다.
    public boolean checkIfTarget(String temp, String compared){
      //모두 단어 길이가 같기 때문이다.
      //char일 때는 등호로 비교, Character일 때는 equals나 compare 로 비교 가능.
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
