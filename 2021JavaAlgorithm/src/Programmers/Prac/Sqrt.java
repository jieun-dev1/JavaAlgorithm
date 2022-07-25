package Programmers.Prac;

public class Sqrt {
    public long solution(long n) {
        long answer = 0;
        double result = Math.sqrt(n);
        if(result == Math.floor(result)) {
//            answer = (long) Math.pow((result+1),2); //Math.pow 활용하기.
//            answer = (long) ((result+1)*(result+1)); //OK
// 아래 코드로 하면, 일부 테스트 fail 함. answer가 Long 인데 (int)로 변환한 것이 요인
//            answer = (int)(result+1)*(int)(result+1);

        } else {
            answer = -1;
        }
        return answer;
    }
}
