package Programmers;

import java.util.Scanner;

class Integers {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int absoLen = absolutes.length; //signs 와 배열의 길이가 같으므로, signs길이 따로 받지 않음.

        //풀이 1
        for(int i=0;i<absoLen;i++) {
            if(signs[i] == false) {
                absolutes[i] = absolutes[i]*-1;
            }
        }

        for(int i=0;i<absoLen;i++){
            answer+=absolutes[i];
        }

        //풀이 2
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
