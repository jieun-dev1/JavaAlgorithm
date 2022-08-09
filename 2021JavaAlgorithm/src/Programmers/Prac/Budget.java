package Programmers.Prac;

import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        int cnt = 0; //최대 갯수 세기.

        Arrays.sort(d);
        for(int i=0;i<d.length;i++) {
            sum+=d[i];
            cnt++;
        //sum 이 budget 보다 많다면, 현재 cnt 보다 하나 적게 담을 수 있으니 --를 해준다.
            if(sum>budget) {
                cnt--;
                break;
            }
        }
        answer = cnt;
        return answer;
    }
}
