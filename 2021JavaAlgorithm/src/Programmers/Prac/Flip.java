package Programmers.Prac;

import java.util.ArrayList;
import java.util.List;

/*
 */
public class Flip {

    public int solution(int n) {
        int answer = 0;
        List<Integer> arr = new ArrayList<>();
        //����Ʈ�� ���ʷ� �ֱ�: 3�������� �ٲٱ� ���� �ٷ� �ֱ�.
        while(n!=0) {
            arr.add(n%3);//�������� �ٷ� list �� �ְ�,
            n= n/3; //������ ������ ����.
        }

        //����Ʈ�� ���ڸ� �ٷ� 10���� ��ȯ
        for(int i=0;i<arr.size();i++) {
            if(arr.get(i)==0) continue;
            answer += Math.pow(3,arr.size()-i-1)*arr.get(i);
        }

        return answer;
    }
}
