package Programmers.Prac;

import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        int cnt = 0; //�ִ� ���� ����.

        Arrays.sort(d);
        for(int i=0;i<d.length;i++) {
            sum+=d[i];
            cnt++;
        //sum �� budget ���� ���ٸ�, ���� cnt ���� �ϳ� ���� ���� �� ������ --�� ���ش�.
            if(sum>budget) {
                cnt--;
                break;
            }
        }
        answer = cnt;
        return answer;
    }
}
