package Programmers;

import java.util.Scanner;

class Integers {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int absoLen = absolutes.length; //signs �� �迭�� ���̰� �����Ƿ�, signs���� ���� ���� ����.

        //Ǯ�� 1
        for(int i=0;i<absoLen;i++) {
            if(signs[i] == false) {
                absolutes[i] = absolutes[i]*-1;
            }
        }

        for(int i=0;i<absoLen;i++){
            answer+=absolutes[i];
        }

        //Ǯ�� 2
//         for(int i=0;i<absoLen;i++) {
//             if(signs[i] == false) {
//                 answer-=absolutes[i];
//             }
//             if(signs[i] == true) {
//                 answer+=absolutes[i];

//             }
//         }
        return answer;
    }
}
